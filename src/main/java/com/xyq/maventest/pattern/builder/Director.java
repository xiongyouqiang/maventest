package com.xyq.maventest.pattern.builder;

public class Director {

	Builder builder = new ConcreteBuilder();
	
	public Product  getAProduct(){
		builder.setPart("宝马", "X7");
		return builder.getProuct();
	}
	
	public Product getBProduct(){
		
		builder.setPart("奥迪汽车", "q7");
		return builder.getProuct();
	}
}
