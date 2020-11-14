package com.ma.ssm.service.impl;

import com.ma.ssm.bean.Flower;
import com.ma.ssm.bean.QueryVo;
import com.ma.ssm.mapper.FlowerMapper;
import com.ma.ssm.service.FlowerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * @ProjectName: ssm
 * @Package: com.ma.ssm.service.impl
 * @Description: java类作用描述
 * @Author: 马贺辉
 * @CreateDate: 2020/11/10 19:39
 * @Version: 1.0
 * <p>
 * Copyright: Copyright (c) 2020
 */
@Service
public class FlowerServiceImpl implements FlowerService {
    @Autowired
    FlowerMapper flowerMapper;
    @Override
    public List<Map<String, String>> queryFlower(QueryVo queryVo) {
        return flowerMapper.queryFlower(queryVo);
    }

    @Override
    public void addOrUpdateFlower(Flower flower) {
        if(flower.getFid()==null){
            //插入
            flowerMapper.insertSelective(flower);
        }else{
            //修改
            flowerMapper.updateByPrimaryKeySelective(flower);
        }
    }

    @Override
    public Flower queryByFid(Flower flower) {
        return flowerMapper.selectByPrimaryKey(flower);
    }

    @Override
    public void deleteFlower(String fids) {
        String[] str = fids.split(",");
        for (String fid : str) {
            flowerMapper.deleteByPrimaryKey(fid);
        }
    }
}
