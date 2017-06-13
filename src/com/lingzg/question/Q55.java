package com.lingzg.question;

import java.util.ArrayList;
import java.util.HashMap;

public class Q55 {

	/**
	 * @param args
	 *            题目：字符流中第一个不重复的字符
	 *            题目说明：请实现一个函数用来找出字符流中第一个只出现一次的字符。例如，当从字符流中只读出前两个字符“go”时，
	 *            第一个只出现一次的字符时“g”。当从该字符流中读出前六个字符“google”时，第一个只出现一次的字符时“l”。
	 *            解题思路：建立一个哈希表，以字符为key，以字符出现的次数为value。同时创建一个数组列表，查询字符出现的次数。
	 *            先将字符存入哈希表中，如果字符已经存在，则value值加1，
	 *            如果字符不存在则将value设为1，同时将字符添加到列表中，所有元素遍历完后，在去查找列表，寻找第一个value值为1的元素
	 *            （即第一个不重复的字符）。
	 */
	public static void main(String[] args) {
		String string = "google";
		char[] strchar = string.toCharArray();
		for (int i = 0; i < strchar.length; i++) {
			Insert(strchar[i]);
		}
		System.out.println(FirstAppearingOnce());
	}

	// 建立哈希表，键时字符，值是出现的次数
	public static HashMap<Character, Integer> map = new HashMap<Character, Integer>();// 存放字符和其出现的次数
	public static ArrayList<Character> list = new ArrayList<Character>();// 存放字符(哈希表存放离散字符，要用list控制字符出现的顺序)

	public static void Insert(char ch) {//
		// 判断map中是否包含已经插入的字符，如果已经包含了，则将其次数设为-1
		if (map.containsKey(ch)) {// map.containsKey(key)如果此映射包含对于指定键的映射关系，则返回
									// true。
			map.put(ch, map.get(ch) + 1);// map.get(ch)是根据key获得value的值
		} else {
			map.put(ch, 1);// map中第一次出现ch，将值设为1
		}
		list.add(ch);// 便于查询出现的次数
	}

	public static char FirstAppearingOnce() {
		char ch = '#';
		for (int i = 0; i < list.size(); i++) {
			if (map.get(list.get(i)) == 1) {// 第一个出现1的字符，就是要查找的第一个不重复的字符
				ch = list.get(i);
				break;
			}
		}
		return ch;
	}
}
