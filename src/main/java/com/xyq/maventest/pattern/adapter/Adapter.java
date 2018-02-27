package com.xyq.maventest.pattern.adapter;

public class Adapter implements Target {

	private Adaptee  adaptee;
	
	public Adapter(){
		adaptee = new Adaptee();
	}
	
	@Override
	public void adapteeMethod() {
		
		adaptee.adapteeMethod();
	}

	@Override
	public void adapterMethod() {
		System.out.println("Adapter Method");
	}

}
