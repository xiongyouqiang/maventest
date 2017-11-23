package com.xyq.maventest.pattern.factory;

import com.xyq.maventest.pattern.factory.product.AbstractProudctA;
import com.xyq.maventest.pattern.factory.product.AbstractProudctB;
import com.xyq.maventest.pattern.factory.product.ConcreteProductA1;
import com.xyq.maventest.pattern.factory.product.ConcreteProductB1;

public class ConcreteFactory1 extends AbstractFactory {

	@Override
	public AbstractProudctA createProudctA() {
		return new ConcreteProductA1();
	}

	@Override
	public AbstractProudctB createProudctB() {
		return new ConcreteProductB1();
	}

}
