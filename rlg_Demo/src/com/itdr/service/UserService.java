package com.itdr.service;

import com.itdr.common.Const;
import com.itdr.common.ResponseCode;
import com.itdr.dao.UserDao;
import com.itdr.pojo.Users;
import com.itdr.utils.PropertiesGetUtil;


import java.util.List;

/**
 * @author WangCX
 * @date 2019/8/1 12:56
 */
public class UserService {
    private UserDao ud = new UserDao();
    //用户列表
    public ResponseCode selectAll(String pageSize, String pageNum) {
        Integer s = null;
        Integer n = null;
        if(pageSize == null || pageSize.equals("")){
            pageSize = "10";
            s = Integer.parseInt(pageSize);
        }
        if(pageNum == null || pageNum.equals("")){
            pageNum = "1";
            n = Integer.parseInt(pageNum);
        }


        List<Users> li = ud.selectAll(s,n);
        //如果集元素是空呢？

        ResponseCode rs = new ResponseCode();
        rs = ResponseCode.success(li);
        return rs;
    }
    //用户登录
    public ResponseCode selectOne(String username , String password){
        ResponseCode rs = new ResponseCode();
        if(username == null || username.equals("") || password == null || password.equals("")){
            rs = ResponseCode.success(Integer.parseInt(PropertiesGetUtil.getValue("USER_ERROR_NAME_LOGIN")),
                    PropertiesGetUtil.getValue("USER_ERROR_NAME_LOGIN_MSG"));
            return rs;
        }
        //查找是否存在用户

        Users u = ud.selectOne(username,password);
        //如果用户不存在
        if(u == null){
            rs = ResponseCode.success(Integer.parseInt(PropertiesGetUtil.getValue("USER_ERROR_NAME_LOGIN")),
                    PropertiesGetUtil.getValue("USER_ERROR_NAME_LOGIN_MSG") );
            return rs;
        }
        //用户权限
        if(u.getU_type() != 1){
            rs = ResponseCode.success(Integer.parseInt(PropertiesGetUtil.getValue("USER_NO_ROOT")),
                    PropertiesGetUtil.getValue("USER_NO_ROOT_MSG"));
            return rs;
        }
        rs = ResponseCode.success(u);
        return rs;
    }
    //用户禁用
    public ResponseCode selectOne(String u_ids) {
        ResponseCode rs = new ResponseCode();
        if(u_ids == null || u_ids.equals("")){
            rs = ResponseCode.success(Integer.parseInt(PropertiesGetUtil.getValue("USER_PARAMETER_CODE"))
            ,PropertiesGetUtil.getValue("USER_PARAMETER_MSG"));
            return rs;
        }
        Integer u_id = null;
        try {
             u_id = Integer.parseInt(u_ids);
        }catch (Exception e){
            rs = ResponseCode.success(Integer.parseInt(PropertiesGetUtil.getValue("USER_ERROR_ID"))
            ,PropertiesGetUtil.getValue("USER_ERROR_ID_MSG"));
            return rs;
        }

        //查找是否存在用户
        Users u = ud.selectOne(u_id);
        //如果用户不存在
        if(u == null){
            rs = ResponseCode.success(Integer.parseInt(PropertiesGetUtil.getValue("USER_NO_CODE"))
            ,PropertiesGetUtil.getValue("USER_NO_MSG"));
            return rs;
        }
        //用户权限
        if(u.getU_stats() == 1){
            rs = ResponseCode.success(Integer.parseInt(PropertiesGetUtil.getValue("USER_DISABLE_CODE"))
            ,PropertiesGetUtil.getValue("USER_DISABLE_MSG"));
            return rs;
        }
        //禁用用户
        int row = ud.updateByUid(u_id);
        if(row <= 0){
            rs = ResponseCode.success(Integer.parseInt(PropertiesGetUtil.getValue("USER_DISABLE_FAIL"))
            ,PropertiesGetUtil.getValue("USER_DISABLE_FAIL_MSG"));
            return rs;
        }
        rs = ResponseCode.success(Integer.parseInt(PropertiesGetUtil.getValue("USER_DISABLE_SUCCESS"))
                ,row,PropertiesGetUtil.getValue("USER_DISABLE_SUCCESS_MSG"));

        return rs;

    }
}
