package com.xyq.maventest.thread;

import com.xyq.maventest.bean.Common;

public class MyThread extends Thread {
	private int id = 0;
	private Common common;

	public MyThread(String name, int no, Common object) {
		super(name);
		common = object;
		id = no;
	}

	public void run() {
		System.out.println("Running Thread" + this.getName());
		try {
			if (id == 0) {
				common.synchronizedMethod1();
			} else {
				common.synchronizedMethod2();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		Common c = new Common();
		MyThread t1 = new MyThread("MyThread-1", 0, c);
//		Common c1 = new Common();
		MyThread t2 = new MyThread("MyThread-2", 1, c);
		MyThread t3 = new MyThread("MyThread-3", 0, c);
		t1.start();
		t2.start();
		t3.start();
	}
}
