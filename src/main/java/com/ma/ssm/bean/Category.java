package com.ma.ssm.bean;

import tk.mybatis.mapper.annotation.KeySql;

import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @ProjectName: ssm
 * @Package: com.ma.ssm.bean
 * @Description: java类作用描述
 * @Author: 马贺辉
 * @CreateDate: 2020/11/10 19:41
 * @Version: 1.0
 * <p>
 * Copyright: Copyright (c) 2020
 */
@Table(name="t_category")
public class Category {
    @Id
    @KeySql(useGeneratedKeys = true)
    private String cid;
    private String cname;

    @Override
    public String toString() {
        return "Category{" +
                "cid='" + cid + '\'' +
                ", cname='" + cname + '\'' +
                '}';
    }

    public String getCid() {
        return cid;
    }

    public void setCid(String cid) {
        this.cid = cid;
    }

    public String getCname() {
        return cname;
    }

    public void setCname(String cname) {
        this.cname = cname;
    }
}
