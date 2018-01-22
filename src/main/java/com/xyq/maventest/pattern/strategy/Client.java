package com.xyq.maventest.pattern.strategy;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Client {

	public static void main(String[] args) {
		
		//定义一个整形list并初始化
		List<Integer> list = new ArrayList<Integer>();
		for(int i=1;i<=10;i++){
			list.add(new Random().nextInt(100));
		}
		Context context;
		
		System.out.println("执行策略1");
		context = new Context(new ConcreteStrategy1());
		context.excute(list);
		
		System.out.println("执行策略2");
		context = new Context(new ConcreteStrategy2());
		context.excute(list);
		
		System.out.println("执行策略3");
		context = new Context(new ConcreteStrategy3());
		context.excute(list);
		
		
	}
}
