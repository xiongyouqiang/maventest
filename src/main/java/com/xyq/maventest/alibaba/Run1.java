package com.xyq.maventest.alibaba;

public class Run1 implements Runnable 
{
    int i= -2;
    @Override
    public void run()
    {
        while(i<=98)
        {
            synchronized (Main.m) 
            {
                System.out.println("Thread1: "+ (i+=2));
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