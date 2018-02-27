package com.xyq.maventest.pattern.proxy;

/****
 * 代理模式客服调用类
* @ClassName: Client 
* @Description: TODO(这里用一句话描述这个类的作用) 
* @author youqiang.xiong
* @date 2018年2月27日 上午11:23:16 
*
 */
public class Client {

	public static void main(String[] args) {
		
		Subject  proxyObj = new ProxySubject();
		proxyObj.action();
	}
}
