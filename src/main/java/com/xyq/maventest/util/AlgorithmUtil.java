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

		printData(n);
		;
	}

	public static void printData(int n) {

		int[][] array = new int[5][5];
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= i; j++) {
				if (j == 1) {
					array[i][j] = i;
				} else {
					// array[i][j] =
				}
			}
		}

	}

	public static String converToStr(int n) {

		StringBuffer sb = new StringBuffer();

		if (n < FOR_NUMBER) {
			sb.append("0").append(n);
		} else {
			sb.append(n);
		}

		return sb.toString();
	}

	// 寻找一条从左上角（arr[0][0]）到右下角(arr[m-1][n-1]) 的路线，使得途径过的数组中的整数和最小
	// min{f(m-2,n-1),f(m-1,n-2)} + arr[m-1][n-1] = f(m-1,n-1)
	// f(i,j) = min{f(i-1,j),f(i,j-1)} + arr[i][j]

	// 可以递归算法，从最右下角元素开始逆序运算，直至计算arr[0][0]为止

	public static int getSmallIntegerFromArray(int[][] array,int i,int j,StringBuffer sb) {

		int total = 0;
		if (array == null) {
			return 0;
		}

//		int i = array.length - 1;
//		int j = array[0].length - 1;
		int m=0,n=0;
		if(i==0 && j==0){
			m = 0;
			n = 0;
		}else if(i==0){
			m = 0;
			n = j- 1;
		}else if(j==0){
			m = i-1;
			n = 0;
		}
		else if (array[i-1][j] > array[i][j-1]) {
			m = i;
			n= j-1;
		} else if (array[i-1][j] < array[i][j-1]) {
			m = i-1;
			n= j;
		}else{
			m = i-1;
			n= j;
		}
		System.out.println("位置:row:"+(m+1)+"  col:"+(n+1)+"    "+array[m][n]);
		if(m==0&&n==0){
			total = array[0][0];
		}else{
			sb.append(array[i][j]+"+");
			total = getSmallIntegerFromArray(array,m,n,sb) + array[i][j];
		}

		return total;
	}
	
}