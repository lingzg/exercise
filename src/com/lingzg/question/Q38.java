package com.lingzg.question;

public class Q38 {
	/**
	 * 题目：数字在排序数组中出现的次数
	 * 题目说明：统计一个数字在排序数组中出现的次数。例如输入排序数组｛１，２，３，３，３，３，４，５｝和数字３，由于３在这个数组中出现了４次，
	 * 因此输出４。 解题思路：由于是排序好的数组，因此利用二分查找算法来实现，首先找出第一个出现３的位置，其次找出最后一个出现３的位置，
	 * 这样就容易求该数字出现的次数了。
	 */
	public static void main(String[] args) {
		Q38 test = new Q38();
		int[] array = { 1, 2, 3, 3, 3, 3, 4, 5 };
		System.out.println(test.getNumberOfK(array, 3));

	}

	public int getNumberOfK(int[] array, int k) {
		int number = 0;
		if (array != null) {
			int firstK = getTheFirstK(array, k, 0, array.length - 1);// k首次出现的位置
			int lastK = getTheLastK(array, k, 0, array.length - 1);// k最后出现的位置
			if (firstK > -1 && lastK > -1) {
				number = lastK - firstK + 1;// 记得两数的差要加1
			}
		}
		return number;
	}

	// 利用递归找出第一次出现k的位置
	public int getTheFirstK(int[] array, int k, int start, int end) {
		if (array == null || array.length == 0) {
			return -1;
		}
		int midIndex = (start + end) / 2;// 中间位置的下标
		if (array[midIndex] == k) {
			if ((midIndex > 0 && array[midIndex - 1] != k) || midIndex == 0) {// 中间位置大于0，并且中间位置的前一个数不等于k。或者中间位置为0
				return midIndex;
			} else {
				end = midIndex - 1;
			}
		} else if (array[midIndex] > k) {// 如果中间位置的数值大于要查找的数k,则遍历数组的前半部分，修改end值
			end = midIndex - 1;
		} else {// 如果中间位置的数值小于于要查找的数k，则遍历数组的后半部分，修改的是start值
			start = midIndex + 1;
		}
		return getTheFirstK(array, k, start, end);// 递归实现第一次出现k值的地方
	}

	// 利用递归找出最后一次出现k的位置
	public int getTheLastK(int[] array, int k, int start, int end) {
		if (array == null || array.length == 0) {
			return -1;
		}
		int midIndex = (start + end) / 2;
		if (array[midIndex] == k) {
			// 如果中间位置的数的下标小于数组长度，并且中间位置之后的数字不是k。或者中间位置的数恰好是最后一个元素
			if ((midIndex < array.length - 1 && array[midIndex + 1] != k) || midIndex == array.length - 1) {
				return midIndex;
			} else {
				start = midIndex + 1;
			}
		} else if (array[midIndex] < k) {// 如果中间位置的数值小于要查找的数k,则遍历数组的后半部分，修改start值
			start = midIndex + 1;
		} else {// 如果中间位置的数值大于要查找的数k,则遍历数组的前半部分，修改end值
			end = midIndex - 1;
		}
		return getTheLastK(array, k, start, end);// 递归找出最后一次出现k的位置
	}
}
