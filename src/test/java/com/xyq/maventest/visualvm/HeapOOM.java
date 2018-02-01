package com.xyq.maventest.visualvm;

import java.util.ArrayList;
import java.util.List;

public class HeapOOM {

	static class OOMObject{
		
		
	}
	
	public static void main(String[] args) throws InterruptedException {
		List<OOMObject> list = new ArrayList<HeapOOM.OOMObject>();
		while(true){
			Thread.sleep(1);
			list.add(new OOMObject());
		}
	}
}
