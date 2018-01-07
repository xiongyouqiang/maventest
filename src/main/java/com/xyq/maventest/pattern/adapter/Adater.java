package com.xyq.maventest.pattern.adapter;

public class Adater implements Target {

	private Adaptee  adaptee;
	
	public Adater(){
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
