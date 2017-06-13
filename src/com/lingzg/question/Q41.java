package com.lingzg.question;

public class Q41 {

	/**
	 * 题目：和为s的两个数字VS和为s的连续正数序列
	 * 题目说明：输入一个递增排序的数组和一个数字s，在数组中查找两个数，使得它们的和正好是s。如果有多对数字的和等于s,输出任意一对即可。
	 * 解题思路：从数组的两端遍历数组，下标为start和end，如果array[start]+array[end]==s则输出两个数字，
	 * 如果array[start]+array[end] > s则将较大的数向前移动 如果array[start]+array[end] <
	 * s则将较小的数向后移动
	 */
	public static void main(String[] args) {
		Q41 test = new Q41();
		int[] array = { 1, 2, 4, 7, 11, 15 };
		test.findNumsSumEqualS(array, 15);
	}

	public void findNumsSumEqualS(int[] array, int s) {
		// 判断数组的合法性
		if (array == null) {
			return;
		}
		int start = 0;// 较小元素的下标
		int end = array.length - 1;// 较大元素的下标
		int number1 = 0;
		int number2 = 0;
		while (start < end) {
			int sum = array[start] + array[end];
			if (sum == s) {
				number1 = array[start];
				number2 = array[end];
				break;
			} else if (sum > s) {
				end--;// 较小数字后移
			} else {
				start++;
			}
		}
		System.out.println(number1 + "," + number2);
	}
}
