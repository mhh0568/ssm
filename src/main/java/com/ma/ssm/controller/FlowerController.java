package com.ma.ssm.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.ma.ssm.bean.Flower;
import com.ma.ssm.bean.QueryVo;
import com.ma.ssm.service.FlowerService;
import com.ma.ssm.util.PageHelpUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @ProjectName: ssm
 * @Package: com.ma.ssm.controller
 * @Description: java类作用描述
 * @Author: 马贺辉
 * @CreateDate: 2020/11/10 20:05
 * @Version: 1.0
 * <p>
 * Copyright: Copyright (c) 2020
 */
@Controller
public class FlowerController {
    @Autowired
    FlowerService flowerService;
    private int pageSize=3;
    @RequestMapping({"/index","/"})
    public String index(Model model, @RequestParam(defaultValue = "1") int page, QueryVo queryVo){
        PageHelper.startPage(page,pageSize);
        List<Map<String, String>> flowers = flowerService.queryFlower(queryVo);
        PageInfo<Map<String, String>> pageInfo=new PageInfo<>(flowers);
        Map<String,Object> map=new HashMap<>();
        /*
        * 注意必须将queryVo中的属性一个个的添加到map集合中，
        * 如果直接将queryVo对象添加到map集合中，点击页码无法将条件拼出，
        * 会造成条件丢失
        *
        * */
        map.put("cid",queryVo.getCid());
        map.put("fname",queryVo.getFname());
        map.put("low",queryVo.getLow());
        map.put("high",queryVo.getHigh());
        String pages = PageHelpUtil.bootStrapPage("/ssm/index", pageInfo,map );
        //System.out.println(cid);
        model.addAttribute("queryVo",queryVo);
        model.addAttribute("pages",pages);
        model.addAttribute("flowers",flowers);
        return "index";
    }
    //修改和添加操作
    @RequestMapping("/addOrUpdateFlower")
    public String addOrUpdateFlower(Flower flower){
        flowerService.addOrUpdateFlower(flower);
        return "forward:/index";
    }
    //根据鲜花主键查询鲜花信息
    @RequestMapping("/queryByFid")
    public @ResponseBody Flower queryByFid(Flower flower){
        return flower = flowerService.queryByFid(flower);
        //model.addAttribute("flower",flower);
    }

    @RequestMapping("/delFlower")
    public String delFlower(String fid){
        flowerService.deleteFlower(fid);
        return "forward:/index";
    }
}
