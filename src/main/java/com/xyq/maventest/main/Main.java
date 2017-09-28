package com.xyq.maventest.main;

import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;


public class Main {
	
	private static Map<String, String> table = new Hashtable<String, String>();
	
	private static Map<String, String> map = new ConcurrentHashMap<String, String>();

	static {
		
		Map<String, String> dataMap = new HashMap<String, String>();
		dataMap.put("1", "xyq");
		dataMap.put("2", "lh");
		dataMap.put("3", "fj");
		dataMap.put("4", "ldh");
		
		table.putAll(dataMap);
		
		map.putAll(dataMap);
		
	}
	
	public static void main(String[] args) {
		
		TestCollectionThread myThread1 = new TestCollectionThread(1);
		TestCollectionThread myThread2 = new TestCollectionThread(2);
		Thread t1 = new Thread(myThread1);
		Thread t2 = new Thread(myThread2);
		t1.start();
		t2.start();
	}
 
	
	public static void bianliMap(){
		
		for(Map.Entry<String, String> entry:map.entrySet()){
			
			System.out.println("key:"+entry.getKey() +"\t value:"+entry.getValue());
		}
	
	}
	public static void bianliTable(){
		
		for(Map.Entry<String, String> entry:table.entrySet()){
			System.out.println("key:"+entry.getKey() +"\t value:"+entry.getValue());

		}
	}
	
	static class TestCollectionThread implements Runnable{

		private int flag;
		
		public TestCollectionThread(int flag){
			this.flag = flag;
		}
		
		public void run() {
			System.out.println("Running Thread" + Thread.currentThread().getName());
			if(flag == 1){
				bianliMap();
			}else if(flag ==2){
				bianliTable();
			}
		}
		
	}
}
