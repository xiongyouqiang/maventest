package com.xyq.maventest.util;

/***
 * 
 * @author youqiang.xiong
 *
 */
public class AlgorithmUtil {
	
	private static final Integer FOR_NUMBER = 10;

	public static void main(String[] args) {
		
		int n = 4;
		
		printData(n);;
	}
	
	
	public static void printData(int n){
		
		int[][] array = new int[5][5];
		for(int i=1;i<=n;i++){
			for(int j=1;j<=i;j++){
				if(j == 1){
					array[i][j] = i;
				}else {
//					array[i][j] = 
				}
			}
		}
		
	}
	
	public static String converToStr(int n){
		
		StringBuffer sb = new StringBuffer();
		
		if(n < FOR_NUMBER){
			sb.append("0").append(n);
		}else{
			sb.append(n);
		}
		
		return sb.toString();
	}
	
	
	
}