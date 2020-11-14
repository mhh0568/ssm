package com.ma.ssm.bean;

import tk.mybatis.mapper.annotation.KeySql;

import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @ProjectName: ssm
 * @Package: com.ma.ssm.bean
 * @Description: java类作用描述
 * @Author: 马贺辉
 * @CreateDate: 2020/11/10 19:36
 * @Version: 1.0
 * <p>
 * Copyright: Copyright (c) 2020
 */
@Table(name = "t_flower")
public class Flower {
    @Id
    @KeySql(useGeneratedKeys = true)
    private String fid;
    private String fname;
    private String price;
    private String cid;

    @Override
    public String toString() {
        return "Flower{" +
                "fid='" + fid + '\'' +
                ", fname='" + fname + '\'' +
                ", price='" + price + '\'' +
                ", cid='" + cid + '\'' +
                '}';
    }

    public String getFid() {
        return fid;
    }

    public void setFid(String fid) {
        this.fid = fid;
    }

    public String getFname() {
        return fname;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getCid() {
        return cid;
    }

    public void setCid(String cid) {
        this.cid = cid;
    }
}
