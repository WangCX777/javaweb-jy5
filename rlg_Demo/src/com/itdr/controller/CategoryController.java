package com.itdr.controller;

import com.itdr.common.ResponseCode;
import com.itdr.service.CategoryService;
import com.itdr.utils.PathUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "CategoryController",value = "/manage/category/*")
public class CategoryController extends HttpServlet {
    CategoryService cs = new CategoryService();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String pathInfo = request.getPathInfo();
        String path = PathUtil.getPath(pathInfo);
        //创建统一返回对象
        ResponseCode rs= null;
        //判断一下是什么样的请求
        switch (path){
            case "get_category" :
                rs = get_categoryDo(request);
                break;
            case "add_category":
                rs = add_categoryDo(request);
                break;
            case "set_category_name":
                rs = set_category_nameDo(request);
                break;
//            case "get_deep_category":
//                rs = set_sale_statusDo(request);
//                break;
        }
        //返回响应数据
        response.getWriter().write(rs.toString());

    }

    //修改品类名称
    private ResponseCode set_category_nameDo(HttpServletRequest request) {
        String categoryName = request.getParameter("categoryName");
        String categoryId = request.getParameter("categoryId");
        ResponseCode rs = cs.setcategoryName(categoryId,categoryName);
        return  rs;
    }

    //增加节点
    private ResponseCode add_categoryDo(HttpServletRequest request) {
        String categoryName = request.getParameter("categoryName");
        String parentId = request.getParameter("parentId");

        ResponseCode rs = cs.addCategory(parentId,categoryName);

        return rs;
    }

    //查找
    private ResponseCode get_categoryDo(HttpServletRequest request) {
        String categoryId = request.getParameter("categoryId");

        ResponseCode rs = cs.seleCategory(categoryId);

        return rs;
    }
}
