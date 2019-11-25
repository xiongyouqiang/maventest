package com.xyq.maventest.juc;

import java.util.concurrent.Semaphore;

/*****
 * 
* Project Name:maventest
* <p>Semaphore测试类<br> 
* 例子：若一个工厂有 5 台机器，但是有 8 个工人，一台机器同时只能被一个工人使用，只有使用完
了，其他工人才能继续使用。<br>
* @ClassName: SemaphoreTest
* @date 2019年10月22日  上午10:39:03
*
* @author youqiang.xiong
* @version 1.0
* @since  
* @see
 */
public class SemaphoreTest {

	public static void main(String[] args) {
		
		final int N = 8;
		Semaphore semaphore = new Semaphore(5);
		for(int i=0;i<N;i++) {
			new worrker(i, semaphore).start();
		}
	}
	
	static class worrker extends Thread{
		
		//工人人数
		private int num;
		//机器数
		private Semaphore semaphore;
		
		public worrker(int num, Semaphore semaphore) {
			super();
			this.num = num;
			this.semaphore = semaphore;
		}
		
		@Override
		public void run() {
			
			try {
				semaphore.acquire();
				System.out.println("工人："+this.num+"占用一个机器在生产。。");
				Thread.sleep(1000);
				System.out.println("工人："+this.num+"释放出机器");
				semaphore.release();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
	}
}
