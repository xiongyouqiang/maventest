package com.xyq.maventest.util;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/***
 * 
* Project Name:maventest
* <p>emoji标签转换工具类<br> 
*
* @ClassName: EmojiUtils
* @date 2019年1月22日  下午4:29:26
*
* @author youqiang.xiong
* @version 1.0
* @since  
* @see
 */
public class EmojiUtils {

	private static Logger logger = LoggerFactory.getLogger(EmojiUtils.class);

	/**
	 * 将emoji标签转换成utf8字符集保存进数据库
	 * @param str
	 * @return
	 */
	public static String emojiConvert(String str) {
		String patternString = "([\\x{10000}-\\x{10ffff}\\ud800-\\udfff])";
		Pattern pattern = Pattern.compile(patternString);
		Matcher matcher = pattern.matcher(str);
		StringBuffer sb = new StringBuffer();
		while(matcher.find()) {
		//	matcher.appendReplacement(sb,"？");
			try {
				matcher.appendReplacement(sb,"[[" + URLEncoder.encode(matcher.group(1),"UTF-8") + "]]");
			} catch(UnsupportedEncodingException e) {
				logger.error("emojiConvert error"+ e.getMessage());
				return str;
			}
		}
		matcher.appendTail(sb);
		logger.debug("emojiConvert " + str + " to " + sb.toString() + ", len：" + sb.length());
		return sb.toString();
	}

	/**
	 * 还原utf8数据库中保存的含转换后emoji表情的字符串
	 * @param str
	 * @return
	 */
	public static String emojiRecovery(String str) {
		if(StringUtils.isEmpty(str)){
			return "";
		}
		try{
			String patternString = "\\[\\[(.*?)\\]\\]";
			Pattern pattern = Pattern.compile(patternString);
			Matcher matcher = pattern.matcher(str);
			StringBuffer sb = new StringBuffer();
			while(matcher.find()) {
				try {
					matcher.appendReplacement(sb, URLDecoder.decode(matcher.group(1), "UTF-8"));
				} catch(UnsupportedEncodingException e) {
					logger.error("emojiRecovery error"+ e.getMessage());
					return "";
				}
			}
			matcher.appendTail(sb);
			logger.debug("emojiRecovery " + str + " to " + sb.toString());
			return sb.toString();
		}catch (Exception e){
			logger.error("emojiRecovery error",e);
		}
		return str;
	}

}
