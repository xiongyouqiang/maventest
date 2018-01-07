package com.xyq.maventest.pattern.proxy;

public class ProxySubject implements Subject {

	
	private Subject sub;
	
	public ProxySubject()
	{
		System.out.println("这是代理类");
		sub = new ConcreteSubject();
	}
	@Override
	public void action() {
		startProxy();
		sub.action();
		stopProxy();
	}
	
	private void startProxy(){
		System.out.println("代理开始");
	}
	private void stopProxy(){
		System.out.println("代理结束");
	}

}
