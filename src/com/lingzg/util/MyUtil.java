package com.lingzg.util;

public class MyUtil {

	/**
	 * 交换数组中两个元素的位置
	 * @param number
	 * @param i
	 * @param j
	 */
	public static void swap(int[] number,int i,int j){
		int t=number[i];
		number[i]=number[j];
		number[j]=t;
	}
	
	
}
