package com.xyq.maventest.visualvm;

import java.io.File;
import java.lang.reflect.Method;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.ArrayList;
import java.util.List;
/***
 * 测试方法去内存溢出
 * 循环使用ClassLoader 加载 jar包中的类创建对象，存放到list中进行引用，这样gc 就无法对这些对象进行回收
 * 直至方法去内存区域已满并且无法动态扩展内存时，程序就会报PermGen OOM溢出
* @ClassName: TestPermGen 
* @Description: TODO(这里用一句话描述这个类的作用) 
* @author youqiang.xiong
* @date 2018年2月28日 上午11:56:45 
*
 */
public class TestPermGen {

    
    private static List<Object> insList = new ArrayList<Object>();

    public static void main(String[] args) {
    	try{
    		permLeak();
    	}catch(Exception e){
    		e.printStackTrace();
    	}
    }

    private static void permLeak() throws Exception {
        for (int i = 0; i < 10000; i++) {
            URL[] urls = getURLS();
            URLClassLoader urlClassloader = new URLClassLoader(urls, null);
            Class<?> logfClass = Class.forName("org.apache.commons.logging.LogFactory", true,urlClassloader);
            Method getLog = logfClass.getMethod("getLog", String.class);
            Object result = getLog.invoke(logfClass, "TestPermGen");
            insList.add(result);
            System.out.println(i + ": " + result);
        }
    }

    private static URL[] getURLS() throws MalformedURLException {
        File libDir = new File("C:/Users/youqiang.xiong/.m2/repository/commons-logging/commons-logging/1.1.1");
        File[] subFiles = libDir.listFiles();
        int count = subFiles.length;
        URL[] urls = new URL[count];
        for (int i = 0; i < count; i++) {
            urls[i] = subFiles[i].toURI().toURL();
        }
        return urls;
    }

}
