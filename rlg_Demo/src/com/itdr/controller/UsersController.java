package com.itdr.controller;

import com.itdr.common.ResponseCode;
import com.itdr.pojo.Users;
import com.itdr.service.UserService;
import com.itdr.utils.PathUtil;
import com.mysql.cj.Session;
import jdk.management.resource.internal.ResourceNatives;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

/**
 * @author WangCX
 * @date 2019/8/1 12:48
 */
@WebServlet(value = "/manage/user/*")
public class UsersController extends HttpServlet {

    private UserService uc = new UserService();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
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
            case "login":
                rs = loginDo(request);
                break;
            case "disableuser":
                rs = disableuserDo(request);
                break;
        }
        //返回响应数据
        response.getWriter().write(rs.toString());

    }


    //获取所有用户列表的请求
    private ResponseCode listDo(HttpServletRequest request){
        //获取参数

        String pageSize = request.getParameter("pageSize");
        String pageNum = request.getParameter("pageNum");

        ResponseCode rs = new ResponseCode();

        //调用业务层处理业务
        rs = uc.selectAll(pageSize,pageNum);

        return rs;

    }
    //用户登录的请求
    private ResponseCode loginDo(HttpServletRequest request){
        //获取参数
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        ResponseCode rs = uc.selectOne(username, password);
        HttpSession session = request.getSession();
        session.setAttribute("user",rs.getData());
        return  rs ;
    }
    // 禁用用户
    private ResponseCode disableuserDo(HttpServletRequest request) {
        String u_id = request.getParameter("u_id");
        ResponseCode rs = uc.selectOne(u_id);
        return rs;
    }
}
