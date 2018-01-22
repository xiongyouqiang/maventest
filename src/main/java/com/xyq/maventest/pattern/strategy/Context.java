package com.xyq.maventest.pattern.strategy;

import java.util.List;

/****
 * 
 * @author youqiang.xiong
 * <p> TODO 简单描述此类的用途</p>
 * 2018年1月6日下午4:39:35
 */
public class Context {

	private Strategy strategy;

	
	
	
	public Context(Strategy strategy) {
		super();
		this.strategy = strategy;
	}

	public void excute(List<Integer> list){
		
		this.strategy.abstractSort(list);
	}
	
	public Strategy getStrategy() {
		return strategy;
	}

	public void setStrategy(Strategy strategy) {
		this.strategy = strategy;
	}
	
	
}
