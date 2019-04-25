package com.xyq.maventest.util;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.awt.image.ColorModel;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;
import java.util.Iterator;

import javax.imageio.IIOImage;
import javax.imageio.ImageIO;
import javax.imageio.ImageReadParam;
import javax.imageio.ImageReader;
import javax.imageio.ImageTypeSpecifier;
import javax.imageio.ImageWriteParam;
import javax.imageio.ImageWriter;
import javax.imageio.metadata.IIOMetadata;
import javax.imageio.plugins.jpeg.JPEGImageWriteParam;
import javax.imageio.stream.ImageInputStream;
import javax.imageio.stream.ImageOutputStream;

import org.w3c.dom.Element;

import com.sun.imageio.plugins.jpeg.JPEGImageWriter;
 

/***
 * 
* Project Name:maventest
* <p>切图工具类<br> 
*
* @ClassName: ImgUtil
* @date 2019年4月18日  下午5:12:06
*
* @author youqiang.xiong
* @version 1.0
* @since  
* @see
 */
public class ImgUtil { 
 
      /**
     * 图片压缩测试
     * @param args
     */
    public static void main(String args[]){ 
    	String fileName = "C:\\Users\\youqiang.xiong\\Desktop\\底图\\poster";
    	
    	try {
    		BufferedImage image = ImageIO.read(new File("C:\\\\Users\\\\youqiang.xiong\\\\Desktop\\\\底图\\\\poster.jpg"));
			BufferedImage bi = cutPic(image, 158, 0, 750, 830);
			
            ImageIO.write(bi, "jpg", new File(fileName+"-222"+".jpg"));

		} catch (IOException e) {
			e.printStackTrace();
		}
    }
    
 
    /**********************************好用的压缩方法开始*******************************************/
    /**
     * 图片压缩 
     * @param pathName  图片的路径 压缩图片直接替换当前图片
     */
    public static void    ImgCompress(String pathName){
        int n=pathName.lastIndexOf("/");
        String url=pathName.substring(0,n+1);
        String name=pathName.substring(n+1);
        
        Tosmallerpic(url,new File(url+name),"",name,188,165,(float)0.7); 
    }
    
    
    
    /**
     * 此方法压缩不失真很好用 举例用法
     * @param url    E:/cims/cimsdata/afr/20160922/
     * @param name    1111111.jpg
     */
    public static void img_change(String url,String name) 
    { 
            Tosmallerpic(url,new File(url+name),"_middle",name,188,165,(float)0.7); 
            Tosmallerpic(url,new File(url+name),"_small",name,45,45,(float)0.7); 
            Tosmallerpic(url,new File(url+name),"_smaller",name,116,100,(float)0.7); 
    } 
     
    /** 
    * 
    * @param f 图片所在的文件夹路径 
    * @param file 图片路径 
    * @param ext 扩展名 
    * @param n 图片名 
    * @param w 目标宽 
    * @param h 目标高 
    * @param per 百分比 
    */ 
    private static void  Tosmallerpic(String f,File file,String ext,String n,int w,int h,float per){ 
            Image src; 
            try { 
                src  =  javax.imageio.ImageIO.read(file); //构造Image对象 
 
               String img_midname  =  f+n.substring(0,n.indexOf("."))+ext+n.substring(n.indexOf(".")); 
               int old_w = src.getWidth(null); //得到源图宽 
               int old_h = src.getHeight(null); 
               int new_w = 0; 
               int new_h = 0; //得到源图长 
 
               double w2 = (old_w*1.00)/(w*1.00); 
               double h2 = (old_h*1.00)/(h*1.00); 
 
               //图片跟据长宽留白，成一个正方形图。 
               BufferedImage oldpic; 
               if(old_w>old_h) 
               { 
                   oldpic = new BufferedImage(old_w,old_w,BufferedImage.TYPE_INT_RGB); 
               }else{if(old_w<old_h){ 
                   oldpic = new BufferedImage(old_h,old_h,BufferedImage.TYPE_INT_RGB); 
               }else{ 
                    oldpic = new BufferedImage(old_w,old_h,BufferedImage.TYPE_INT_RGB); 
               } 
               } 
                Graphics2D g  =  oldpic.createGraphics(); 
                g.setColor(Color.white); 
                if(old_w>old_h) 
                { 
                    g.fillRect(0, 0, old_w, old_w); 
                    g.drawImage(src, 0, (old_w - old_h) / 2, old_w, old_h, Color.white, null); 
                }else{ 
                    if(old_w<old_h){ 
                    g.fillRect(0,0,old_h,old_h); 
                    g.drawImage(src, (old_h - old_w) / 2, 0, old_w, old_h, Color.white, null); 
                    }else{ 
                        //g.fillRect(0,0,old_h,old_h); 
                        g.drawImage(src.getScaledInstance(old_w, old_h,  Image.SCALE_SMOOTH), 0,0,null); 
                    } 
                }              
                g.dispose(); 
                src  =  oldpic; 
                //图片调整为方形结束 
               if(old_w>w) 
               new_w = (int)Math.round(old_w/w2); 
               else 
                   new_w = old_w; 
               if(old_h>h) 
               new_h = (int)Math.round(old_h/h2);//计算新图长宽 
               else 
                   new_h = old_h; 
               BufferedImage image_to_save  =  new BufferedImage(new_w,new_h,BufferedImage.TYPE_INT_RGB);        
               image_to_save.getGraphics().drawImage(src.getScaledInstance(new_w, new_h,  Image.SCALE_SMOOTH), 0,0,null); 
               FileOutputStream fos = new FileOutputStream(img_midname); //输出到文件流 
                
               //旧的使用 jpeg classes进行处理的方法
//               JPEGImageEncoder encoder  =  JPEGCodec.createJPEGEncoder(fos); 
//               JPEGEncodeParam jep = JPEGCodec.getDefaultJPEGEncodeParam(image_to_save); 
                /* 压缩质量 */ 
//               jep.setQuality(per, true); 
//               encoder.encode(image_to_save, jep); 
                
               //新的方法
               saveAsJPEG(100, image_to_save, per, fos);
                
               fos.close(); 
               } catch (IOException ex) { 
                //Logger.getLogger(Img_Middle.class.getName()).log(Level.SEVERE, null, ex); 
            } 
    } 
     
   
    /**
     * 以JPEG编码保存图片
     * @param dpi  分辨率
     * @param image_to_save  要处理的图像图片
     * @param JPEGcompression  压缩比
     * @param fos 文件输出流
     * @throws IOException
     */
    public static void saveAsJPEG(Integer dpi ,BufferedImage image_to_save, float JPEGcompression, FileOutputStream fos) throws IOException {
          
        //useful documentation at http://docs.oracle.com/javase/7/docs/api/javax/imageio/metadata/doc-files/jpeg_metadata.html
        //useful example program at http://johnbokma.com/java/obtaining-image-metadata.html to output JPEG data
      
        //old jpeg class
        //com.sun.image.codec.jpeg.JPEGImageEncoder jpegEncoder  =  com.sun.image.codec.jpeg.JPEGCodec.createJPEGEncoder(fos);
        //com.sun.image.codec.jpeg.JPEGEncodeParam jpegEncodeParam  =  jpegEncoder.getDefaultJPEGEncodeParam(image_to_save);
      
        // Image writer
        JPEGImageWriter imageWriter  =  (JPEGImageWriter) ImageIO.getImageWritersBySuffix("jpg").next();
        ImageOutputStream ios  =  ImageIO.createImageOutputStream(fos);
        imageWriter.setOutput(ios);
        //and metadata
        IIOMetadata imageMetaData  =  imageWriter.getDefaultImageMetadata(new ImageTypeSpecifier(image_to_save), null);
         
         
        if(dpi !=  null && !dpi.equals("")){
             
             //old metadata
            //jpegEncodeParam.setDensityUnit(com.sun.image.codec.jpeg.JPEGEncodeParam.DENSITY_UNIT_DOTS_INCH);
            //jpegEncodeParam.setXDensity(dpi);
            //jpegEncodeParam.setYDensity(dpi);
      
            //new metadata
            Element tree  =  (Element) imageMetaData.getAsTree("javax_imageio_jpeg_image_1.0");
            Element jfif  =  (Element)tree.getElementsByTagName("app0JFIF").item(0);
            jfif.setAttribute("Xdensity", Integer.toString(dpi) );
            jfif.setAttribute("Ydensity", Integer.toString(dpi));
             
        }
      
        if(JPEGcompression >= 0 && JPEGcompression <= 1f){
      
            //old compression
            //jpegEncodeParam.setQuality(JPEGcompression,false);
      
            // new Compression
            JPEGImageWriteParam jpegParams  =  (JPEGImageWriteParam) imageWriter.getDefaultWriteParam();
            jpegParams.setCompressionMode(JPEGImageWriteParam.MODE_EXPLICIT);
            jpegParams.setCompressionQuality(JPEGcompression);
      
        }
      
        //old write and clean
        //jpegEncoder.encode(image_to_save, jpegEncodeParam);
      
        //new Write and clean up
        imageWriter.write(imageMetaData, new IIOImage(image_to_save, null, null), null);
        ios.close();
        imageWriter.dispose();
      
    }
    /**********************************好用的压缩方法结束*******************************************/

    /**
     * 压缩图片文件 测试发现图片压缩小了会失真 不如上面的方法好用
     * @param srcFilePath    当前图片地址
     * @param descFilePath    压缩后的地址
     * @return
     */
     public static boolean compressPic(String srcFilePath, String descFilePath)  
        {  
            File file = null;  
            BufferedImage src = null;  
            FileOutputStream out = null;  
            ImageWriter imgWrier;  
            ImageWriteParam imgWriteParams;  
      
            // 指定写图片的方式为 jpg  
            imgWrier = ImageIO.getImageWritersByFormatName("jpg").next();  
            imgWriteParams = new javax.imageio.plugins.jpeg.JPEGImageWriteParam(null);  
            // 要使用压缩，必须指定压缩方式为MODE_EXPLICIT  
            imgWriteParams.setCompressionMode(imgWriteParams.MODE_EXPLICIT);  
            // 这里指定压缩的程度，参数qality是取值0~1范围内，  
            imgWriteParams.setCompressionQuality((float)0.1);  
            imgWriteParams.setProgressiveMode(imgWriteParams.MODE_DISABLED);  
            ColorModel colorModel = ColorModel.getRGBdefault();  
            // 指定压缩时使用的色彩模式  
            imgWriteParams.setDestinationType(new javax.imageio.ImageTypeSpecifier(colorModel, colorModel  
                    .createCompatibleSampleModel(16, 16)));  
      
            try  
            {  
                if(null==srcFilePath||"".equals(srcFilePath))  
                {  
                    return false;  
                }  
                else  
                {  
                    file = new File(srcFilePath);  
                    src = ImageIO.read(file);  
                    out = new FileOutputStream(descFilePath);  
      
                    imgWrier.reset();  
                    // 必须先指定 out值，才能调用write方法, ImageOutputStream可以通过任何 OutputStream构造  
                    imgWrier.setOutput(ImageIO.createImageOutputStream(out));  
                    // 调用write方法，就可以向输入流写图片  
                    imgWrier.write(null, new IIOImage(src, null, null), imgWriteParams);  
                    out.flush();  
                    out.close();  
                }  
            }  
            catch(Exception e)  
            {  
                e.printStackTrace();  
                return false;  
            }  
            return true;  
        }  
    
     /**
      * 切图 
      * @param fileName
      * @param x
      * @param y
      * @param width
      * @param height
      * @throws IOException
      */
     public static void cutHead(String fileName,int x,int y,int width,int height) throws IOException {

            FileInputStream is = null;
            ImageInputStream iis = null;
            try {
                is = new FileInputStream(fileName+".jpg");
                Iterator<ImageReader> it = ImageIO
                        .getImageReadersByFormatName("jpg");
                ImageReader reader = it.next();
                iis = ImageIO.createImageInputStream(is);
                reader.setInput(iis, true);
                ImageReadParam param = reader.getDefaultReadParam();
                Rectangle rect = new Rectangle(x, y, width, height);
                param.setSourceRegion(rect);
                BufferedImage bi = reader.read(0, param);
                
                ImageIO.write(bi, "jpg", new File(fileName+"-1"+".jpg"));

            } finally {
                if (is != null)
                    is.close();
                if (iis != null)
                    iis.close();
            }

        }
     
     /****
      * 
     * Project Name: maventest
     * <p>根据指定位置来切图 <br> 
     *
     * @author youqiang.xiong
     * @date 2019年1月11日  下午5:24:13
     * @version v1.0
     * @since 
     * @param image
     * 			待剪切的图片
     * @param x
     * 			从x坐标开始
     * @param y
     * 			从y坐标开始
     * @param width
     * 		    新图片的长度
     * @param height
     * 			新图片的宽度
     * @return
     * @throws IOException
      */
	public static BufferedImage cutPic(BufferedImage image, int x, int y, int width, int height) throws IOException {

		BufferedImage bi = null;

		ByteArrayOutputStream os = new ByteArrayOutputStream();
		ImageIO.write(image, "jpg", os);
		InputStream is = null;
		ImageInputStream iis = null;
		try {
			is = new ByteArrayInputStream(os.toByteArray());
			Iterator<ImageReader> it = ImageIO.getImageReadersByFormatName("jpg");
			ImageReader reader = it.next();
			iis = ImageIO.createImageInputStream(is);
			reader.setInput(iis, true);
			ImageReadParam param = reader.getDefaultReadParam();
			Rectangle rect = new Rectangle(x, y, width, height);
			param.setSourceRegion(rect);
			bi = reader.read(0, param);

		} finally {
			if (is != null)
				is.close();
			if (iis != null)
				iis.close();
		}

		return bi;

	}
     
     
     
     	/**缩率图
         * Title: thumbnailImage 测试发现压缩到了大部分图片2K
         * Description: 根据图片路径生成缩略图 
         * @param imagePath    原图片路径
         * @param w            缩略图宽
         * @param h            缩略图高
         * @param prevfix    生成缩略图的前缀
         * @param force        是否强制按照宽高生成缩略图(如果为false，则生成最佳比例缩略图)
         */
        public static void thumbnailImage(File imgFile, int w, int h, String prevfix, boolean force){
            byte[] data=null;
            if(imgFile.exists()){
                try {
                    // ImageIO 支持的图片类型 : [BMP, bmp, jpg, JPG, wbmp, jpeg, png, PNG, JPEG, WBMP, GIF, gif]
                    String types = Arrays.toString(ImageIO.getReaderFormatNames());
                    String suffix = null;
                    // 获取图片后缀
                    if(imgFile.getName().indexOf(".") > -1) {
                        suffix = imgFile.getName().substring(imgFile.getName().lastIndexOf(".") + 1);
                    }// 类型和图片后缀全部小写，然后判断后缀是否合法
                    if(suffix == null || types.toLowerCase().indexOf(suffix.toLowerCase()) < 0){
                        //logger.error("Sorry, the image suffix is illegal. the standard image suffix is {}." + types);
                        //return null;
                    }
                    //logger.debug("target image's size, width:{}, height:{}.");
                    Image img = ImageIO.read(imgFile);
                    if(!force){
                        // 根据原图与要求的缩略图比例，找到最合适的缩略图比例
                        int width = img.getWidth(null);
                        int height = img.getHeight(null);
                        if((width*1.0)/w < (height*1.0)/h){
                            if(width > w){
                                h = Integer.parseInt(new java.text.DecimalFormat("0").format(height * w/(width*1.0)));
                                //logger.debug("change image's height, width:{}, height:{}.");
                            }
                        } else {
                            if(height > h){
                                w = Integer.parseInt(new java.text.DecimalFormat("0").format(width * h/(height*1.0)));
                                //logger.debug("change image's width, width:{}, height:{}.");
                            }
                        }
                    }
                    BufferedImage bi = new BufferedImage(w, h, BufferedImage.TYPE_INT_RGB);
                    
                    Graphics g = bi.getGraphics();
                    g.drawImage(img, 0, 0, w, h, Color.LIGHT_GRAY, null);
                    g.dispose();
                    String p = imgFile.getPath();
                    // 将图片保存在原目录并加上前缀
                    String str=p.substring(0,p.lastIndexOf(File.separator)) + File.separator + prevfix +imgFile.getName();
                    ByteArrayOutputStream out = new ByteArrayOutputStream();  
                    //boolean flag = ImageIO.write(bi, "gif", out);  
                    boolean flag = ImageIO.write(bi, suffix, out);  
                    //如果返回数据的话就把下面的注释打开
                    // data = out.toByteArray();
                    //return data;
                    //些图片到某个路径
                    ImageIO.write(bi, suffix, new File(p.substring(0,p.lastIndexOf(File.separator)) + File.separator + prevfix +imgFile.getName()));
                } catch (IOException e) {
                    //logger.error("generate thumbnail image failed.",e);
                }
            }else{
                //logger.warn("the image is not exist.");
            }
            //return data;
        }

}