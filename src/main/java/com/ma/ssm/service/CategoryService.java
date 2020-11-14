package com.ma.ssm.service;

import com.ma.ssm.bean.Category;

import java.util.List;

/**
 * @ProjectName: ssm
 * @Package: com.ma.ssm.service
 * @Description: java类作用描述
 * @Author: 马贺辉
 * @CreateDate: 2020/11/10 21:40
 * @Version: 1.0
 * <p>
 * Copyright: Copyright (c) 2020
 */

public interface CategoryService {
    List<Category> queryCategories();
}
