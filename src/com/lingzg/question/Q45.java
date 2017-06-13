package com.lingzg.question;

public class Q45 {

	/**
	 * 题目：圆圈中最后剩下的数字 题目说明：0,1, ...
	 * ,n-1这n个数字排成一个圆圈，从数字0开始每次从这个圆圈里删除第m个数字。求出这个圆圈里剩下的最后一个数字。
	 * 解题思路：解决该问题主要是依靠的数学中的一种映射关系求出递归公式： f(n,m) = 0 n = 1; f(n,m) = [f(n-1,m) +
	 * m] % n n > 1
	 */
	public static void main(String[] args) {
		Q45 test = new Q45();
		System.out.println(test.LastNumber(5, 3));
	}

	public int LastNumber(int n, int m) {
		if (n < 1 || m < 1) {
			return -1;
		}
		int last = 0;
		for (int i = 2; i <= n; i++) {// 循环删除第m个数
			last = (last + m) % i;
		}
		return last;
	}
}
