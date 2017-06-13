package com.lingzg.question;

public class Q40 {
	/**
	 * 题目：数组中只出现一次的数字
	 * 题目说明：一个整型数组里除了两个数字之外，其他的数字都出现了两次。请写程序找出这两个只出现一次的数字。要求时间复杂度是O(n)，空间复杂度是O(1
	 * )。 解题思路：***该题比较难，也比较经典，作为自己提升的典型题目***
	 * 1)将所有的数字进行异或，由于有两个数字不一样，因此结果一定不为0，将该结果转化为二进制，其中必定有一位为1.
	 * 2)在二进制数中找到第一个为1的位的位置，标记为第n位。
	 * 3)以2)作为标准，将数组分成两个数组，第一个数组中第n位均为1，第二个数组中第n位均为0.——导致相同的数字分配到同一个数组中，
	 * 且两个只出现一次的数字分别分配到两个数组中。 4)接下来分别对两个子数组进行异或，寻找每个子数组中只出现一次的数字。
	 */
	public static void main(String[] args) {
		// TODO Auto-generatedmethod stub
		int[] array = { 2, 4, 3, 6, 3, 2, 5, 5 };
		Q40 test = new Q40();
		test.findNumOnlyOnce(array);
	}

	public void findNumOnlyOnce(int[] array) {
		if (array == null) {
			return;
		}
		int number = 0;// 用来存放所有数字异或后的结果
		for (int i : array) {
			number = number ^ i;
		}
		int index = findFirstBitIs1(number);// 找到number中第一个为1的位的位置，，例如数字5（0000
											// 0101），第一个为1的位的位置是6
		int number1 = 0;// 存放第一个只出现1次的数
		int number2 = 0;// 存放第二个只出现1次的数
		for (int i : array) {
			if (isBit1(i, index)) {// i，右移index位后，如果为0，则执行number1
				number1 = number1 ^ i;
			} else {// i,右移index位后，如果i为1，则执行number2
				number2 = number2 ^ i;
			}
		}
		System.out.println(number1);
		;
		System.out.println(number2);
	}

	public int findFirstBitIs1(int number) {// 找出第一个1出现的位置
		int index = 0;
		while ((number & 1) == 0) {// 如果第n位为0，则满足条件
			number = number >> 1;// 右移一位
			index++;
		}
		return index;
	}

	public boolean isBit1(int number, int index) {// 判断number的二进制表示中从右边数起的index位是不是1，如果是1则返回false。
		number = number >> index;
		return (number & 1) == 0;// number右移index位后，如果为0，则返回true
	}
}
