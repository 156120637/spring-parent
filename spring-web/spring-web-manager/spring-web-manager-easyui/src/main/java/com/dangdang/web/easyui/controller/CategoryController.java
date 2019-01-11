package com.dangdang.web.easyui.controller;


import com.alibaba.fastjson.JSONObject;
import com.dangdang.repository.mysql.mapper.easyui.entity.Category;
import com.dangdang.service.biz.service.CategoryService;
import com.github.pagehelper.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/category")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    @RequestMapping("/findAll")
    @ResponseBody
    public String findAll(@RequestParam(required = false, defaultValue = "1") Integer page ,
                          @RequestParam(required = false, defaultValue = "10") Integer rows){
        /*分页信息*/
        Page<Category> byPage = categoryService.findByPage(page, rows);
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("rows", byPage);
        jsonObject.put("total", categoryService.countCategory());/*放入每页的数据和数据条数*/
        String s = JSONObject.toJSONStringWithDateFormat(jsonObject, "yyyy-MM-dd");
        return s;
    }

    /**
     * 添加新的分类
     * @param category
     */
    @ResponseBody
    @RequestMapping("/addCategory")
    public void addCategory(Category category){
        categoryService.addCategory(category);
    }

    /**
     * 查询一条数据
     * @param id
     * @param model
     * @return
     */
    @GetMapping("/findById/{id}")
    public String findById(@PathVariable("id") String id , Model model){
        Category byId = categoryService.findById(id);
        model.addAttribute("category", byId);
        return "category/categoryupdate";

    }

    /**
     * 修改category
     * @param category
     */
    @RequestMapping("/modifyCategory")
    @ResponseBody
    public void modifyCategory(Category category){
        categoryService.modifyCategory(category);
    }








    /**
     * 跳转到主界面
     * @return
     */
    @RequestMapping("/category.htm")
    public String toCategory(){
        return "category/categorylist";
    }

    /**
     * 跳转到添加界面
     * @return
     */
    @RequestMapping("/toAddCategory")
    public String toAddCategory(){
        return "category/categoryadd";
    }

}
