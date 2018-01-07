package com.xyq.maventest.pattern.factory;

public class Client {

	public static void main(String[] args) {

		IFactory factory = new ConcreteFactory();
		IProduct product = factory.createProduct("product1");
		IProduct2 product2 = factory.createProduct2("product2", "type2");
		product.display();
		product2.display();
		
	}
}
