package com.itdr.service;

import com.itdr.common.ResponseCode;
import com.itdr.dao.OrderDao;
import com.itdr.pojo.Order;
import com.itdr.pojo.Users;
import com.itdr.utils.PropertiesGetUtil;
import com.sun.org.apache.xpath.internal.operations.Or;

import java.util.List;

public class OrderService {
    OrderDao od = new OrderDao();
    public ResponseCode selectAll(String pageSize, String pageNum) {
        Integer s = null;
        Integer n = null;
        if(pageSize == null || pageSize.equals("")){
            pageSize = "10";
            s = Integer.parseInt(pageSize);
        }
        if(pageNum == null || pageNum.equals("")){
            pageNum = "1";
            n = Integer.parseInt(pageNum);
        }

        List<Order> li = od.selectAll(s,n);
        //如果集元素是空呢？

        ResponseCode rs = new ResponseCode();
        rs = ResponseCode.success(li);
        return rs;
    }

    //查找订单
    public ResponseCode selectOne(String orderId) {
        Long orderid = Long.parseLong(orderId);
        ResponseCode rs = new ResponseCode();
        Order or = od.selectOne(orderid);
        if(or!= null){
            rs  = ResponseCode.success(or);
            return rs;
        }
        rs  = ResponseCode.success(Integer.parseInt(PropertiesGetUtil.getValue("ORDER_SELECT_FAIL")),
                PropertiesGetUtil.getValue("ORDER_SELECT_FAIL_MSG"));
        return rs;
    }

    //订单发货
    public ResponseCode updateNo(String orderId) {
        ResponseCode rs = new ResponseCode();
        Long orderid = Long.parseLong(orderId);
        int i  = od.updateNo(orderid);
        if(i != 0){
             rs = ResponseCode.success(Integer.parseInt(PropertiesGetUtil.getValue("ORDER_UPDATE_SUCCESS")),
                     PropertiesGetUtil.getValue("ORDER_UPDATE_SUCCESS_MSG"));
             return rs;
        }
        rs = ResponseCode.success(Integer.parseInt(PropertiesGetUtil.getValue("ORDER_UPDATE_FAIL")),
                PropertiesGetUtil.getValue("ORDER_UPDATE_FAIL_MSG"));
        return rs;
    }
}
