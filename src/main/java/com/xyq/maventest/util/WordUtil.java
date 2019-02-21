package com.xyq.maventest.util;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.HashMap;
import java.util.Map;

import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;
/***
 * 
* Project Name:maventest
* <p>生成word工具类<br> 
*
* @ClassName: WordUtil
* @date 2019年2月20日  下午5:50:49
*
* @author youqiang.xiong
* @version 1.0
* @since  
* @see
 */
public class WordUtil {  
      
    private Configuration configuration = null;  
    
    /****
     * 模板文件存放的目录
     */
    private static final String  baseDir = "F:/study/GIT/maventest/src/main/resources/freemaker";
    /***
     * 模板文件名称
     */
    private static final String  templateFile = "export.ftl";
    /***
     * word生成的输出目录
     */
    private static final String  outputDir = "F:/file/";
      
    public WordUtil(){  
        configuration = new Configuration();  
        configuration.setDefaultEncoding("UTF-8");  
    }  
      
    public static void main(String[] args) {  
        WordUtil test = new WordUtil();  
        test.createWord();  
    }  
     
    /*****
     * 
    * Project Name: maventest
    * <p>转换成word<br> 
    *
    * @author youqiang.xiong
    * @date 2019年2月21日  上午11:22:03
    * @version v1.0
    * @since
     */
    public void createWord(){  
        Map<String,Object> dataMap=new HashMap<String,Object>();  
        //构造参数
        getData(dataMap);  
        
        configuration.setClassForTemplateLoading(this.getClass(), "");//模板文件所在路径
        Template t=null;  
        try {  
        	configuration.setDirectoryForTemplateLoading(new File(baseDir));
        	t = configuration.getTemplate(templateFile);
        } catch (IOException e) {  
            e.printStackTrace();  
        }  
        File outFile = new File(outputDir+Math.random()*10000+".doc"); //导出文件
        Writer out = null;  
        try {  
            out = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(outFile)));  
        } catch (FileNotFoundException e1) {  
            e1.printStackTrace();  
        }  
           
        try {  
            t.process(dataMap, out); //将填充数据填入模板文件并输出到目标文件 
            System.out.println("生成成功...");
        } catch (TemplateException e) {  
            e.printStackTrace();  
        } catch (IOException e) {  
            e.printStackTrace();  
        }  
    }  
  
    /****
     * 
    * Project Name: maventest
    * <p>初始化数据map <br> 
    *
    * @author youqiang.xiong
    * @date 2019年2月21日  上午11:26:34
    * @version v1.0
    * @since 
    * @param dataMap
    * 		封装数据的map
     */
    private void getData(Map<String, Object> dataMap) {  
        dataMap.put("userName", "刘德华");  
        dataMap.put("sex", "男");  
        dataMap.put("nation", "汉族");  
        dataMap.put("birthday", "1985-02-26");   
        dataMap.put("nationPlace", "春日部");  
        dataMap.put("politicalStatus", "党员");  
        dataMap.put("graduationSchool", "双叶幼稚园");  
        dataMap.put("lastBackground", "幼稚园");  
        dataMap.put("graduationMajor", "玩泥沙");  
        dataMap.put("workUnit", "NASA");  
        dataMap.put("business", "煮菜的");  
        dataMap.put("postalAddress", "lc");  
        dataMap.put("postalcode", "lc");  
        dataMap.put("mobile", "18898416969");  
        dataMap.put("admissionTicket", "lc");  
        dataMap.put("enterSchoolTime", "lc");  
        dataMap.put("emergencyContact", "lc");  
        dataMap.put("readingInstrouction", "lc");  
        dataMap.put("year", "2019");  
        dataMap.put("month", "02");  
        dataMap.put("day", "20");  
        dataMap.put("a", "3");  
        dataMap.put("b", "6");  
        dataMap.put("c", "0");  
        dataMap.put("d", "1");  
        dataMap.put("e", "2");  
        dataMap.put("f", "2");  
        dataMap.put("g", "1");  
        dataMap.put("h", "9");  
        dataMap.put("i", "9");  
        dataMap.put("j", "8");  
        dataMap.put("k", "1");  
        dataMap.put("l", "2");  
        dataMap.put("m", "0");  
        dataMap.put("n", "3");  
        dataMap.put("o", "1");  
        dataMap.put("p", "3");  
        dataMap.put("q", "6");  
        dataMap.put("r", "1");  
    }  
}