package com.itdr.utils;

import sun.security.action.GetPropertyAction;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Properties;

/**
 * @author WangCX
 * @date 2019/8/1 18:47
 */
public class PropertiesGetUtil {
    public static String getValue(String key){
        Properties ps = new Properties();

        try {
            InputStreamReader in =new InputStreamReader(PropertiesGetUtil.class.getClassLoader()
                    .getResourceAsStream("const.properties"),"UTF-8") ;
            ps.load(in);
        } catch (IOException e) {
            e.printStackTrace();
        }
        String value = ps.getProperty(key);
        return value;
    }

//    public static void main(String [] args){
//        System.out.println(getValue("USER_DISABLE_CODE"));
//        System.out.println(getValue("USER_DISABLE_MSG"));
//    }
}
