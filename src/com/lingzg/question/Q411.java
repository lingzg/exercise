package com.lingzg.question;

public class Q411 {

	/**
	 * 题目：打印所有和为s的连续正数序列
	 * 题目说明：输入一个正数s，打印出所有和为s的连续正数序列（至少含有两个数）。例如输入15，由于1+2+3+4+5=4+5+6=7+8=15，
	 * 所以打印出3个连续的序列1,2,3,4,5 4,5,6 7,8
	 * 解题思路：先设置一个最小值small和一个最大值big，如果它们之间的和等于S，则打印出来。
	 * 如果它们之间的数字的和大于S，则减去small，small++，继续比较。
	 * 如果它们之间的数字的和小于S，则加上big的数字，big++，继续比较。
	 */
	public static void main(String[] args) {
		Q411 test = new Q411();
		test.printSequenceSum(15);
	}

	public void printSequenceSum(int sum) {
		if (sum < 3) {// 由于small和big的初试值为1,2，因此要求的数字sum必须大于3
			return;
		}
		int small = 1;
		int big = 2;
		int currentSum = small + big;// currentSum记录当前small和big之间的数的和
		int midValue = (1 + sum) / 2;// 保证sum至少是有两个数字相加得到。（最小的数字必须小于sum的一半）
		while (small < big) {
			if (currentSum == sum) {// small和big之间的数字和等于sum，则打印出small到big之间的数字
				for (int i = small; i <= big; i++) {
					System.out.print(i + ",");
				}
				System.out.println();
			}
			while (currentSum > sum && small < midValue) {// small和big之间的和大于sum，则减去较小的数字small，并让small指向下一个数字small++
				currentSum = currentSum - small;
				small++;
				if (currentSum == sum) {// 减去small后，如果等于sum则打印序列
					for (int i = small; i <= big; i++) {
						System.out.print(i + ",");
					}
					System.out.println();
				}
			}
			// currentSum < sum 则让big++，增大currentSum的值，再循环判断
			big++;
			currentSum = currentSum + big;
		}
	}
}
