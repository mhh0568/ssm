package com.ma.ssm.service;

import com.ma.ssm.bean.Flower;
import com.ma.ssm.bean.QueryVo;

import java.util.List;
import java.util.Map;

/**
 * @ProjectName: ssm
 * @Package: com.ma.ssm.service
 * @Description: java接口作用描述
 * @Author: 马贺辉
 * @CreateDate: 2020/11/10 19:39
 * @Version: 1.0
 * <p>
 * Copyright: Copyright (c) 2020
 */
public interface FlowerService {
    List<Map<String,String>> queryFlower(QueryVo queryVo);

    void addOrUpdateFlower(Flower flower);

    Flower queryByFid(Flower flower);

    void deleteFlower(String fid);
}
