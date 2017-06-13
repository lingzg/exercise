package com.lingzg.sort;

import java.util.Arrays;

import com.lingzg.util.MyUtil;

/**
 * ц╟ещеепР
 * @author lingzg
 *
 */
public class BubbleSort {

	public static void bubbleSort(int[] number){
		for(int i=0;i<number.length-1;i++){
			for(int j=0;j<number.length-i-1;j++){
				if(number[j]>number[j+1]){
					MyUtil.swap(number, j, j+1);
				}
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
		bubbleSort(n);
		System.out.println(Arrays.toString(n));
	}
}
