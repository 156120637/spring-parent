package com.dangdang.web.easyui.controller;

import com.alibaba.fastjson.JSONObject;
import com.dangdang.repository.mysql.mapper.easyui.entity.Category;
import com.dangdang.repository.mysql.mapper.easyui.entity.News;
import com.dangdang.repository.mysql.mapper.easyui.entity.NewsComment;
import com.dangdang.service.biz.service.CategoryService;
import com.dangdang.service.biz.service.NewsService;
import com.dangdang.common.utils.easyui.util.FileUploadUtil;
import com.github.pagehelper.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.List;

@Controller
@RequestMapping("/news")
public class NewsController {


    @Autowired
    private NewsService newsService;
    @Autowired
    private CategoryService categoryService;

    /**
     * 查询所有的资讯信息
     * @return
     */
    @RequestMapping("/findAll")
    @ResponseBody
    public String findAll(@RequestParam(required = false , defaultValue = "1")Integer page ,
                          @RequestParam(required = false, defaultValue = "10") Integer rows){

        Page<News> byPage = newsService.findByPage(page, rows);
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("rows", byPage);
        jsonObject.put("total", newsService.countNews());
        String s = JSONObject.toJSONStringWithDateFormat(jsonObject, "yyyy-MM-dd");
        return s;
    }

    /**
     * 查询一个数据
     * @param id
     * @param model
     * @return
     */
    @GetMapping("/findById/{id}")
    public String findById(@PathVariable("id") String id, Model model){
        News byId = newsService.findById(id);
        List<Category> categorys = categoryService.findCategory("1");
        model.addAttribute("news", byId);
        model.addAttribute("categorys", categorys);
        return "news/newsupdate";
    }

    /**
     * 修改资讯信息
     * @param news
     * @param file
     */
    @RequestMapping("/modifyNews")
    @ResponseBody
    public void modifyNews(News news ,@RequestParam(required = false) MultipartFile file){
        System.out.println("---------add0-----------"+file);
        if(null!=news.getNeimage()){

            try {
                File file1 = new File(FileUploadUtil.getAbsolutePath()+news.getNeimage());
                if(file1.isFile()){
                    file1.delete();
                }

                file.transferTo(new File(FileUploadUtil.getAbsolutePath(), file.getOriginalFilename()));
            } catch (IOException e) {
                e.printStackTrace();
            }
            news.setNeimage(FileUploadUtil.getPath()+file.getOriginalFilename());
        }
        newsService.modifyNews(news);
    }


    /**
     * 添加资讯信息
     * @param news
     * @param file
     */
    @RequestMapping("/addNews")
    @ResponseBody
    public void addNews(News news ,@RequestParam(required = false) MultipartFile file){
        System.out.println("---------add0-----------"+file);
        if(!file.isEmpty()){
            try {
                file.transferTo(new File(FileUploadUtil.getAbsolutePath(), file.getOriginalFilename()));
            } catch (IOException e) {
                e.printStackTrace();
            }
            news.setNeimage(FileUploadUtil.getPath()+file.getOriginalFilename());
        }
        newsService.addNews(news);

    }

    /**
     * 删除一条资讯
     * @param id
     */
    @ResponseBody
    @GetMapping("/removeNews/{id}")
    public void removeNews(@PathVariable("id") String id){
        // 删除所有信息
        News byId = newsService.findById(id);
        if(null!=byId.getNeimage()){
            File file = new File(FileUploadUtil.getAbsolutePath()+byId.getNeimage());
            if (file.exists()) {
                file.delete();
            }
        }
        newsService.removeNews(id);
    }


    /**
     * 查询所有的评论信息
     * @param neid
     * @return
     */
    @GetMapping("/findAllComment/{id}")
    public String findAllComment(@PathVariable("id") String neid, Model model){
        List<NewsComment> allComment = newsService.findAllComment(neid);
        model.addAttribute("comments", allComment);
        return "news/newscomment";
    }







    /**
     * 跳转到主界面
     * @return
     */
    @RequestMapping({"/news.htm", "/news"})
    public String toNews(){
        return "news/newslist";
    }


    /**
     * 添加咨询信息
     * @return
     */
    @RequestMapping("/toAddNews")
    public String toAddNews(Model model){
        List<Category> category = categoryService.findCategory("1");
        model.addAttribute("category", category);
        return "news/newsadd";
    }


}
