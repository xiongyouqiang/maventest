package com.xyq.maventest.visualvm;

public class MyThread extends Thread{
    
    public static void main(String[] args) {
        
        MyThread mt1 = new MyThread("Thread a");
        MyThread mt2 = new MyThread("Thread b");
        MyThread mt3 = new MyThread("Thread c");
        
        mt1.setName("My-Thread-1 ");
        mt2.setName("My-Thread-2 ");
        mt2.setName("My-Thread-3 ");
        
        mt1.start();
        mt2.start();
        mt3.start();
    }
    
    public MyThread(String name) {
    }

    public void run() {
        while (true) {
//            System.out.println("当前线程名称:"+Thread.currentThread().getName()+"  "+(++i));
        }
    }
}