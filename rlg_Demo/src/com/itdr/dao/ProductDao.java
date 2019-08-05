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
    //获取连接
    QueryRunner qr = new QueryRunner(PoolUtil.getCom());
    //查找所有产品列表
    public List<Product> selectAll(Integer pageSize, Integer pageNum) {
        String sql = "select * from product limit ?,?";
        List<Product> li = null;
        try {
            li = qr.query(sql, new BeanListHandler<Product>(Product.class),pageNum-1,pageSize);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return li;
    }

    //搜索产品按产品ID
    public Product selectOne(Integer productId) {
        String sql = "select * from product where p_id = ?";
        Product li = null;
        try {
            li = qr.query(sql,new BeanHandler<Product>(Product.class),productId);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return li;
    }

    //搜索产品按产品名称
    public List<Product> selectOne(String productName) {
        String sql = "select * from product where p_name like ?";
        String productName1 = "%"+productName+"%";
        List<Product> li = null;
        try {
            li = qr.query(sql,new BeanListHandler<Product>(Product.class),productName1);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return li;

    }

    //按ID查找产品   查看产品的详情
    public Product selectOneAll(Integer productId) {
        String sql = "select * from product where p_id = ?";
        Product li = null;
        try {
            li = qr.query(sql,new BeanHandler<Product>(Product.class),productId);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return li;
    }

    //按ID查找产品   改为上架或下架
    public int updateOne(Integer productId, Integer status) {
        String sql = "update product set p_status = ? where p_id = ?";
        int a = 0;
        try {
            a = qr.update(sql,status,productId);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return a;
    }

    //更新产品
    public int updateAddOne(Integer id, Integer categoryId, String name,
                            String subtitle, String mainImage, Integer status, double price) {
        String sql = "update product set p_categrouyId = ? ,p_name = ?,p_subtitle = ?,p_mainImage = ?,p_status = ?,p_price = ? where p_id = ?";
        int a = 0;
        try {
            a = qr.update(sql,categoryId,name,subtitle,mainImage,status,price,id);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return a;
    }

    //新增产品
    public int updateAddOne(Integer categoryId, String name, String subtitle,
                            String mainImage, Integer status, double price) {
        String sql = "insert into product values(null,?,?,?,?,?,?)";
        int a = 0;
        try {
            a = qr.update(sql,categoryId,name,subtitle,mainImage,status,price);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return a;
    }
}
