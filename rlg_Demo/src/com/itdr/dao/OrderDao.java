package com.itdr.dao;

import com.itdr.pojo.Order;
import com.itdr.utils.PoolUtil;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import java.sql.SQLException;
import java.util.List;

public class OrderDao {

    public List<Order> selectAll(Integer s, Integer n) {
        QueryRunner qr = new QueryRunner(PoolUtil.getCom());
        String sql = "select * from orders limit ?,?";
        List<Order> li = null;
        try {
            li = qr.query(sql, new BeanListHandler<Order>(Order.class),n,s);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return li;
    }

    public Order selectOne(Long orderid) {
        QueryRunner qr = new QueryRunner(PoolUtil.getCom());
        String sql = "select * from orders where o_orderNo = ?";
        Order od = null;
        try {
            od = qr.query(sql,new BeanHandler<Order>(Order.class),orderid);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return od;
    }

    public int updateNo(Long orderid) {
        QueryRunner qr =new QueryRunner(PoolUtil.getCom());
        String sql = "update orders set o_sendTime = now() where o_orderNo = ?";
        int i = 0;
        try {
            i = qr.update(sql,orderid);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return i;
    }
}
