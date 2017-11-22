package com.xyq.maventest.pattern.factory;

import com.xyq.maventest.pattern.factory.product.AbstractProudctA;
import com.xyq.maventest.pattern.factory.product.AbstractProudctB;

public abstract class AbstractFactory {

	public abstract AbstractProudctA createProudctA();

	public abstract AbstractProudctB createProudctB();
}
