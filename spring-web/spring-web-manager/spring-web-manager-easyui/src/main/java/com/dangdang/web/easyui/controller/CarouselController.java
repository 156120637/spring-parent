package com.dangdang.web.easyui.controller;

import com.alibaba.fastjson.JSONObject;
import com.dangdang.repository.mysql.mapper.easyui.entity.Carousel;
import com.dangdang.service.biz.service.CarouselService;
import com.dangdang.common.utils.easyui.util.FileUploadUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.List;

@Controller
@RequestMapping("/carousel")
public class CarouselController {


    @Autowired
    private CarouselService carouselService;

    /**
     * 查询所有
     * @return
     */
    @RequestMapping("/findAll")
    @ResponseBody
    public String findAll(@RequestParam(required = false, defaultValue = "1")Integer page ,
                          @RequestParam(required = false , defaultValue = "10") Integer rows){
        List<Carousel> byPage = carouselService.findByPage(page, rows);
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("rows", byPage);
        jsonObject.put("total", carouselService.countCarousel());
        String s = JSONObject.toJSONStringWithDateFormat(jsonObject, "yyyy-MM-dd");
        return s;
    }


    /**
     * 删除一个轮播图
     * @param id
     */
    @GetMapping("/removeCarousel/{id}")
    @ResponseBody
    public void removeCarousel(@PathVariable("id") String id){
        // 在业务层删除原图片
        // 删除数据
        carouselService.removeCarousel(id);

    }


    /**
     * 添加carousel数据
     * @param carousel
     * @param file
     */
    @RequestMapping("/addCarousel")
    @ResponseBody
    public void addCarousel(Carousel carousel,@PathVariable(required = false) MultipartFile file){

        /*
        * FileUploadUtil 文件上传工具类
        * 将文件路径设置进去
        * */
        carousel.setCaimage(FileUploadUtil.getPath() +file.getOriginalFilename());
        try {
            file.transferTo(new File(FileUploadUtil.getAbsolutePath(),file.getOriginalFilename()));
        } catch (IOException e) {
            e.printStackTrace();
        }
        carouselService.addCarousel(carousel);
    }


    /**
     * 查询单个
     * @param id
     * @param model
     * @return
     */
    @RequestMapping("/findById/{id}")
    public String findById(@PathVariable("id") String id,  Model model){
        Carousel byId = carouselService.findById(id);
        model.addAttribute("carousel",byId);
        return "carousel/carouselupdate";
    }


    /**
     * 修改数据
     * @param carousel
     * @param file
     */
    @RequestMapping("/modifyCarousel")
    @ResponseBody
    public void modifyCarousel(Carousel carousel, MultipartFile file){

        if(null!=file){
            Carousel byId = carouselService.findById(carousel.getCaid());

            try {
                if(null != byId.getCaimage()){
                    File f = new File(FileUploadUtil.getResource()+byId.getCaimage());
                    if(f.exists()){
                        f.delete();
                    }
                }

                file.transferTo(new File(FileUploadUtil.getAbsolutePath(), file.getOriginalFilename()));
            } catch (IOException e) {
                e.printStackTrace();
            }
            carousel.setCaimage(FileUploadUtil.getPath()+file.getOriginalFilename());
        }
        carouselService.modifyCarousel(carousel);
    }


    /**
     * 返回轮播主界面
     * @return
     */
    @RequestMapping({"/carousel.htm" , "/carousel"})
    public String toCarousel(){

        return "carousel/carousellist";
    }

    /**
     * 跳转到添加界面
     * @return
     */
    @RequestMapping("/toAddCarousel")
    public String toAddCarousel(){
        return "carousel/carouseladd";
    }


}
