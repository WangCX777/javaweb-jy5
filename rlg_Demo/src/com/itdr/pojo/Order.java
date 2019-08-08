package com.itdr.pojo;

import java.util.Date;

public class Order {
    private long o_orderNo;
    private double o_payment;
    private Integer o_paymentType;
    private String o_paymentTypeDesc;
    private String o_postage;
    private String o_status;
    private String o_statusDesc;
    private Date o_paymentTime;
    private Date o_sendTime;
    private Date o_endTime;
    private Date o_closeTime;
    private Date o_createTime;

    public long getO_orderNo() {
        return o_orderNo;
    }

    public void setO_orderNo(long o_orderNo) {
        this.o_orderNo = o_orderNo;
    }

    public double getO_payment() {
        return o_payment;
    }

    public void setO_payment(double o_payment) {
        this.o_payment = o_payment;
    }

    public Integer getO_paymentType() {
        return o_paymentType;
    }

    public void setO_paymentType(Integer o_paymentType) {
        this.o_paymentType = o_paymentType;
    }

    public String getO_paymentTypeDesc() {
        return o_paymentTypeDesc;
    }

    public void setO_paymentTypeDesc(String o_paymentTypeDesc) {
        this.o_paymentTypeDesc = o_paymentTypeDesc;
    }

    public String getO_postage() {
        return o_postage;
    }

    public void setO_postage(String o_postage) {
        this.o_postage = o_postage;
    }

    public String getO_status() {
        return o_status;
    }

    public void setO_status(String o_status) {
        this.o_status = o_status;
    }

    public String getO_statusDesc() {
        return o_statusDesc;
    }

    public void setO_statusDesc(String o_statusDesc) {
        this.o_statusDesc = o_statusDesc;
    }

    public Date getO_paymentTime() {
        return o_paymentTime;
    }

    public void setO_paymentTime(Date o_paymentTime) {
        this.o_paymentTime = o_paymentTime;
    }

    public Date getO_sendTime() {
        return o_sendTime;
    }

    public void setO_sendTime(Date o_sendTime) {
        this.o_sendTime = o_sendTime;
    }

    public Date getO_endTime() {
        return o_endTime;
    }

    public void setO_endTime(Date o_endTime) {
        this.o_endTime = o_endTime;
    }

    public Date getO_closeTime() {
        return o_closeTime;
    }

    public void setO_closeTime(Date o_closeTime) {
        this.o_closeTime = o_closeTime;
    }

    public Date getO_createTime() {
        return o_createTime;
    }

    public void setO_createTime(Date o_createTime) {
        this.o_createTime = o_createTime;
    }


    //重写tostring

    @Override
    public String toString() {
        return "Order{" +
                "o_orderNo=" + o_orderNo +
                ", o_payment=" + o_payment +
                ", o_paymentType=" + o_paymentType +
                ", o_paymentTypeDesc='" + o_paymentTypeDesc + '\'' +
                ", o_postage='" + o_postage + '\'' +
                ", o_status='" + o_status + '\'' +
                ", o_statusDesc='" + o_statusDesc + '\'' +
                ", o_paymentTime=" + o_paymentTime +
                ", o_sendTime=" + o_sendTime +
                ", o_endTime=" + o_endTime +
                ", o_closeTime=" + o_closeTime +
                ", o_createTime=" + o_createTime +
                '}';
    }
}
