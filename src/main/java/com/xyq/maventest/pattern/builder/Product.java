package com.xyq.maventest.pattern.builder;

/***
 * 
 * @author youqiang.xiong
 * <p> TODO 产品类</p>
 * 2018年1月6日上午10:28:26
 */
public  class Product {

	private String name;
	
	private String type;

	public void display(){
		System.out.println("name :" +name);
		System.out.println("type :" +type);
	}
	
	
	public String getName() {
		return name;
	}
		
		
	public Product() {

	}

	public void setName(String name) {
		this.name = name;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Product(String name, String type) {
		super();
		this.name = name;
		this.type = type;
	}
	
	
	
}
