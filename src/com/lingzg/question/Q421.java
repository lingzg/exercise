package com.lingzg.question;

public class Q421 {

	/**
	 * 题目：把字符串前面的若干个字符转移到字符串的尾部
	 * 题目说明：字符串的左旋转操作是把字符串前面的若干个字符转移到字符串的尾部。请定义一个函数实现字符串左旋转操作的功能。比如输入字符串“abcdefg
	 * ”和数字2，该函数将返回左旋转2位得到的结果“cdefgab”。
	 * 解题思路：先把字符串从k处进行分割，分割成两个字符串。然后利用reverse()函数进行翻转。之后再将两个子字符串进行翻转。
	 */
	public static void main(String[] args) {
		Q421 test = new Q421();
		test.reverseStrKChar("abcdefg", 2);
	}

	public void reverseStrKChar(String str, int k) {
		if (str == null || k < 0 || k > str.length()) {// 合法性判断，主要防止越界异常
			return;
		}
		String[] split = { str.substring(0, k), str.substring(k, str.length()) };// 将字符串从K的位置分成两个子字符串数组中
		StringBuffer strBuffer = new StringBuffer();
		for (String s : split) {
			strBuffer.append(reverse(s));// 将字符串翻转后写入到StringBuffer中，先翻转部分字符
		}
		System.out.println(reverse(strBuffer.toString()));// 将翻转后的字符在进行整体翻转，即将ab,调整到字符串的最后边

	}

	public String reverse(String str) {
		char[] array = str.toCharArray();// 将字符串转换成字符数组
		for (int i = 0; i < (array.length + 1) / 2; i++) {// 实现字符串的翻转，第一个和最后一个交换，一次类推
			char temp = array[i];
			array[i] = array[array.length - 1 - i];
			array[array.length - 1 - i] = temp;
		}
		return String.valueOf(array);// 返回翻转之后的字符串
	}
}
