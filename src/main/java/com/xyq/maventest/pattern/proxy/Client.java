package com.xyq.maventest.pattern.proxy;

public class Client {

	public static void main(String[] args) {
		
		Subject  proxyObj = new ProxySubject();
		proxyObj.action();
	}
}
