package com.ma.ssm.mapper;

import com.ma.ssm.bean.Flower;
import com.ma.ssm.bean.QueryVo;
import org.apache.ibatis.annotations.Param;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;
import java.util.Map;

/**
 * @ProjectName: ssm
 * @Package: com.ma.ssm.mappers
 * @Description: java类作用描述
 * @Author: 马贺辉
 * @CreateDate: 2020/11/10 19:40
 * @Version: 1.0
 * <p>
 * Copyright: Copyright (c) 2020
 */

public interface FlowerMapper extends Mapper<Flower> {
    List<Map<String, String>> queryFlower(QueryVo queryVo);
}
