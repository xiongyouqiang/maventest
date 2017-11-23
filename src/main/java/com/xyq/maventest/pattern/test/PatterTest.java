package com.xyq.maventest.pattern.test;

import org.junit.Test;

import com.xyq.maventest.pattern.factory.AbstractFactory;
import com.xyq.maventest.pattern.factory.ConcreteFactory1;
import com.xyq.maventest.pattern.factory.ConcreteFactory2;
import com.xyq.maventest.pattern.factory.product.AbstractProudctA;
import com.xyq.maventest.pattern.factory.product.AbstractProudctB;

public class PatterTest {

	@Test
	public void testAbstractFactoryPattern(){
		
		AbstractFactory factory1 = new ConcreteFactory1();
		AbstractFactory factory2 = new ConcreteFactory2();
		AbstractProudctA proudctA1 = factory1.createProudctA();
		AbstractProudctA proudctA2 = factory2.createProudctA();
		AbstractProudctB proudctB1 = factory1.createProudctB();
		AbstractProudctB proudctB2 = factory2.createProudctB();
		proudctA1.display();
		proudctA2.display();
		proudctB1.display();
		proudctB2.display();
	}
}
