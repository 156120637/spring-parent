package com.dangdang.web.easyui.controller;

import com.alibaba.fastjson.JSONObject;
import com.dangdang.repository.mysql.mapper.easyui.entity.Category;
import com.dangdang.repository.mysql.mapper.easyui.entity.Goods;
import com.dangdang.repository.mysql.mapper.easyui.entity.GoodsComment;
import com.dangdang.repository.mysql.mapper.easyui.entity.Shop;
import com.dangdang.service.biz.service.CategoryService;
import com.dangdang.service.biz.service.GoodsCommentService;
import com.dangdang.service.biz.service.GoodsService;
import com.dangdang.service.biz.service.ShopService;
import com.dangdang.common.utils.easyui.util.FileUploadUtil;
import com.github.pagehelper.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.util.List;

@Controller
@RequestMapping("/goods")
public class GoodsController {

    @Autowired
    private GoodsService goodsService;

    @Autowired
    private ShopService shopService;

    @Autowired
    private CategoryService categoryService;

    @Autowired
    private GoodsCommentService goodsCommentService;



    /**
     * 查询所有的数据
     *
     * @return
     */
    @RequestMapping("/findAll")
    @ResponseBody
    public String findAll(@RequestParam(required = false, defaultValue = "1") Integer page ,
                          @RequestParam(required = false,defaultValue = "10") Integer rows ) {

//        List<Goods> goods = goodsService.findAll();
        Page<Goods> byPage = goodsService.findByPage(page, rows);
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("rows",byPage);
        jsonObject.put("total", goodsService.countGoods());
        String s = JSONObject.toJSONStringWithDateFormat(jsonObject, "yyyy-MM-dd");
        return s;
    }


    /**
     * 查询单条数据
     * @param id
     * @param model
     * @return
     */
    @RequestMapping("/findById/{id}")
    public String findById(@PathVariable("id") String id , Model model){
        Goods byGoid = goodsService.findByGoid(id);
        model.addAttribute("goods" , byGoid);
       // 其他信息
        List<Category> category = categoryService.findCategory("2");
        List<Shop> shops = shopService.findAll();
        model.addAttribute("category", category);
        model.addAttribute("shops", shops);
        return "goods/goodsupdate";

    }

    @RequestMapping("/addGoods")
    @ResponseBody
    public void addGoods(Goods goods ,@RequestParam(required = false) MultipartFile file){
        if(file !=null){
            try {// 暂时存放在这
                file.transferTo(new File(FileUploadUtil.getAbsolutePath(), file.getOriginalFilename()));
            } catch (Exception e) {
                e.printStackTrace();
            }
            goods.setGoimage(FileUploadUtil.getPath()+file.getOriginalFilename());
        }
        goodsService.addGoods(goods);

    }

    /**
     * 修改商品信息
     * @param goods
     * @param file
     */
    @RequestMapping("/modifyGoods")
    @ResponseBody
    public void modifyGoods(Goods goods , @RequestParam(required = false) MultipartFile file){

        if(file !=null && !file.isEmpty()){
            try {// 暂时存放在这
                // 先删除文件
                File file1 = new File(FileUploadUtil.getAbsolutePath() + goods.getGoimage());
                if(file1.exists()){
                    file1.delete();
                }
                file.transferTo(new File(FileUploadUtil.getAbsolutePath(), file.getOriginalFilename()));
            } catch (Exception e) {
                e.printStackTrace();
            }
            goods.setGoimage(FileUploadUtil.getPath()+file.getOriginalFilename());
        }
        goodsService.modifyGoods(goods);
    }


    /**
     * 删除一条数据记录
     * @param goid
     */
    @GetMapping("/removeGoods/{id}")
    @ResponseBody
    public void removeGoods(@PathVariable("id") String goid){
        // 业务层删除原图片信息
        goodsService.removeGoods(goid);
    }


    /**
     * 查询所有的评论信息
     * @param id
     * @param model
     * @return
     */
    @RequestMapping("/findAllComment/{id}")
    public String findAllComment(@PathVariable("id") String id, Model model){
        List<GoodsComment> allComment = goodsCommentService.findGoodsComment(id);
        System.out.println(allComment.toString());
        model.addAttribute("comments" , allComment);
        return "goods/goodscomment";

    }










    /**
     * 跳转到主界面
     *
     * @return
     */

    @RequestMapping({"/goods.htm", "/goods"})
    public String toGoods() {
        return "goods/goodslist";
    }


    /**
     * 跳转到添加界面
     * @param model
     * @return
     */
    @RequestMapping("/toGoodsAdd")
    public String toAddGoods(Model model ){
        List<Category> category = categoryService.findCategory("2");
        List<Shop> shops = shopService.findAll();
        model.addAttribute("category", category);
        model.addAttribute("shops", shops);
        return "goods/goodsadd";
    }


}
