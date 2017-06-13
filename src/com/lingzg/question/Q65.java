package com.lingzg.question;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;

public class Q65 {

	/**
	 * 题目：滑动窗口的最大值 题目说明：给定一个数组和滑动窗口的大小，请找出所有滑动窗口里的最大值。 例如输入数组
	 * {2,3,4,2,6,2,5,1}以及滑动窗口的大小，那么一共存在6个滑动窗口，它们的最大值分别为{4;4;6;6;6;5}。
	 * 解题思路：把数组中可能成为滑动窗口的最大的数值存入到一个两头开口的队列中。在队列中存入的是数字在队列中的下标，而不是数值。
	 * 当一个数字的下标与当前处理的数字的下标之差大于或者等于滑动窗口的大小时，这个数字已经从窗口中滑出，可以从队列中删除了。
	 */
	public static void main(String[] args) {
		int num[] = { 2, 3, 4, 2, 6, 2, 5, 1 };
		ArrayList<Integer> list = maxInWindows(num, 3);
		for (int i : list) {
			System.out.print(i + ";");
		}
	}

	public static ArrayList<Integer> maxInWindows(int[] num, int size)// size是窗口的大小
	{
		ArrayList<Integer> Window_max = new ArrayList<Integer>();// 保存每个窗口中的最大值数组
		Deque<Integer> deque = new LinkedList<Integer>();// 创建一个——“双向队列”

		for (int i = 0; i < size; i++) {// 先把当前空窗口填满，填满以后，deque中存放了窗口中的最大数
			while (!deque.isEmpty() && num[i] >= num[deque.getLast()]) {
				deque.removeLast();
			}
			deque.addLast(i);// 在队列的尾部添加最大值的下标 i
		}

		for (int i = size; i < num.length; i++) {// 窗口填满以后开始向右移动窗口

			Window_max.add(num[deque.getFirst()]);// 窗口中添加新元素前，要保存当前窗口的最大值
			// 然后窗口滑动一步，比较num[i]和deque中下标对应的数，deque中First对应的数字是当前最大值
			while (!deque.isEmpty() && num[i] >= num[deque.getLast()]) {
				deque.removeLast();
			}

			if (!deque.isEmpty() && deque.getFirst() <= (i - size))// 另外，需要删除已经不在当前窗口的数字对应的下标
				deque.removeFirst();

			deque.addLast(i);// 把需要添加最新的数字进deque队列 。
								// 这样就能保证当前窗口中最大的值为deque的First。
		}
		// 把最后一个窗口的最大值加入Window_max中。
		Window_max.add(num[deque.getFirst()]);
		return Window_max;
	}
}
