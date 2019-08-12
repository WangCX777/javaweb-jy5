package com.itdr.service;

import com.itdr.common.ResponseCode;
import com.itdr.dao.CategoryDao;
import com.itdr.pojo.Category;
import com.itdr.utils.NumberUtil;
import com.itdr.utils.PropertiesGetUtil;

import java.util.ArrayList;
import java.util.List;

public class CategoryService {
    CategoryDao cd = new CategoryDao();
    //根据category查找
    public ResponseCode seleCategory(String category) {
        Integer c_category = Integer.parseInt(category);
        ResponseCode rs = new ResponseCode();
        List<Category> li = cd.selectCategory(c_category);
        if(li != null){
            rs = rs.success(li);
            return rs;
        }
        rs.success(Integer.parseInt(PropertiesGetUtil.getValue("CATEGORY_SELECT_FAIL")),
                PropertiesGetUtil.getValue("CATEGORY_SELECT_FAIL_MSG"));
        return rs;
    }

    //增加节点
    public ResponseCode addCategory( String parentId, String categoryName) {
        ResponseCode rs = new ResponseCode();
        Integer id = Integer.parseInt(parentId);
        int i = 0;
        if (parentId == null || parentId.equals("")){
            id = 0;
        }
        i = cd.addCategory(id,categoryName);
        if(i != 0){
            rs = ResponseCode.success(Integer.parseInt(PropertiesGetUtil.getValue("CATEGORY_SELECT_SUCCESS"))
                    ,PropertiesGetUtil.getValue("CATEGORY_SELECT_SUCCESS_MSG"));
            return rs;
        }
        rs = ResponseCode.success(Integer.parseInt(PropertiesGetUtil.getValue("CATEGORY_ADD_FAIL"))
                ,PropertiesGetUtil.getValue("CATEGORY_ADD_FAIL_MSG"));
        return rs;
    }

    public ResponseCode setcategoryName(String categoryId, String categoryName) {
        ResponseCode rs = new ResponseCode();
        Integer id = Integer.parseInt(categoryId);
        int i = 0;
        i = cd.setCategoryName(id,categoryName);
        if(i != 0){
            rs = ResponseCode.success(Integer.parseInt(PropertiesGetUtil.getValue("CATEGORY_MODIFY_SUCCESS"))
                    ,PropertiesGetUtil.getValue("CATEGORY_MODIFY_SUCCESS_MSG"));
            return rs;
        }
        rs = ResponseCode.success(Integer.parseInt(PropertiesGetUtil.getValue("CATEGORY_MODIFY_FAIL"))
                ,PropertiesGetUtil.getValue("CATEGORY_MODIFY_FAIL_MSG"));
        return rs;
    }

    public ResponseCode get_deep_category(String categoryId) {
        ResponseCode rs = new ResponseCode();
        if (categoryId != null && !categoryId.equals("") && NumberUtil.isNumeric(categoryId)){
            Integer Id = Integer.parseInt(categoryId);
            List<Integer> li = new ArrayList<>();
            getAll(Id,li);
            if (li == null){
                rs = ResponseCode.success(Integer.parseInt(PropertiesGetUtil.getValue("CATEGORY_SELECT_FAIL")),
                        PropertiesGetUtil.getValue("CATEGORY_SELECT_FAIL_MSG"));
            }
            rs  = ResponseCode.success(li);
        }else{
            rs = ResponseCode.success(Integer.parseInt(PropertiesGetUtil.getValue("PARAMETER_ERROR")),
                    PropertiesGetUtil.getValue("PARAMETER_ERROR_MSG"));
        }
        return rs;
    }
    private  void getAll(Integer id,List<Integer> list ){
        List<Category> li  = cd.get_deep_category(id);
        if (li != null && li.size() != 0){
            for (Category category : li ){
                list.add(category.getC_id());
                getAll(category.getC_id(),list);
            }
        }
    }
}
