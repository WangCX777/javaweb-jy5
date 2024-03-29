package com.itdr.controller;

import com.itdr.common.ResponseCode;
import com.itdr.service.ProductService;
import com.itdr.utils.JsonUtils;
import com.itdr.utils.PathUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.IOException;
import java.util.UUID;

/**
 * @author WangCX
 * @date 2019/8/3 9:20
 */
@WebServlet(name = "ProductController",value = "/manage/product/*")
public class ProductController extends HttpServlet {
    ProductService ps = new ProductService();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //怎么获取请求路径信息
        String pathInfo = request.getPathInfo();
        String path = PathUtil.getPath(pathInfo);
        //创建统一返回对象
        ResponseCode rs= null;
        //判断一下是什么样的请求
        switch (path){
            case "list" :
                rs = listDo(request);
                break;
            case "search":
                rs = searchDo(request);
                break;
//            case "upload":
//                rs = uploadDo(request,response);
//                break;
            case "detail":
                rs = detailDo(request);
                break;
            case "set_sale_status":
                rs = set_sale_statusDo(request);
                break;
            case "save":
                rs = saveDo(request);
                break;
        }
        //返回响应数据
        response.setContentType("text/json;charset=utf-8");
        response.getWriter().write(JsonUtils.obj2String(rs));

    }


    //产品列表
    private ResponseCode listDo(HttpServletRequest request) {
        //获取参数
        String pageSize = request.getParameter("pageSize");
        String pageNum = request.getParameter("pageNum");
        ResponseCode rs = ps.selectAll(pageSize,pageNum);
        //调用业务层处理业务
        return rs;
    }

    //搜索产品
    private ResponseCode searchDo(HttpServletRequest request){
        String productName = request.getParameter("productName");
        String productId = request.getParameter("productId");
        ResponseCode rs =  ps.selectOne(productName,productId);
        return rs ;
    }

//    //产品图片上传
    private void uploadDo(HttpServletRequest request, HttpServletResponse response) {

        try {
            Part part = request.getPart("upimg");
            String name = part.getHeader("content-disposition");
            String root = "D:\\WorkSpace\\github\\javaweb-jy5\\rlg_Demo\\web\\img\\product";
            String str = name.substring(name.lastIndexOf("."),name.length()-1);
            String filename = root+"\\"+ UUID.randomUUID().toString()+str;
            response.getWriter().write("成功");
        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
            try {
                response.getWriter().write("失败");
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }

    }

    //产品详情
    private ResponseCode detailDo(HttpServletRequest request) {
        String productId = request.getParameter("productId");
        ResponseCode rs =  new ResponseCode();
        rs = ps.selectOneAll(productId);
        return rs ;
    }
//
    //产品上下架
    private ResponseCode set_sale_statusDo(HttpServletRequest request) {
        String productId = request.getParameter("productId");
        String status = request.getParameter("status");
        ResponseCode rs =  ps.updateOne(productId,status);
        return rs ;
    }

//    更新或添加产品
    private ResponseCode saveDo(HttpServletRequest request) {
        String id = request.getParameter("id");
        String categoryId = request.getParameter("categoryId");
        String name = request.getParameter("name");
        String subtitle = request.getParameter("subtitle");
        String mainImage = request.getParameter("mainImage");
        String status = request.getParameter("status");
        String price = request.getParameter("price");
        ResponseCode rs =  ps.updateAddOne(id,categoryId,name,subtitle,mainImage,
                status,price);
        return rs ;
    }


}
