package com.xyq.maventest.alibaba;

public class Main 
{
   final static Main m = new Main();
   
   public static void main(String[] args) 
   {
       new Thread(new Run1()).start();
       new Thread(new Run2()).start();
   }
}