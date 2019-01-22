package com.xyq.maventest.util;

import java.awt.AlphaComposite;
import java.awt.Color;
import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;
import java.awt.font.FontRenderContext;
import java.awt.geom.RoundRectangle2D;
import java.awt.image.BufferedImage;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.util.Arrays;
import java.util.List;

import javax.imageio.ImageIO;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import net.coobird.thumbnailator.Thumbnails;




/****
 * 
* Project Name:maventest
* <p>小程序海报合成图片工具类<br> 
*
* @ClassName: ImageUtils
* @date 2019年1月22日  下午4:25:07
*
* @author youqiang.xiong
* @version 1.0
* @since  
* @see
 */
public class ImageUtils {
	
	 private static final Logger logger = LoggerFactory.getLogger(ImageUtils.class);
	 
	public static Font getPingFang() {

		BufferedInputStream bis = null;
		Font definedFont = null;

		try {
			bis = new BufferedInputStream(new FileInputStream(
					"C:\\Users\\youqiang.xiong\\git\\WechatManagement\\wechat-management-parent\\wechat-management-m-web\\src\\main\\resources\\pingfang.ttf"));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		try {
			definedFont = Font.createFont(Font.TRUETYPE_FONT, bis);
			return definedFont;
		} catch (FontFormatException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}

	 
	 public static void main(String[] args) {
		
		 try {
			 BufferedImage bg = ImageIO.read(new File("C:\\Users\\youqiang.xiong\\Desktop\\底图\\base1.png"));
			 BufferedImage poster = ImageIO.read(new File("C:\\\\Users\\\\youqiang.xiong\\\\Desktop\\\\底图\\\\poster.jpg"));
			 BufferedImage qr = ImageIO.read(new URL("http://static.sunlands.com/wechat-management/dev/openCourse/qr/4E2B3B1BBD0809721061A6ADEF9E7555.png"));
			 BufferedImage avatar = ImageIO.read(new URL("https://wx.qlogo.cn/mmopen/vi_32/Q0j4TwGTfTK4DYtvaMV6YIficQnj2D8CiaabaSAq1kzNZUAZCWn5oGv6n8AnjuYTH3bBqELica2yeKbYiakSUMsQIQ/132"));
			 String nickname = "二狗子";
			 String courseName = "如何制作一份专业的PPT";
			 String courseTip = "给人看和给人讲的PPT有什么区别？\n为什么用了模板还是很丑为什么用了模板还是很丑为什么用了模板还是很丑？\n如何体现PPT制作的专业性?";
			 BufferedImage img = ImageUtils.createSharePoster(bg, poster, qr, avatar, getPingFang(), nickname, courseName, courseTip);

			 ImageIO.write(img, "jpg", new File("C:\\Users\\youqiang.xiong\\Desktop\\底图\\result4.jpg"));
		}  catch (Exception e) {
			logger.info("createSharePoster method throw exception:{}",e.getMessage());
		}
	}
	 
	 /****
	     * 
	    * Project Name: wechat-management-util
	    * <p>公开课小程序后台生成分享海报 <br> 
	    *
	    * @author youqiang.xiong
	    * @date 2019年1月11日  下午4:28:21
	    * @version v1.0
	    * @since 
	    * @param background	
	    * 			背景图
	    * @param poster
	    * 			教师形象图
	    * @param qr
	    * 			二维码图片
	    * @param avatar
	    * 			头像图片
	    * @param font
	    * 			字体
	    * @param nickname
	    * 			昵称
	    * @param courseName
	    * 			课程名称
	    * @param courseTip
	    * 			课程大纲
	    * @return 
	    * @throws IOException
	     */
	    public static BufferedImage createSharePoster(BufferedImage background, BufferedImage poster,
	    		BufferedImage qr,BufferedImage avatar,Font font, String nickname,String courseName,String courseTip ) throws  IOException{
	    	// 开启抗锯齿
	    	RenderingHints renderingHints = new RenderingHints(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
	    	// 使用高质量压缩
	    	renderingHints.put(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_SPEED);
	    	renderingHints.put(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_GASP);
	    	int height = background.getHeight() * 750 / background.getWidth();
	    	// 图片大小
	    	BufferedImage img = new BufferedImage(750, height, BufferedImage.TYPE_INT_RGB);
	    	// 开启画图
	    	Graphics2D g = (Graphics2D) img.getGraphics();
	    	
	    	try {
	    		g.setRenderingHints(renderingHints);
	    		// 教师海报图 - 需要将原图进行剪切 剪切后的长度是 750*830
	    		BufferedImage teacherImage = ImgUtil.cutPic(poster, 158, 0, 750, 830);
	    		g.drawImage(teacherImage.getScaledInstance(750,teacherImage.getHeight(), Image.SCALE_FAST), 0, 0, null);
	    		// 画底图
	    		g.drawImage(background.getScaledInstance(750, height, Image.SCALE_FAST), 0, 0, null);
	    		// 画头像
	    		if (null != avatar) {
	    			g.drawImage(ImageUtils.roundImage(avatar, avatar.getWidth(), avatar.getHeight(), 360).getScaledInstance(45*2, 45*2, Image.SCALE_FAST), 25*2, 603*2, null);
	    		}
	    		// 画二维码
	    		if (null != qr) {
	    			g.drawImage(qr.getScaledInstance(65*2, 65*2, Image.SCALE_FAST), 286*2, 593*2, null);
	    		}
	    		
	    		// 设置字体大小
	    		font = font.deriveFont(34f);
	    		// 设置字体颜色
	    		Color color = new Color(55,69,97);
	    		g.setColor(color);
	    		g.setFont(font);
	    		//昵称 
	    		nickname = nickname == null ? "" : nickname;
	    		nickname = EmojiUtils.emojiRecovery(nickname);
	    		
	    		if(nickname.length() > 5) {
	    			nickname = nickname.substring(0, 5) + "...";
	    		}
	    		
	    		int stringWidth = getWidth(g.getFontRenderContext(), g, nickname);
	    		g.drawString(nickname, 84 * 2 , 623 * 2);
	    		//画'向您推荐好课' 
	    		String recommendText = "向您推荐好课";
	    		font = font.deriveFont(24f);
	    		// 设置字体颜色
	    		color = new Color(55,69,97);
	    		g.setColor(color);
	    		g.setFont(font);
	    		g.drawString(recommendText, 84 * 2 +  stringWidth , 623 * 2);
	    		
	    		// 写课程名称
	    		font = font.deriveFont(60.0f);
	    		color = new Color(69,75,106);
	    		g.setColor(color);
	    		g.setFont(font);
	    		int courseWidth = getWidth(g.getFontRenderContext(), g, courseName);
	    		if(courseWidth >= 334*2) {
	    			String c1 = courseName.substring(0, 10);
	    			String c2 = courseName.substring(10, courseName.length());
	    			int courseHeight = getHeight(g.getFontRenderContext(), g, c1);
	    			g.drawString(c1, 21 * 2 , 430 * 2);
	    			g.drawString(c2, 21 * 2 , 420 * 2 + courseHeight);
	    			
	    		}else {
	    			g.drawString(courseName, 21 * 2 , 448 * 2);
	    			
	    		}

	    		//写课程大纲
	    		List<String> tipList = Arrays.asList(courseTip.split("\n"));
	    		String tip1 = tipList.get(0);
	    		if(tip1.length() >= 20) {
	    			tip1 = tip1.substring(0, 19) + "...";
	    		}
	    		String tip2 = tipList.get(1);
	    		if(tip2.length() >= 20) {
	    			tip2 = tip2.substring(0, 19) + "...";
	    		}
	    		String tip3 = tipList.get(2);
	    		if(tip3.length() >= 20) {
	    			tip3 = tip3.substring(0, 19) + "...";
	    		}
	    		font = font.deriveFont(30.0f);
	    		color = new Color(176,153,104);
	    		g.setColor(color);
	    		g.setFont(font);
	    		g.drawString(tip1, 47 * 2 , 494 * 2);
	    		g.drawString(tip2, 47 * 2 , 527 * 2);
	    		g.drawString(tip3, 47 * 2 , 559 * 2);
	    		
	    		img = Thumbnails.of(img).scale(1f).outputQuality(1f).asBufferedImage();
	    	} catch (IOException e) {
	    		throw  new IOException(e.getMessage());
	    	} finally {
	    		g.dispose();
	    	}
	    	return img;
	    }
	    
	    public static BufferedImage roundImage(BufferedImage image, int width, int height, int cornerRadius) {
	        BufferedImage outputImage = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
	        Graphics2D g2 = outputImage.createGraphics();
	        g2.setComposite(AlphaComposite.Src);
	        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
	        g2.setColor(Color.WHITE);
	        g2.fill(new RoundRectangle2D.Float(0, 0, width, height, cornerRadius, cornerRadius));
	        g2.setComposite(AlphaComposite.SrcAtop);
	        g2.drawImage(image, 0, 0, null);
	        g2.dispose();
	        return outputImage;
	    }

	    public static BufferedImage roundImage(BufferedImage image, int cornerRadius) {
	        return roundImage(image, image.getWidth(), image.getHeight(), cornerRadius);
	    }

	    
	    public static int getWidth(FontRenderContext context, Graphics2D g, String text) {
	        return (int) g.getFont().getStringBounds(text, context).getWidth();
	    }

	    public static int getHeight(FontRenderContext context, Graphics2D g, String text) {
	        return (int) g.getFont().getStringBounds(text, context).getHeight();
	    }

}