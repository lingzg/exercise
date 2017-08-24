package com.lingzg.sort;

import java.util.Arrays;

/**
 * 对数组中的元素排序，要求奇数在左边，偶数在右边
 * 从前往后扫描，遇到偶数停止；从后往前扫描，遇到奇数停止；前面的偶数和后面的奇数交换位置；然后继续扫描，直到相遇为止。
 * @author lingzg
 *
 */
public class SelectNum {

	public static void main(String[] args) {
		int n=100;
		int[] arr = genArr(n);
		System.out.println(Arrays.toString(arr));
		long start = System.nanoTime();
		select(arr);
		long end = System.nanoTime();
		System.out.println(isRight(arr));
		System.out.println(Arrays.toString(arr));
		System.out.println(n+":"+(end-start));//10:2123,100:6016,1000:41054,10000:420799,100000:2651849
	}
	
	public static void select(int[] arr){
		if(arr==null||arr.length==0){
			throw new RuntimeException("invalid argument");
		}
		for(int i=0,j=arr.length-1;i<arr.length && j>=0 && i<=j;){
			if((arr[i]&1)==0 && (arr[j]&1)==1){
				int t=arr[i];
				arr[i]=arr[j];
				arr[j]=t;
			}
			if((arr[i]&1)==1){
				i++;
			}
			if((arr[j]&1)==0){
				j--;
			}
			
		}
	}
	
	public static int[] genArr(int n){
		if(n<=0){
			throw new RuntimeException("invalid argument");
		}
		int[] arr = new int[n];
		for(int i=0;i<n;i++){
			arr[i] = (int) (Math.random()*100);
		}
		return arr;
	}
	
	public static boolean isRight(int[] arr){
		if(arr==null||arr.length==0){
			throw new RuntimeException("invalid argument");
		}
		int index=-1;
		for(int i=0;i<arr.length;i++){
			if(index==-1 & (arr[i]&1)==0){//找到第一个偶数
				index = i;
			}
			if(index != -1 && i > index && (arr[i]&1)==1){//后面有奇数返回false
				return false;
			}
		}
		return true;
	}
}
