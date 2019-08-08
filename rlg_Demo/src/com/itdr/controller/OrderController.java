package com.itdr.controller;

import com.itdr.common.ResponseCode;
import com.itdr.service.OrderService;
import com.itdr.utils.PathUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "OrderController",value = "/manage/order/*")
public class OrderController extends HttpServlet {
    OrderService os = new OrderService();
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
            case "list" :
                rs = listDo(request);
                break;
            case "search":
                rs = searchDo(request);
                break;
            case "detail":
                rs = searchDo(request);
                break;
            case "send_goods":
                rs = send_goodsDo(request);
                break;
        }
        //返回响应数据
        response.getWriter().write(rs.toString());
    }

    //订单发货
    private ResponseCode send_goodsDo(HttpServletRequest request) {
        String orderId = request.getParameter("orderNo");
        ResponseCode rs = new ResponseCode();
        rs= os.updateNo(orderId);
        return  rs;
    }

    //查找订单
    private ResponseCode searchDo(HttpServletRequest request) {
        String orderId = request.getParameter("orderNo");
        ResponseCode rs = new ResponseCode();
        rs = os.selectOne(orderId);
        return rs ;
    }

    //订单详情
    private ResponseCode listDo(HttpServletRequest request) {
        String pageSize = request.getParameter("pageSize");
        String pageNum = request.getParameter("pageNum");
        ResponseCode rs = new ResponseCode();
        //调用业务层处理业务
        rs = os.selectAll(pageSize,pageNum);

        return rs;
    }
}
