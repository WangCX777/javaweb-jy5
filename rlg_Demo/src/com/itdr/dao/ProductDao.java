package com.itdr.dao;

import com.itdr.pojo.Product;
import com.itdr.pojo.Users;
import com.itdr.utils.PoolUtil;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.sql.SQLException;
import java.util.List;

/**
 * @author WangCX
 * @date 2019/8/3 9:30
 */
public class ProductDao {

    //查找所有产品列表
    public List<Product> selectAll(String pageSize, String pageNum) {
        QueryRunner qr = new QueryRunner(PoolUtil.getCom());
        String sql = "select * from product limit ?,?";
        List<Product> li = null;
        try {
            li = qr.query(sql, new BeanListHandler<Product>(Product.class),Integer.parseInt(pageNum)-1,Integer.parseInt(pageSize));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return li;
    }

    //搜索产品
    public Product selectOne(String productName,String productId) {
        QueryRunner qr = new QueryRunner(PoolUtil.getCom());
        String sql = "select * from product where p_name = ? and p_id = ?";
        Product li = null;
        try {
            li = qr.query(sql,new BeanHandler<Product>(Product.class),productName,Integer.parseInt(productId));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return li;
    }
}
