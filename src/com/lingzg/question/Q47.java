package com.lingzg.question;

public class Q47 {

	/**
	 * 题目：不用加减乘除做加法 题目说明：写一个函数求两数之和，要求在函数体内不能使用+、-、*、/四则运算符号。 解题思路：考虑二进制数字的异或运算。
	 */
	public static void main(String[] args) {
		Q47 test = new Q47();
		System.out.println(test.newAddMethod(10, 30));

	}

	public int newAddMethod(int number1, int number2) {
		int sum;
		int carray;// 存储移位运算结果
		while (number2 != 0) {
			sum = number1 ^ number2;// 两数进行异或运算
			carray = (number1 & number2) << 1;// 右移位
			number1 = sum;
			number2 = carray;
		}
		return number1;// 两数之和保存在number1中
	}
}
