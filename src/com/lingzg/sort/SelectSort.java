package com.lingzg.sort;

import java.util.Arrays;

import com.lingzg.util.MyUtil;

/**
 * —°‘Ò≈≈–Ú
 * @author lingzg
 *
 */
public class SelectSort {
	
	public static void selectionSort(int[] number){
		for(int i=0;i<number.length-1;i++){
			int m=i;
			for(int j=i+1;j<number.length;j++){
				if(number[j]<number[m]){
					m=j;
				}
			}
			if(i!=m){
				MyUtil.swap(number,i,m);
			}
			System.out.println(Arrays.toString(number));
		}
	}
	
	
	
	public static void main(String[] args) {
		int[] n = new int[10];
		for(int i=0;i<n.length;i++){
			n[i]=(int) (Math.random()*100);
		}
		System.out.println(Arrays.toString(n));
		selectionSort(n);
		System.out.println(Arrays.toString(n));
	}
}
