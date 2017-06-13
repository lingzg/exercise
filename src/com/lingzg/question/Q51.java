package com.lingzg.question;

public class Q51 {

	/**
	 * 题目：数组中重复的数字
	 * 题目说明：在一个长度为n的数组里的所有数字都在0到n-1的范围内。数组中某些数字是重复的，但不知道有几个数字重复了，也不知道每个数字重复了几次。
	 * 请找出数组中任意一个重复的数字。例如输入长度为7的数组{2,3,1,0,2,5,3},那么对应的输出是重复的数字2或3.
	 * 解题思路：（1）数组中的元素均属于0到n-1的范围内，假设数组中没有重复的数字，则排序之后对应下标为i的元素的值为i。
	 * 由于存在存在重复，在有些位置存在若干个数字，有些位置则空着。（2）扫描数组中下标为i的元素，如果元素m也为i，则继续扫描下一个数字。
	 * 如果i和m不相等，则比较大小 如果m和第m个数字相等，即m=array[m],则找到一个重复的数字；如果m和第m个数字不相等（m !=
	 * array[m]），则把第i个数字m,放到下标为m的位置上。 (3)重复上述操作，直到找出重复的元素。
	 */
	public static void main(String[] args) {
		// TODOAuto-generated method stub
		Q51 test = new Q51();
		int[] array = { 2, 3, 1, 0, 2, 5, 3 };
		test.repetitionNum(array);
	}

	public boolean repetitionNum(int[] array) {
		if (array == null || array.length == 0)// 判断数组的合法性
			return false;
		for (int i = 0; i < array.length; i++) {// 判断数组中元素的合法性
			if (array[i] < 0 || array[i] > array.length)
				return false;
		}
		for (int i = 0; i < array.length; i++) {// 如果array[i]==i;则移动到下一个元素i++
			while (array[i] != i) {
				if (array[i] == array[array[i]]) {// 由于array[i]==m,则判断array[m]==m,相等表示存在重复
					System.out.println(array[i]);// 输出第一个重复的数字
					return true;
				}
				int temp = array[i];// array[i]相当于m，array[i]!=m，则交换，让array[m]==m
				array[i] = array[temp];
				array[temp] = temp;
			}
		}
		return false;
	}
}
