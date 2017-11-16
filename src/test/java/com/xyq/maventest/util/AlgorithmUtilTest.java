package com.xyq.maventest.util;

import java.util.Random;

import org.junit.Test;

public class AlgorithmUtilTest {

	
	@Test
	public void testGetSmallIntegerFromArray(){
		
		int[][] array = new int[4][4];
		//初始化数组
		new Random().nextInt(100);
		for(int i=0;i<=array.length-1;i++){
			for(int j=0;j<=array[0].length-1;j++){
				array[i][j] = new Random().nextInt(20);
			}
		}
		//打印数组
		printArray(array);
		
		//查找从左上角到右下角路径数字和最小的路径
		StringBuffer sb = new StringBuffer("");
		int i = array.length - 1;
		int j = array[0].length - 1; 
		int total = AlgorithmUtil.getSmallIntegerFromArray(array, i, j,sb);
		System.out.println(sb+"最小数组和："+total);
	}
	
	public void printArray(int[][]  array){
		
		for(int i=0;i<=array.length-1;i++){
			for(int j=0;j<=array[0].length-1;j++){
				System.out.print(array[i][j]+"    ");
			}
			System.out.println();
		}
	}
}
