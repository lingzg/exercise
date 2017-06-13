package com.lingzg.question;

public class Q54 {

	/**
	 * 题目：表示数值的字符串
	 * 题目说明：请实现一个函数用来判断字符串是否表示数值（包括整数和小数）。例如字符串“100”、“5e2”、“-123”、“3.1216”及“1E-
	 * 16”都表示数值， 但“12e”、“1a3.14”等不是。 解题思路：首先要明确字符串的格式：
	 * [sign]integral-digits[.[fractional-digits]][e|E[sign]exponential-digits]
	 * 其中[]之间的是可有可无的部分。
	 */
	public static void main(String[] args) {
		Q54 test = new Q54();
		System.out.println(test.isNumbers("-1E-16") + "-----true");
		System.out.println(test.isNumbers("100") + "-----true");
		System.out.println(test.isNumbers("12e") + "----false");
	}

	public boolean isNumbers(String str) {
		if (str == null || str.length() == 0) {
			return false;
		}
		int i = 0;
		// 先判断字符串的第一位是不是符号位
		if (str.charAt(i) == '+' || str.charAt(i) == '-') {
			i++;
		}
		// 如果到达字符串的末尾
		if (i >= str.length()) {
			return false;
		}
		boolean numeric = true;
		i = Digits(str, i);
		if (i < str.length()) {// 数字后边还有字符。此时要区分是e | E | .
			if (str.charAt(i) == '.') {// 表示---小数
				i++;// 小数点后一位
				i = Digits(str, i);// 判断是不是数字字符，返回数字字符的下一位

				if (i >= str.length()) {// 到了字符串的末尾，则是数字且带小数
					numeric = true;
				} else if (i < str.length() && str.charAt(i) == 'e' || str.charAt(i) == 'E') {// 还没有到字符串的末尾，则判断后边是不是e
																								// /
																								// E
					numeric = isExponential(str, i);// 判断是不是指数
				} else {
					numeric = false;
				}
			} else if (str.charAt(i) == 'e' || str.charAt(i) == 'E') {// 表示数字后边不是'.'而是e或者E，表示---指数
				numeric = isExponential(str, i);
			} else {// 表示不是指数
				numeric = false;
			}
			return numeric;// 判断数字后边情况的结果
		} else {
			return true;// 表示i >= str.length(),数字没有指数部分
		}
	}

	// 函数Digits()用来判断是不是位于0-9之间的字符
	public static int Digits(String str, int i) {
		while (i < str.length() && str.charAt(i) >= '0' && str.charAt(i) <= '9') {// 判断条件要有先后顺序，先判断是不是在范围内（防止越界异常），后判断是不是数字字符
			i++;
		}
		return i;// i是数字的后一位
	}

	// 函数isExponential()用来判断是不是指数
	// 判断科学计数法的结尾部分，可以分为：E2，E+2， E-2，e2,e+2,e-2
	public static boolean isExponential(String str, int i) {
		if (i >= str.length() || (str.charAt(i) != 'e' && str.charAt(i) != 'E')) {// 下一位不含有e或E
			return false;
		}
		i++;
		if (i >= str.length()) {// 如果e或者E后边为空，则返回false
			return false;
		}
		if (str.charAt(i) == '+' || str.charAt(i) == '-') {// 判断e或者E后边的正负号
			i++;
		}
		if (i >= str.length()) {// 判断'+'和'-'之后的字符是不是为空
			return false;
		}
		i = Digits(str, i);
		if (i < str.length()) {// 表示指数的数字部分后边不为空
			return false;
		}
		return true;
	}
}
