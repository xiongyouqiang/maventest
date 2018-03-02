package com.xyq.maventest.alibaba;

/****
 * 两个线程分别打印0-100之间的奇偶数
 * @author youqiang.xiong
 * <p> TODO 简单描述此类的用途</p>
 * 2018年2月25日下午6:18:34
 */
public class ThreadPrintData {
	private static Object lock = new Object();

	private static int i = 0;
	private static int wait = 1;
	private static final int TOTAL = 100;

	
	public static void main(String[] args) {
		
		Thread thread1 = new Thread() {
			public void run() {
				while (i <= TOTAL) {
					synchronized (lock) {
						if (i % 2 == 1) {
							System.out.println("thread1  " + i++);
						} else {
							lock.notifyAll();
							try {
								lock.wait(wait);
							} catch (InterruptedException e) {
								e.printStackTrace();
							}
						}
					}

				}
			}
		};

		Thread thread2 = new Thread() {
			public void run() {
				while (i <= TOTAL) {
					synchronized (lock) {
						if (i % 2 == 0) {
							System.out.println("thread2  " + i++);
						} else {
							lock.notifyAll();
							try {
								lock.wait(wait);
							} catch (InterruptedException e) {
								e.printStackTrace();
							}
						}
					}

				}
			}
		};
		thread1.start();
		thread2.start();
	}
}

