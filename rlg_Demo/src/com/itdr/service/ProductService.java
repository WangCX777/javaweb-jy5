package com.itdr.service;

import com.itdr.common.ResponseCode;
import com.itdr.dao.ProductDao;
import com.itdr.pojo.Product;
import com.itdr.pojo.Users;
import com.itdr.utils.PropertiesGetUtil;
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
        Integer s = Integer.parseInt(pageSize);
        Integer n = Integer.parseInt(pageNum);

        List<Product> li = pd.selectAll(s,n);
        //如果集元素是空呢？

        ResponseCode rs = null;
        rs = ResponseCode.success(li);
        return rs;
    }

    //产品搜索
    public ResponseCode selectOne(String productName, String productId) {

        ResponseCode rs = new ResponseCode();

        if(productName==null || productName.equals("")){
            Integer i = Integer.parseInt(productId);
            Product li = pd.selectOne(i);
            rs = ResponseCode.success(li);
        }
        if(productId==null || productId.equals("")){
            List<Product> li = pd.selectOne(productName);
            rs = ResponseCode.success(li);
        }
        return  rs;
    }

    //产品详情
    public ResponseCode selectOneAll(String productId) {
        Integer i = Integer.parseInt(productId);
        Product li  = pd.selectOneAll(i);
        ResponseCode rs = new ResponseCode();
        rs = ResponseCode.success(li);
        return rs;
    }

    //产品上下架
    public ResponseCode updateOne(String productId, String status) {
        Integer i = Integer.parseInt(productId);
        Integer s = Integer.parseInt(status);
        int li  = pd.updateOne(i,s);
        ResponseCode rs = new ResponseCode();
        if(li != 0){
            rs = ResponseCode.success(Integer.parseInt(PropertiesGetUtil.getValue("PRODUCT_SUCCESS"))
                    ,PropertiesGetUtil.getValue("PRODUCT_MODIFY_SUCCESS_MSG"));
            return rs;
        }
        rs = ResponseCode.success(Integer.parseInt(PropertiesGetUtil.getValue("PRODUCT_FAIL"))
                ,PropertiesGetUtil.getValue("PRODUCT_MODIFY_FAIL_MSG"));
        return rs;

    }

    //新增或更新商品
    public ResponseCode updateAddOne(String id, String categoryId, String name,
                                     String subtitle, String mainImage, String status, String price) {

        Integer c = Integer.parseInt(categoryId);
        Integer s = Integer.parseInt(status);
        double p = Double.parseDouble(price);

        ResponseCode rs = new ResponseCode();
        if (id != null && !id.equals("")){
            Integer i = Integer.parseInt(id);
            int li  = pd.updateAddOne(i,c,name,subtitle,mainImage,s,p);
            if(li != 0){
                rs = ResponseCode.success(Integer.parseInt(PropertiesGetUtil.getValue("PRODUCT_SUCCESS"))
                        ,PropertiesGetUtil.getValue("PRODUCT_UPDATE_SUCCESS_MSG"));
                return rs;
            }
            rs = ResponseCode.success(Integer.parseInt(PropertiesGetUtil.getValue("PRODUCT_FAIL"))
                    ,PropertiesGetUtil.getValue("PRODUCT_UPDATE_FAIL_MSG"));
            return rs;
        }else{
            int li  = pd.updateAddOne(c,name,subtitle,mainImage,s,p);
            if(li != 0){
                rs = ResponseCode.success(Integer.parseInt(PropertiesGetUtil.getValue("PRODUCT_SUCCESS"))
                        ,PropertiesGetUtil.getValue("PRODUCT_ADD_SUCCESS_MSG"));
                return rs;
            }
            rs = ResponseCode.success(Integer.parseInt(PropertiesGetUtil.getValue("PRODUCT_FAIL"))
                    ,PropertiesGetUtil.getValue("PRODUCT_ADD_FAIL_MSG"));
            return rs;
        }

    }
}
