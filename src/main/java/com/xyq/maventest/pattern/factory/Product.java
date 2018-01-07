package com.xyq.maventest.pattern.factory;

public class Product implements IProduct {

	private String name;
	
	
	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}

	

	public Product(String name) {
		super();
		this.name = name;
	}


	@Override
	public void display() {
		
		System.out.println("This is product :" +name);
	}

}
