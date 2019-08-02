package com.itdr.utils;

import com.mchange.v2.c3p0.ComboPooledDataSource;

/**
 * @author WangCX
 * @date 2019/8/1 11:43
 */
public class PoolUtil {
    public static final ComboPooledDataSource co = new ComboPooledDataSource();
    public static ComboPooledDataSource getCom(){
        return co;
    }
}
