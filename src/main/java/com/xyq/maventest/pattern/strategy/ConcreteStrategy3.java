package com.xyq.maventest.pattern.strategy;

import java.util.List;

public class ConcreteStrategy3 implements Strategy {

	@Override
	public void abstractSort(List<Integer> list) {

		System.out.println("选择排序");
	}

}
