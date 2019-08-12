package com.itdr.dao;

import com.itdr.pojo.Category;
import com.itdr.utils.PoolUtil;
import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.sql.SQLException;
import java.util.List;

public class CategoryDao {
    QueryRunner qr = new QueryRunner(PoolUtil.getCom());
    //按catepory查询
    public List<Category> selectCategory(Integer c_category) {
        String sql = "select* from category where c_parentId = ?" ;
        List<Category> li  = null;
        try {
            li = qr.query(sql,new BeanListHandler<Category>(Category.class),c_category);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return li;
    }

    //增加节点
    public int addCategory(Integer id, String categoryName) {
        String sql = "insert into category values(null,?,?,null,null,now(),now())";
        int a = 0;
        try {
            a = qr.update(sql,id,categoryName);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return a;
    }

    //修改
    public int setCategoryName(Integer id, String categoryName) {
        String sql = "update category set c_name＝? where c_id=?";
        int a = 0;
        try {
            a = qr.update(sql,categoryName,id);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return a;
    }

    public List<Category> get_deep_category(Integer id) {
        String sql = "select * from category where c_parentId = ?";
        List<Category> li = null;
        try {
            li = qr.query(sql ,new BeanListHandler<Category>(Category.class),id);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return li;
    }
}
