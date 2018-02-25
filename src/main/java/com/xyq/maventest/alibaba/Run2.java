package com.xyq.maventest.alibaba;


//打印偶数
public class Run2 implements Runnable 
{
    int i= -1;
    @Override
    public void run()
    {
        while(i<=98)
        {
            synchronized (Main.m) 
            {
                System.out.println("Thread2: "+ (i+=2));
                Main.m.notify();
                try 
                {
                    Main.m.wait();
                } 
                catch (InterruptedException e) 
                {
                    e.printStackTrace();
                }
            }
        }
    }
}