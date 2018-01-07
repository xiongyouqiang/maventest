package com.xyq.maventest.pattern.builder;

public class Client {

	public static void main(String[] args) {

		Director director = new Director();
		Product product1 = director.getAProduct();
		Product product2 = director.getBProduct();
		
		product1.display();
		product2.display();
		
	}
}
