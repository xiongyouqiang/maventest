package com.xyq.maventest.pattern.factory;

public class ConcreteFactory implements IFactory {

	@Override
	public IProduct createProduct(String name) {
		IProduct product = new Product(name);
		return product;
	}

	@Override
	public IProduct2 createProduct2(String name, String type) {
		IProduct2 product2 = new Product2(name, type);
		return product2;
	}

}
