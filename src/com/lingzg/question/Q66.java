package com.lingzg.question;

public class Q66 {

	/**
	 * 题目：矩阵中的路径 题目说明：请设计一个函数，用来判断在一个矩阵中是否存在一条包含某字符串所有字符的路径。
	 * 路径可以从矩阵中任意一格开始，每一步可以再矩阵中向左右上下移动一格。 如果一条路径经过了矩阵的某一格，那么该路径不能再次进入该格子。
	 * 解题思路：用回溯法解决该题。任选一格格子作为路径的起点。 矩阵中某个格子的字符为ch，且路径中第i个字符也为ch，则匹配，否则不匹配。
	 * 如果匹配则，即路径上的第i个字符为ch，那么往相邻的格子寻找路径上第i+1个字符。 由于回溯的递归特性，路径可以看做是一个栈。
	 * 当在路径中定义了前n个字符后，在第n个字符的周围都没有找到第n+1个字符， 这时候路径上要退回到n-1的位置，重新定位第n个字符。
	 * 由于路径不能重新进入矩阵的格子，因此需要一个和矩阵同大小的布尔矩阵来控制路径是否访问过矩阵中的该字符。
	 */
	public static void main(String[] args) {
		System.out.println(hasPath("abcesfcsadee".toCharArray(), 3, 4, "bcced"));// true
		System.out.println(hasPath("abcesfcsadee".toCharArray(), 3, 4, "abcb"));// false
	}

	// matrix——表示矩阵
	// rows——表示矩阵的行数
	// cols——表示矩阵的列数
	// str——表示要查找的字符串
	// visited——表示布尔矩阵，控制矩阵中的字符是否被访问过
	public static boolean hasPath(char[] matrix, int rows, int cols, String str) {

		if (matrix == null || rows < 1 || cols < 1 || str == null) {// 条件合法性判断
			return false;
		}
		// 布尔矩阵，控制字符是否能被访问
		boolean[] visited = new boolean[rows * cols];
		for (int i = 0; i < visited.length; i++) {
			visited[i] = false;// 初试化
		}

		int pathLength = 0;// 字符串的长度
		for (int row = 0; row < rows; row++) {
			for (int col = 0; col < cols; col++) {
				if (hasPathCore(matrix, rows, cols, row, col, str, pathLength, visited)) {
					return true;// 能找到路径
				}
			}
		}

		return false;// 找不到的情况下
	}

	public static boolean hasPathCore(char[] matrix, int rows, int cols, int row, int col, String str, int pathLength,
			boolean[] visited) {
		if (pathLength >= str.length())
			return true;

		boolean hasPath = false;
		if ((row >= 0 && row < rows) && (col >= 0 && col < cols) && matrix[row * cols + col] == str.charAt(pathLength)
				&& !visited[row * cols + col]) {
			pathLength++;
			visited[row * cols + col] = true;

			hasPath = hasPathCore(matrix, rows, cols, row, col - 1, str, pathLength, visited)
					|| hasPathCore(matrix, rows, cols, row - 1, col, str, pathLength, visited)
					|| hasPathCore(matrix, rows, cols, row, col + 1, str, pathLength, visited)
					|| hasPathCore(matrix, rows, cols, row + 1, col, str, pathLength, visited);

			if (!hasPath) {
				pathLength--;
				visited[row * cols + col] = false;
			}
		}
		return hasPath;
	}
}
