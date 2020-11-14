package com.ma.ssm.service.impl;

import com.ma.ssm.bean.Category;
import com.ma.ssm.mapper.CategoryMapper;
import com.ma.ssm.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @ProjectName: ssm
 * @Package: com.ma.ssm.service.impl
 * @Description: java类作用描述
 * @Author: 马贺辉
 * @CreateDate: 2020/11/10 21:41
 * @Version: 1.0
 * <p>
 * Copyright: Copyright (c) 2020
 */
@Service
public class CategoryServiceImpl implements CategoryService {
    @Autowired
    CategoryMapper categoryMapper;
    @Override
    public List<Category> queryCategories() {
        return categoryMapper.selectAll();
    }
}
