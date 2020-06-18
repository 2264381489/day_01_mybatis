package com.itheima.Mybatis.io;

import java.io.InputStream;

/**
 * 使用类加载器读取文件的类
 */
public class Resources {
    public static InputStream getResourceAsStream(String filePath){
        //认则是从ClassPath根下获取，path不能以’/'开头，最终是由ClassLoader获取资源。
        return Resources.class.getClassLoader().getResourceAsStream(filePath);



    }
}
