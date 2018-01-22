package com.xyq.maventest.pattern.handler;

import com.xyq.maventest.pattern.handler.bean.Level;
import com.xyq.maventest.pattern.handler.bean.Request;

public class Client {

	public static void main(String[] args) {
		
		Handler handler1 = new ConcreteHandler1();
		Handler handler2 = new ConcreteHandler2();
		Handler handler3 = new ConcreteHandler3();

		handler1.setNextHandler(handler2);
		handler2.setNextHandler(handler3);
		
		handler1.handleRequest(new Request(new Level(9)));
		
	}
}
