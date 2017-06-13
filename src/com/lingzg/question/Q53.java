package com.lingzg.question;

public class Q53 {

	/**
	 * 题目：正则表达式匹配
	 * 题目说明：请实现一个函数用来匹配包含'.'和'*'的正则表达式。模式中的字符'.'表示任意一个字符，'*'表示它签名的字符可以出现任意次（包含0次
	 * ）。 本题中，匹配是指字符串的所有字符匹配整个模式。例如，字符串“aaa”与模式“a.a”和“ab*ac*a”匹配，但与“aa.a”及“ab*a”
	 * 均不匹配。 解题思路：（1）比较字符串和模式，是不是均为空，是则返回true；
	 * （2）逐位进行匹配，匹配成功存在两种情况：1）和'.'匹配；2）字符一致相匹配。
	 * （3）逐位进行匹配，匹配不成功的情况：判断下一位是不是‘*’，模式多加一位，在进行比较；如果模式为‘.’，则存在两种情况，要么字符串加1，
	 * 要么原地踏步。
	 */
	public static void main(String[] args) {
		// TODOAuto-generated method stub
		String string1 = "aaa";
		String string2 = "ab*ac*a";
		Q53 test = new Q53();
		System.out.println(test.Match(string1, string2));
	}

	public boolean Match(String str1, String pattern) {
		if (str1 == null || pattern == null) {
			return false;
		}
		// char[] charStr1 = str1.toCharArray();
		// char[] charPat = pattern.toCharArray();
		return StringMatch(str1, 0, pattern, 0);
	}

	public boolean StringMatch(String str1, int i, String str2, int j) {// 模式中存在‘.’和‘*’
		if (i >= str1.length() && j >= str2.length()) {// 字符串和模式全部匹配结束，则表示匹配成功
			return true;
		}
		if (i < str1.length() && j >= str2.length()) {// 只有模式串到的尾部，但是字符串还没有到达尾部，则匹配失败（模式串太短）
			return false;
		}
		// 字符串到达尾部，但是模式没有到达尾部，可能存在匹配成功。
		if (j + 1 < str2.length() && str2.charAt(j + 1) == '*') {// 模式串未结束，且下一位为“*”
			if (i >= str1.length()) {// 字符串已经结束
				return StringMatch(str1, i, str2, j + 2);// 判断模式串
			} else {// 字符串未结束（匹配还没有结束）
				if (str1.charAt(i) == str2.charAt(j) || str2.charAt(j) == '.') {
					return StringMatch(str1, i + 1, str2, j + 2)// 字符串加1，模式串跳过“*”则加2
							|| StringMatch(str1, i, str2, j + 2) // 字符串是“.”，原地踏步，模式串跳过“*”则加2
							|| StringMatch(str1, i + 1, str2, j);// 字符串加1，模式串不变（因为*可以表示它前面的字符有若干个）
				} else {
					return StringMatch(str1, i, str2, j + 2);
				}
			}
		}
		// 字符串已经结束
		if (i >= str1.length()) {
			return false;
		} else {// 字符串还没有结束------------逐位都是一样（一般的字符）的字符的情况，逐位加1继续比较
			if (str1.charAt(i) == str2.charAt(j) || str2.charAt(j) == '.') {
				return StringMatch(str1, i + 1, str2, j + 1);
			}
		}
		return false;
	}
}
