package com.xyq.maventest.pattern.builder;

public class ConcreteBuilder extends Builder {

	private Product product = new Product();
	
	@Override
	public void setPart(String name, String type) {
		product.setName(name);
		product.setType(type);
	}

	@Override
	public Product getProuct() {
		return product;
	}

}
