package com.lingzg.question;

import java.util.Arrays;

public class Q44 {

	/**
	 * 题目：扑克牌的顺子
	 * 题目说明：从扑克牌中随机抽5张牌，判断是不是一个顺子，即这5张牌是不是连续的。2-10为数字本身，A为1，J为11，Q为12，K为13，而大、
	 * 小王可以看成任意数字。
	 * 解题思路：由于大小王可以看成任意数字，因此默认大小王均为0，且在扑克牌数字中0的个数为2，抽取5个数字先进行排序，然后统计5个数字中0的个数，
	 * 最后判断相邻的数字之间的空缺的总数。
	 */
	public static void main(String[] args) {
		// TODOAuto-generated method stub
		Q44 test = new Q44();
		int[] array = { 0, 1, 3, 4, 5 };
		int[] array1 = { 1, 3, 5, 6, 7 };
		System.out.println(test.isContinuity(array));
		System.out.println(test.isContinuity(array1));
	}

	public boolean isContinuity(int[] array) {
		if (array == null)// 合法性判断
			return false;
		// 第一步，对数组进行排序
		Arrays.sort(array);

		int zeroNum = 0;// 数组中0的个数
		int spaceNum = 0;// 数组中相邻数字之间空缺总数
		// 第二步：统计数组中0的个数
		for (int i = 0; i < array.length; i++) {
			if (array[i] == 0)
				zeroNum++;
		}
		// 第三步：统计数组中的空缺个数
		int i = zeroNum;
		int j = i + 1;
		while (j < array.length) {// 保证最大数的下标小于数组的长度
			if (array[i] == array[j])// 出现两个相等的数时，则数组中含有对子，则不是连续的数字
				return false;

			spaceNum += array[j] - array[i] - 1;// 统计数组中空缺的总数
			i = j;
			j++;
		}
		if (spaceNum > zeroNum)
			return false;
		return true;
	}
}
