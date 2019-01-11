package com.dangdang.web.easyui.controller;

import com.alibaba.fastjson.JSONObject;
import com.dangdang.repository.mysql.mapper.easyui.entity.Goods;
import com.dangdang.repository.mysql.mapper.easyui.entity.Shop;
import com.dangdang.service.biz.service.GoodsService;
import com.dangdang.service.biz.service.ShopService;
import com.github.pagehelper.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("/shop")
public class ShopController {

    @Autowired
    private ShopService shopService;

    @Autowired
    private GoodsService goodsService;


    /**
     * 查询所有的数据
     * @param page
     * @param rows
     * @return
     */
    @GetMapping("/findAll")
    @ResponseBody
    public String findAll(@RequestParam(required = false,defaultValue = "1") Integer page ,
                          @RequestParam(required = false,defaultValue = "10") Integer rows){
        Page<Shop> shops = shopService.findByPage(page , rows);
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("rows", shops);
        jsonObject.put("total", shopService.countShop());
        String s = JSONObject.toJSONStringWithDateFormat(jsonObject, "yyyy-MM-dd");// 转化日期
        return s;
    }


    /**
     * 删除商铺信息  -- 需要注意的是级联删除  设置在数据句中 吧
     * @param id
     */
    @ResponseBody
    @RequestMapping("/removeShop/{id}")
    public void removeShop(@PathVariable("id") String id){
        shopService.removeShop(id);
    }


    @RequestMapping("/addShop")
    @ResponseBody
    public void addShop(Shop shop , MultipartFile file){
        // 这里少了一个字段   是哪个用户添加的
        if(file !=null){
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
            String format = simpleDateFormat.format(new Date());
            try {// 暂时存放在这
                File f = new File("E:\\img\\" + format+"\\");
                if(!f.exists()){
                    f.mkdirs();
                }
                // 保存文件
                file.transferTo(new File(f, file.getOriginalFilename()));
                shop.setShimage("E:\\img\\"+format+"\\"+file.getOriginalFilename());
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        shopService.addShop(shop);
    }

    /**
     * 修改商铺信息
     * @param shop
     * @param file
     */
    @RequestMapping("/modifyShop")
    @ResponseBody
    public void modifyShop(Shop shop,@RequestParam(required = false) MultipartFile file, HttpServletRequest request){

        /**
         * 需要做的是  将如果原来有文件信息 需要将文件信息删除
         */
        Shop byShid = shopService.findByShid(shop.getShid());
        if(byShid.getShimage()!=null){

            String realPath = request.getSession().getServletContext().getRealPath("E:\\img\\" + byShid.getShimage());
            File file1 = new File(realPath);
            if(file1.isFile()){
                file1.deleteOnExit();// 文件删除
            }
        }

        if(file !=null) {
            try {// 暂时存放在这
                SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
                String format = simpleDateFormat.format(new Date());
                File f = new File("E:\\img\\" + format+"\\");
                if(!f.exists()){
                    f.mkdirs();
                }
                file.transferTo(new File(f, file.getOriginalFilename()));
                shop.setShimage("E:\\img\\" + format+"\\"+file.getOriginalFilename());
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        shopService.modifyShop(shop);// 执行修改

    }




    /**
     * 查询该商铺下的所有商品
     * @param shid
     * @return
     */
    @RequestMapping("/findAllGoods")
    @ResponseBody
    public String findAllGoods(@PathVariable("id") String shid){
        List<Goods> shopId = goodsService.findByShopId(shid);
        String s = JSONObject.toJSONStringWithDateFormat(shopId, "yyyy-MM-dd");
        return s;
    }




    /**
     * 跳转到商铺界面
     * @return
     */
    @RequestMapping({"/shop.htm","/shop"})
    public String toShop(){
        return "shop/shoplist";
    }

    /**
     * 跳转到添加商铺界面
     * @return
     */
    @RequestMapping("/toAddShop")
    public String toAddShop(){
        return "shop/shopadd";

    }

    /**
     * 添加商铺界面
     * @return
     */
    @RequestMapping("/toUpdateShop/{id}")
    public String toUpdateShop(@PathVariable("id") String shid , Model model){

        Shop byShid = shopService.findByShid(shid);
        model.addAttribute("shop" , byShid);
        return "shop/shopupdate";
    }


}
