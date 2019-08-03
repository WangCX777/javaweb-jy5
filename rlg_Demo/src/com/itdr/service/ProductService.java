package com.itdr.service;

import com.itdr.common.ResponseCode;
import com.itdr.dao.ProductDao;
import com.itdr.pojo.Product;
import com.itdr.pojo.Users;
import org.apache.commons.dbutils.handlers.BeanHandler;

import javax.xml.ws.Response;
import java.util.List;

/**
 * @author WangCX
 * @date 2019/8/3 9:23
 */
public class ProductService {

    private ProductDao pd = new ProductDao();
    //产品列表
    public ResponseCode selectAll(String pageSize, String pageNum) {
        if(pageSize == null || pageSize.equals("")){
            pageSize = "10";
        }
        if(pageNum == null || pageNum.equals("")){
            pageNum = "1";
        }


        List<Product> li = pd.selectAll(pageSize,pageNum);
        //如果集元素是空呢？

        ResponseCode rs = new ResponseCode();
        rs.setStatus(0);
        rs.setData(li);
        return rs;
    }

    public ResponseCode selectOne(String productName, String productId) {

        ResponseCode rs = new ResponseCode();
        if(productName==null || productName.equals("")){
            Product li = pd.selectOne(Integer.parseInt(productId));
            rs.setStatus(0);
            rs.setData(li);
        }
        if(productId==null || productId.equals("")){
            List<Product> li = pd.selectOne(productName);
            rs.setStatus(0);
            rs.setData(li);
        }
        return  rs;
    }

    //产品详情
    public ResponseCode selectOneAll(String productId) {
        Product li  = pd.selectOneAll(productId);
        ResponseCode rs = new ResponseCode();
        rs.setStatus(0);
        rs.setData(li);
        return rs;
    }

    //产品上下架
    public ResponseCode updateOne(String productId, String status) {
        int li  = pd.updateOne(productId,status);
        ResponseCode rs = new ResponseCode();
        if(li != 0){
            rs.setStatus(0);
            rs.setMag("修改产品状态成功");
            return rs;
        }
        rs.setStatus(1);
        rs.setMag("修改产品状态失败");
        return rs;
    }
}
