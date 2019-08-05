package com.itdr.common;

import com.itdr.utils.PropertiesGetUtil;

/**
 * @author WangCX
 * @date 2019/8/1 13:20
 */
public class ResponseCode<T> {
    private Integer status;
    private T data;
    private String mag;

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public String getMag() {
        return mag;
    }

    public void setMag(String mag) {
        this.mag = mag;
    }
    //成功的时候只要返回状态码和成功获取的数据就可以了

    //失败的时候只要返回状态码和失败的信息就可以了


    @Override
    public String toString() {
        return "ResponseCode{" +
                "status=" + status +
                ", data=" + data +
                ", mag='" + mag + '\'' +
                '}';
    }

    public static <T>ResponseCode success(T data){
        ResponseCode rs = new ResponseCode();
        rs.setStatus(Integer.parseInt(PropertiesGetUtil.getValue("PRODUCT_LIST_SUCCESS")));
        rs.setData(data);
        return rs;
    }
    public static <T>ResponseCode success(Integer status,String msg){
        ResponseCode rs = new ResponseCode();
        rs.setStatus(status);
        rs.setMag(msg);
        return rs;
    }

    public static <T>ResponseCode success(Integer status,T data ,String msg){
        ResponseCode rs = new ResponseCode();
        rs.setStatus(status);
        rs.setData(data);
        rs.setMag(msg);
        return rs;
    }

}
