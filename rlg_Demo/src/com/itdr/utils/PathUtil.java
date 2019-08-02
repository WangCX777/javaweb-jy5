package com.itdr.utils;

/**
 * @author WangCX
 * @date 2019/8/1 13:36
 */
public class PathUtil {
    public static String getPath(String path){
        String s1 = path.replace(".","/");
        String[] sar = s1.split("/");
        return sar[1];
    }
}
