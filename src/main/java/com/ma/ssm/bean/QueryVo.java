package com.ma.ssm.bean;

/**
 * @ProjectName: ssm
 * @Package: com.ma.ssm.bean
 * @Description: java类作用描述
 * @Author: 马贺辉
 * @CreateDate: 2020/11/11 9:34
 * @Version: 1.0
 * <p>
 * Copyright: Copyright (c) 2020
 */

public class QueryVo {
    private String cid;
    private String fname;
    private String low;
    private String high;

    @Override
    public String toString() {
        return "QueryVo{" +
                "cid='" + cid + '\'' +
                ", fname='" + fname + '\'' +
                ", low='" + low + '\'' +
                ", high='" + high + '\'' +
                '}';
    }

    public String getCid() {
        return cid;
    }

    public void setCid(String cid) {
        this.cid = cid;
    }

    public String getFname() {
        return fname;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }

    public String getLow() {
        return low;
    }

    public void setLow(String low) {
        this.low = low;
    }

    public String getHigh() {
        return high;
    }

    public void setHigh(String high) {
        this.high = high;
    }
}
