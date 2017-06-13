package com.lingzg.question;

public class Q43 {

	/**
	 * 题目：n个骰子的点数 题目说明：把n个骰子仍在地上，所有骰子朝上一面的点数之和为s。输入n,打印出s的所有可能的值出现的概率。
	 * 解题思路(1):现在我们考虑如何统计每一个点数出现的次数。要想求出n个骰子的点数和，可以先把n个骰子分为两堆：
	 * 第一堆只有一个，另一个有n-1个。单独的那一个有可能出现从1到6的点数。我们需要计算从1到6的每一种点数和剩下的n-1个骰子来计算点数和。
	 * 接下来把剩下的n-1个骰子还是分成两堆，第一堆只有一个，第二堆有n-2个。我们把上一轮哪个单独骰子的点数和这一轮单独骰子的点数相加，再和n-
	 * 2个骰子来计算点数和。 分析到这里，我们不难发现这是一种递归的思路，递归结束的条件就是最后只剩下一个骰子。
	 * 解题思路(2):可以考虑用两个数组来存储骰子点数的每一个总数出现的次数。在一次循环中，每一个数组中的第n个数字表示骰子和为n出现的次数。
	 * 在下一轮循环中，我们加上一个新的骰子，此时和为n出现的次数。
	 * 下一轮中，加上一个新的骰子，此时和为n的骰子出现的次数应该等于上一次循环中骰子点数和为n-1,n-2,n-3,n-4,n-5,n-6的次数之和，
	 * 所以我们把另一个数组的第n个数字设为前一个数组对应的第n-1，n-2，n-3，n-4，n-5与n-6的之和。
	 */
	public static void main(String[] args) {
		Q43 test = new Q43();
		test.printProb(2);
		System.out.println("******************************************");
		test.PrintProbability(2);
	}

	int maxValue = 6;

	// 基于循环求骰子点数
	public void printProb(int n) {
		if (n < 1) {
			return;
		}
		int maxSum = n * maxValue;// 表示n个骰子的最大值是6n
		int[] pProb = new int[maxSum - n + 1];// 声明一个数组为6n-n+1

		for (int i = n; i <= maxSum; ++i) {// 随机产生的和数最小为n
			pProb[i - n] = 0;// i-n表示数组的下标从0开始
		}

		Probability(n, pProb);

		int total = (int) Math.pow(maxValue, n);// total = 6^n
		for (int i = n; i <= maxSum; ++i) {
			double ratio = (double) pProb[i - n] / total;// 出现的概率
			System.out.println(i + "的概率为：" + ratio);
		}
	}

	public void Probability(int number, int[] array) {
		for (int i = 1; i <= maxValue; ++i) {
			Probabilitys(number, number, i, array);
		}
	}

	public void Probabilitys(int original, int current, int sum, int[] array) {
		if (current == 1) {
			array[sum - original]++;
		} else {
			for (int i = 1; i <= maxValue; ++i) {
				Probabilitys(original, current - 1, i + sum, array);
			}
		}
	}

	// 基于循环求骰子点数
	public void PrintProbability(int n) {
		if (n < 1) {
			return;
		}

		int[][] pProb = new int[2][];
		pProb[0] = new int[maxValue * n + 1];
		pProb[1] = new int[maxValue * n + 1];
		int flag = 0;

		for (int i = 1; i <= maxValue; i++) {
			pProb[0][i] = 1;
		}
		for (int k = 2; k <= n; ++k) {
			for (int i = 0; i < k; ++i) {
				pProb[1 - flag][i] = 0;
			}
			for (int i = k; i <= maxValue * k; ++i) {
				pProb[1 - flag][i] = 0;
				for (int j = 1; j <= i && j <= maxValue; ++j) {
					pProb[1 - flag][i] += pProb[flag][i - j];
				}
			}
			flag = 1 - flag;
		}

		double total = Math.pow(maxValue, n);
		for (int i = n; i <= maxValue * n; i++) {
			double ratio = (double) pProb[flag][i] / total;
			System.out.println(i + "的概率为：" + ratio);
		}
	}
}
