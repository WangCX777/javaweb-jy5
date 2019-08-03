package com.itdr.service;

import com.itdr.common.ResponseCode;
import com.itdr.dao.ProductDao;
import com.itdr.pojo.Product;
import com.itdr.pojo.Users;

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
//        if(pageSize == null || pageSize.equals("")){
//            pageSize = "10";
//        }
//        if(pageNum == null || pageNum.equals("")){
//            pageNum = "1";
//        }
        Product li = pd.selectOne(productName,productId);
        ResponseCode rs = new ResponseCode();
        rs.setStatus(0);
        rs.setData(li);
        return  rs;
    }
}
