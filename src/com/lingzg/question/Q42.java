package com.lingzg.question;

public class Q42 {

	/**
	 * 题目：翻转单词顺序VS左旋转字符串
	 * 题目说明：输入一个英文句子，翻转句子中单词的顺序，但单词内字符的顺序不变。为简单起见，标点符合和普通字符一样处理。例如输入字符串“I am a
	 * student.",则输出"student. a am I"。 解题思路(1)：翻转句子中所有的字符，例如 I am a student.——>
	 * .tneduts amaI，第二步翻转每个单词，——> student. a am I
	 * 解题思路(2):以空格为分界符，将字符串存放在String[]中，
	 */
	public static void main(String[] args) {
		Q42 test = new Q42();
		test.Reverse("i am a student.");
	}

	// 翻转函数，实现字符串的翻转
	public void Reverse(String string) {
		if (string == null) {
			return;
		}
		String[] strings = string.split(" ");// 每一个单元中存放的是一个单词
		// System.out.println(strings[0]);------>i
		// System.out.println(strings[1]);------>am
		StringBuffer stringBuffer = new StringBuffer();
		for (int i = strings.length - 1; i >= 0; i--) {
			stringBuffer.append(strings[i] + " ");// append()方法将字符串(每个单词)追加到字符序列中。
		}
		System.out.println(stringBuffer);
	}
}
/*
 * 说明：StringBuffer上的主要操作是append和insert方法，可重载这些方法，以接收任意类型的数据。
 * append()方法始终将这些字符添加到缓冲区的末端。
 */
