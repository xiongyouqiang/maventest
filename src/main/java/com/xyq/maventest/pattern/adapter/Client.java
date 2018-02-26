package com.xyq.maventest.pattern.adapter;

public class Client {

	public static void main(String[] args) {
		
		Target  target = new Adapter();
		target.adapteeMethod(); // 原有方法
		target.adapterMethod(); //适配器方法
	}
}
