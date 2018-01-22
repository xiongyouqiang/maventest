package com.xyq.maventest.pattern.strategy;

import java.util.List;

public class ConcreteStrategy2 implements Strategy {

	@Override
	public void abstractSort(List<Integer> list) {

		System.out.println("冒泡排序");
	}

}
