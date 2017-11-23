package com.xyq.maventest.pattern.factory;

import com.xyq.maventest.pattern.factory.product.AbstractProudctA;
import com.xyq.maventest.pattern.factory.product.AbstractProudctB;
import com.xyq.maventest.pattern.factory.product.ConcreteProductA2;
import com.xyq.maventest.pattern.factory.product.ConcreteProductB2;

public class ConcreteFactory2 extends AbstractFactory {

	@Override
	public AbstractProudctA createProudctA() {
		return new ConcreteProductA2();
	}

	@Override
	public AbstractProudctB createProudctB() {
		
		return new ConcreteProductB2();
	}

}
