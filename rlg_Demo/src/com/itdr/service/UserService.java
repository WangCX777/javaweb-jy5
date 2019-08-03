package com.itdr.service;

import com.itdr.common.Const;
import com.itdr.common.ResponseCode;
import com.itdr.dao.UserDao;
import com.itdr.pojo.Users;

import java.util.List;

/**
 * @author WangCX
 * @date 2019/8/1 12:56
 */
public class UserService {
    private UserDao ud = new UserDao();
    //用户列表
    public ResponseCode selectAll(String pageSize, String pageNum) {
        if(pageSize == null || pageSize.equals("")){
            pageSize = "10";
        }
        if(pageNum == null || pageNum.equals("")){
            pageNum = "1";
        }


        List<Users> li = ud.selectAll(pageSize,pageNum);
        //如果集元素是空呢？

        ResponseCode rs = new ResponseCode();
        rs.setStatus(0);
        rs.setData(li);
        return rs;
    }
    //用户登录
    public ResponseCode selectOne(String username , String password){
        ResponseCode rs = new ResponseCode();
        if(username == null || username.equals("") || password == null || password.equals("")){
           rs.setStatus(1);
           rs.setMag("账户或密码错误");
           return rs;
        }
        //查找是否存在用户
        Users u = ud.selectOne(username,password);
        //如果用户不存在
        if(u == null){
            rs.setStatus(1);
            rs.setMag("账户或密码错误");
            return rs;
        }
        //用户权限
        if(u.getU_type() != 1){
            rs.setStatus(2);
            rs.setMag("没有权限");
            return rs;
        }
        rs.setStatus(0);
        rs.setData(u);
        return rs;
    }
    //用户禁用
    public ResponseCode selectOne(String u_ids) {
        ResponseCode rs = new ResponseCode();
        if(u_ids == null || u_ids.equals("")){
            rs.setStatus(Const.USER_PARAMETER_CODE);
            rs.setMag(Const.USER_PARAMETER_MSG);
            return rs;
        }
        Integer u_id = null;
        try {
             u_id = Integer.parseInt(u_ids);
        }catch (Exception e){
            rs.setStatus(105);
            rs.setMag("输入非法参数");
            return rs;
        }

        //查找是否存在用户
        Users u = ud.selectOne(u_id);
        //如果用户不存在
        if(u == null){
            rs.setStatus(Const.USER_NO_CODE);
            rs.setMag(Const.USER_NO_MSG);
            return rs;
        }
        //用户权限
        if(u.getU_stats() == 1){
            rs.setStatus(Const.USER_DISABLE_CODE);
            rs.setMag(Const.USER_DISABLE_MSG);
            return rs;
        }
        //禁用用户
        int row = ud.updateByUid(u_id);
        if(row <= 0){
            rs.setStatus(106);
            rs.setMag("用户禁用更新失败");
            return rs;
        }

        rs.setStatus(0);
        rs.setData(row);
        rs.setMag("禁用成功");
        return rs;

    }
}
