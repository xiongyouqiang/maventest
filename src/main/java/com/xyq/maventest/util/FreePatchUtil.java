package com.xyq.maventest.util;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/***
 * 
* Project Name:maventest
* <p>增量打包工具类 
*
* @ClassName: FreePatchUtil
* @date 2018年6月29日  上午11:29:19
*
* @author youqiang.xiong
* @version 1.0
* @since  
* @see
 */
public class FreePatchUtil {

//	public static final String projectName = "EC_CCP";
//	public static final String projectName = "EC_TAOBAO";
	public static final String projectName = "EC_OFFICIAL_APPLETS";
	public static final String baseDir = "E:\\workplaces\\";
	
	/**
	 * 补丁文件,由eclipse svn plugin生成
	 */
    public static String patchFile=baseDir+projectName+"\\patch.txt";  
    /**
     * 项目文件夹路径  
     */
    public static String projectPath=baseDir +projectName;
    /**
     * web应用文件夹名  
     */
    public static String webContent="WebContent";
    /***
     * class存放路径  
     */
    public static String classPath=baseDir+projectName+"\\WebContent\\WEB-INF\\classes";
   /***
    * 补丁文件包存放路径  
    */
    public static String desPath="C:\\Users\\youqiang.xiong\\Desktop\\update_pkg";
    /***
     * 补丁版本
     */
    public static String version="";  
    
    private static SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMddhhmmss");
    
    
      static {
    	  
    	  version = formatter.format(new Date());
      }
      
    /** 
     * @param args 
     * @throws Exception  
     */  
    public static void main(String[] args) throws Exception {  
        copyFiles(getPatchFileList());  
    }  
     
    /****
     * 读取补丁配置文件解析出修改的文件并返回到list集合
     * @return
     * @throws Exception
     */
    public static List<String> getPatchFileList() throws Exception{  
        List<String> fileList=new ArrayList<String>();  
        FileInputStream f = new FileInputStream(patchFile);   
        BufferedReader dr=new BufferedReader(new InputStreamReader(f,"utf-8"));  
        String line;  
        while((line=dr.readLine())!=null){   
            if(line.indexOf("Index:")!=-1){  
                line=line.replaceAll(" ","");  
                line=line.substring(line.indexOf(":")+1,line.length());  
                fileList.add(line);  
            }  
        }  
        dr.close();
        return fileList;  
    }  
    
    /***
     * 拷贝文件
     * @param list 修改的文件
     */
    public static void copyFiles(List<String> list){  
          
        for(String fullFileName:list){  
        	//对源文件目录下的文件处理  
            if(fullFileName.indexOf("src/")!=-1){
                String fileName=fullFileName.replace("src","");  
                fullFileName=classPath+fileName;  
                if(fileName.endsWith(".java")){  
                    fileName=fileName.replace(".java",".class");  
                    fullFileName=fullFileName.replace(".java",".class");  
                }  
                String tempDesPath=fileName.substring(0,fileName.lastIndexOf("/"));  
                String desFilePathStr=desPath+"/"+version+"/WEB-INF/classes"+tempDesPath;  
                String desFileNameStr=desPath+"/"+version+"/WEB-INF/classes"+fileName;  
                File desFilePath=new File(desFilePathStr);  
                if(!desFilePath.exists()){  
                    desFilePath.mkdirs();  
                } 
                copyFile(fullFileName, desFileNameStr);  
                System.out.println(fullFileName+"复制完成");  
                //遍历目录，是否存在内部类，如果有内部，则将所有的额内部类挑选出来放到
                copyInnerClassFile(fullFileName, desFileNameStr);
            }else{//对普通目录的处理  
                String desFileName=fullFileName.replaceAll(webContent,"");  
                //将要复制的文件全路径  
                fullFileName=projectPath+"/"+fullFileName;
                String fullDesFileNameStr=desPath+"/"+version+desFileName;  
                String desFilePathStr=fullDesFileNameStr.substring(0,fullDesFileNameStr.lastIndexOf("/"));  
                File desFilePath=new File(desFilePathStr);  
                if(!desFilePath.exists()){  
                    desFilePath.mkdirs();  
                }  
                copyFile(fullFileName, fullDesFileNameStr);  
                System.out.println(fullFileName+"复制完成");  
               
            }  
              
        }  
          
    }  
  
    /***
     * 解析源路径名称，遍历此文件路径下是否存在这个类的内部类<br>
     * 内部类编译后的格式一般是 OuterClassName$InnerClassName.class
     * @param sourceFullFileName 原路径
     * @param desFullFileName 目标路径
     */
    private static void copyInnerClassFile(String sourceFullFileName,String desFullFileName){
    	
    	String sourceFileName = sourceFullFileName.substring(sourceFullFileName.lastIndexOf("/")+1);
    	String sourcePackPath = sourceFullFileName.substring(0,sourceFullFileName.lastIndexOf("/"));
    	String destPackPath = desFullFileName.substring(0,desFullFileName.lastIndexOf("/"));
    	String tempFileName = sourceFileName.split("\\.")[0];
    	 // 创建 Pattern 对象
    	File packFile = new File(sourcePackPath);
    	if(packFile.isDirectory()){
    		String[] listFiles = packFile.list();
    		for(String fileName:listFiles){
    			if(fileName.indexOf(tempFileName+"$")>-1 && fileName.endsWith(".class")){
    				String newSourceFullFileName = sourcePackPath+"/" +fileName;
    				String newDesFullFileName = destPackPath + "/" + fileName;
    				copyFile(newSourceFullFileName, newDesFullFileName);  
                    System.out.println(newSourceFullFileName+"复制完成");  
    			}
    		}
    	}
    	
    }
    
    private static void copyFile(String sourceFileNameStr, String desFileNameStr) {  
        File srcFile=new File(sourceFileNameStr);  
        File desFile=new File(desFileNameStr);  
        try {  
            copyFile(srcFile, desFile);  
        } catch (IOException e) {  
            e.printStackTrace();  
        }  
    }  
      
  
      
      
    public static void copyFile(File sourceFile, File targetFile) throws IOException {  
    	if(!sourceFile.isFile()) return;
        BufferedInputStream inBuff = null;  
        BufferedOutputStream outBuff = null;  
        try {  
            // 新建文件输入流并对它进行缓冲  
            inBuff = new BufferedInputStream(new FileInputStream(sourceFile));  
  
            // 新建文件输出流并对它进行缓冲  
            outBuff = new BufferedOutputStream(new FileOutputStream(targetFile));  
  
            // 缓冲数组  
            byte[] b = new byte[1024 * 5];  
            int len;  
            while ((len = inBuff.read(b)) != -1) {  
                outBuff.write(b, 0, len);  
            }  
            // 刷新此缓冲的输出流  
            outBuff.flush();  
        } finally {  
            // 关闭流  
            if (inBuff != null){
            	inBuff.close();  
            }
            if (outBuff != null){
            	outBuff.close();  
            }
        }  
    }  
}
