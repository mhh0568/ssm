package com.ma.ssm.controller;

import com.ma.ssm.bean.Category;
import com.ma.ssm.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * @ProjectName: ssm
 * @Package: com.ma.ssm.controller
 * @Description: java类作用描述
 * @Author: 马贺辉
 * @CreateDate: 2020/11/10 21:43
 * @Version: 1.0
 * <p>
 * Copyright: Copyright (c) 2020
 */
@Controller
public class CategoryController {
    @Autowired
    CategoryService categoryService;

    @RequestMapping("/queryCategories")
    public @ResponseBody List<Category> queryCategories(){
        List<Category> categories = categoryService.queryCategories();
        //System.out.println(categories);
        return categories;
    }
}
