package com.xyq.maventest.pattern.factory;

public class Product2 implements IProduct2 {

	private String name;
	
	private String type;
	
	
	
	public String getName() {
		return name;
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

	

	public Product2(String name, String type) {
		super();
		this.name = name;
		this.type = type;
	}



	@Override
	public void display() {

		System.out.println("this is product2:\t name="+name+"  type="+type);
	}

}
