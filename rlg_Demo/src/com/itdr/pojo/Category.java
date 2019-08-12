package com.itdr.pojo;


import java.util.Date;

public class Category {
    private Integer c_id;
    private Integer c_parentId;
    private String c_name;
    private String c_status;
    private Integer c_sortOrder;
    private Date c_createTime;
    private Date c_updateTime;

    public Integer getC_id() {
        return c_id;
    }

    public void setC_id(Integer c_id) {
        this.c_id = c_id;
    }

    public Integer getC_parentId() {
        return c_parentId;
    }

    public void setC_parentId(Integer c_parentId) {
        this.c_parentId = c_parentId;
    }

    public String getC_name() {
        return c_name;
    }

    public void setC_name(String c_name) {
        this.c_name = c_name;
    }

    public String getC_status() {
        return c_status;
    }

    public void setC_status(String c_status) {
        this.c_status = c_status;
    }

    public Integer getC_sortOrder() {
        return c_sortOrder;
    }

    public void setC_sortOrder(Integer c_sortOrder) {
        this.c_sortOrder = c_sortOrder;
    }

    public Date getC_createTime() {
        return c_createTime;
    }

    public void setC_createTime(Date c_createTime) {
        this.c_createTime = c_createTime;
    }

    public Date getC_updateTime() {
        return c_updateTime;
    }

    public void setC_updateTime(Date c_updateTime) {
        this.c_updateTime = c_updateTime;
    }

    //重写toString

}