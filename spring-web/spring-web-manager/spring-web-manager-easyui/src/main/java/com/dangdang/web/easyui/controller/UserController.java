package com.dangdang.web.easyui.controller;

import com.alibaba.fastjson.JSONObject;
import com.dangdang.repository.mysql.mapper.easyui.entity.*;
import com.dangdang.service.biz.service.*;
import com.github.pagehelper.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * 用户相关的操作
 */
@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;// 用户模块

    @Autowired
    private CartService cartService;// 购物车模块

    @Autowired
    private GoodsService goodsService;// 商品模块

    @Autowired
    private NewsCommentService newsCommentService;// 资讯评论模块

    @Autowired
    private GoodsCommentService goodsCommentService;// 商品评论模块

    @Autowired
    private AddressService addressService; // 地址管理模块

    @Autowired
    private CollectService collectService;// 收藏模块

    /**
     * 查询所有非管理员用户
     * @param page  第几页
     * @param rows  每页多少行数据
     * @return
     */
    @RequestMapping("/findAll")
    @ResponseBody
    public String findAll(@RequestParam(required = false, defaultValue = "1") Integer page ,
                          @RequestParam(required = false, defaultValue = "10") Integer rows) {
        Page<User> users = userService.findAll(page , rows);
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("rows", users);
        jsonObject.put("total", userService.countUser());

        String s = JSONObject.toJSONStringWithDateFormat(jsonObject, "yyyy-MM-dd");
        return s;
    }

    /**
     * 添加用户
     *
     * @param user
     */
    @RequestMapping("/addUser")
    @ResponseBody
    public void addUser(User user) {
        userService.register(user);
    }

    /**
     * 删除用户信息
     *
     * @param usid
     */
    @ResponseBody
    @GetMapping("/removeUser/{usid}")
    public void removeUser(@PathVariable("usid") String usid) {
        userService.removeUser(usid);
    }


    /**
     * 修改用户信息
     *
     * @param user
     */
    @RequestMapping("/modifyUser")
    @ResponseBody
    public void modifyUser(User user) {
        userService.modifyUser(user);
    }


    /**
     * 跳转到更新界面
     *
     * @return
     */
    @GetMapping("/toModifyUser/{usid}")
    public String toModifyUser(@PathVariable("usid") String usid, Model model) {
        User user = userService.findById(usid);
        model.addAttribute("user", user);
        return "user/userupdate";
    }


    /**
     * 查询购物车
     *
     * @return
     */
    @GetMapping("/toUserCart/{id}")
    public String toUserCart(@PathVariable("id") String id, Model model) {
        List<Cart> carts = cartService.findByUserId(id);
        model.addAttribute("carts", carts);// 存放数据
        return "user/usercart";
    }

    /**
     * 查询用户评论
     *
     * @param userid
     * @return
     */
    @GetMapping("/toUserComment/{id}")
    public String toUserComment(@PathVariable("id") String userid, Model model) {

        List<NewsComment> newsComments = newsCommentService.findByUserId(userid);
        List<GoodsComment> goodsComments = goodsCommentService.findByUserId(userid);
        model.addAttribute("newsComments", newsComments);
        model.addAttribute("goodsComments", goodsComments);
        return "user/usercomment";

    }


    /**
     * 用户地址信息
     * @param userid
     * @param model
     * @return
     */
    @GetMapping("/toUserAddress/{id}")
    public String toUserAddress(@PathVariable("id") String userid, Model model) {
        List<Address> addresses = addressService.findByUserId(userid);
        model.addAttribute("addresses", addresses);
        return "user/useraddress";

    }

    /**
     * 查看用户详细信息
     * @param userid
     * @param model
     * @return
     */
    @GetMapping("/toUserInfo/{id}")
    public String toUserInfo(@PathVariable("id") String userid , Model model){
        User user = userService.findById(userid);
        model.addAttribute("userInfo" , user);
        return "user/userinfo";
    }


    /**
     * 用户收藏新消息
     * @param userid
     * @param model
     * @return
     */
    @GetMapping("/toUserCollect/{id}")
    public String toUserCollect(@PathVariable("id") String userid , Model model){
        List<Collect> byUser = collectService.findByUser(userid);
        model.addAttribute("collect" , byUser);
        return "user/usercollect";
    }

    /**
     * 用户登录
     * @param user
     * @param session
     * @return
     */
    @RequestMapping({"/login"})
    public String login(User user, HttpSession session){

        User login = userService.login(user);
        session.setAttribute("userSession", login);
        return "redirect:/user/index.htm";
    }


    /**
     *
     * @param session
     * @return
     */
    @RequestMapping("/logout")
    public String logout(HttpSession session){
        session.invalidate();// session失效
        return "redirect:/user/index.htm";
    }




    /*页面跳转部分*/

    /**
     * 跳转到主界面
     *
     * @return
     */
    @RequestMapping("/index.htm")
    public String toIndex() {
        System.out.println("------------");
        return "index";
    }

    /**
     * 跳转到主界面
     *
     * @return
     */
    @RequestMapping("/main.htm")
    public String main() {
        return "user/userlist";
    }

    /**
     * 跳转到添加用户界面
     *
     * @return
     */
    @RequestMapping("/toAddUser")
    public String toAddUser() {
        return "user/useradd";
    }

    /**
     * 界面跳转
     * @return
     */
    @RequestMapping({"/","/login.htm"})
    public String toLogin(){
        return "login";
    }


}
