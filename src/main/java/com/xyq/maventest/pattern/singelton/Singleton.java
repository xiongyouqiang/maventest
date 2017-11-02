package com.xyq.maventest.pattern.singelton;

public class Singleton {

	private static Singleton instance = null;
	
	public static synchronized Singleton getInstance(){
		
		if(instance == null){
			instance = new Singleton();
		}
		
		return instance;
	}
}
	 