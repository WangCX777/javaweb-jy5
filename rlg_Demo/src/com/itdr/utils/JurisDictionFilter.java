package com.itdr.utils;

import com.itdr.common.ResponseCode;
import com.itdr.pojo.Users;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * @author WangCX
 * @date 2019/8/2 19:55
 */
@WebFilter(filterName = "JurisDictionFilter",value = "/manage/*")
public class JurisDictionFilter implements Filter {
    public void destroy() {
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        //处理乱码
        req.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html;charset=UTF-8");

        //统一数据返回对象
        ResponseCode rs = new ResponseCode();
        //转型，使用子类的更多方法
        HttpServletRequest request = (HttpServletRequest) req;
        //获取路径
        String pathInfo = request.getPathInfo();
        if(pathInfo.equals("/login.do")){
            chain.doFilter(req, resp);
            return;
        }
        //其它请求处理
        //验证session是否有用户信息
        HttpSession session = request.getSession();
        Users user = (Users) session.getAttribute("user");
        if(user == null){
            rs.setStatus(Integer.parseInt(PropertiesGetUtil.getValue("USER_NO_LOGIN")));
            rs.setMag(PropertiesGetUtil.getValue("USER_NO_LOGIN_MSG"));
            //当有页面之后 ，我就让用户重定向到登录页面
            resp.getWriter().write(rs.toString());
            return;
        }
        if(user.getU_type() != 1){
            rs.setStatus(Integer.parseInt(PropertiesGetUtil.getValue("USER_NO_ROOT")));
            rs.setMag(PropertiesGetUtil.getValue("USER_NO_ROOT_MSG"));
            resp.getWriter().write(rs.toString());
            return;
        }

        //没问题放行
        chain.doFilter(req,resp);
        return;
    }

    public void init(FilterConfig config) throws ServletException {

    }

}
