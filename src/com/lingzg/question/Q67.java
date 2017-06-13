package com.lingzg.question;

public class Q67 {

	/**
	 * 题目：机器人的运动范围 题目说明：地上有一个m行n列的方格。一个机器人从坐标（0，0）的格子开始移动，它每一次可以向左，右，上，下移动一格，
	 * 但不能进入行坐标和列坐标的数位之和大于K的格子。例如，当K为18时，机器人能够进入方格（35,37）因为，3+5+3+7=18，
	 * 但是不能进入方格（35,38），因为3+5+3+8=19.求该机器人能够到达多少个格子。
	 * 解题思路：可以参考66题的回溯思想来解决该题。1、首先利用回溯来遍历格子。 2、检测一个格子，判断机器人是否能进入。
	 * 3、机器人进入的条件是格子数总各个数的位数和。
	 */
	public static void main(String[] args) {
		System.out.println(rangeOfMoving(30, 30, 10));
	}

	// 利用回溯来遍历格子,统计其中可以进入格子的个数
	public static int rangeOfMoving(int rows, int cols, int k) {

		if (rows <= 0 || cols <= 0 || k < 0)
			return 0;
		boolean[] visited = new boolean[rows * cols];// 布尔类型的数组控制遍历访问的状态
		for (int i = 0; i < visited.length; i++) {
			visited[i] = false;// 初始化
		}

		int count = MovingCount(rows, cols, 0, 0, k, visited);// 从（0,0）开始

		return count;

	}

	private static int MovingCount(int rows, int cols, int row, int col, int k, boolean[] visited) {
		int count = 0;
		// 判断机器人是否可以进入坐标
		if (CheckBox(rows, cols, row, col, k, visited)) {// 机器人能够进入坐标，将其访问情况设为true，并且count+1
			visited[row * cols + col] = true;
			count = 1 + MovingCount(rows, cols, row, col - 1, k, visited) // 左
					+ MovingCount(rows, cols, row - 1, col, k, visited) // 上
					+ MovingCount(rows, cols, row, col + 1, k, visited) // 右
					+ MovingCount(rows, cols, row + 1, col, k, visited); // 下
			// System.out.print("("+row+","+col+");");//可以输出对应的符合条件的坐标
		}
		return count;
	}

	private static boolean CheckBox(int rows, int cols, int row, int col, int k, boolean[] visited) {
		if ((row >= 0 && row < rows) && (col >= 0 && col < cols) && (getDigitSum(row) + getDigitSum(col)) < k
				&& !visited[row * cols + col]) {
			return true;
		}
		return false;
	}

	// 求一个数的各位数的和
	private static int getDigitSum(int number) {
		int sum = 0;
		while (number > 0) {
			sum = sum + number % 10;// 余数之和
			number = number / 10;// 获取商
		}
		return sum;
	}

}
