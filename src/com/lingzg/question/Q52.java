package com.lingzg.question;

public class Q52 {

	/**
	 * 题目：Q52构建乘积数组 题目说明：给定一个数组A[0,1,...,n-1],请构建一个数组B[0,1,...,n-1]，
	 * 其中B中的元素B[i]=A[0]*A[1]*...*A[i-1]*A[i+1]*...*A[n-1]不能使用除法
	 * 解题思路：由于B[i]的元素是数组A中除去A[i]外剩余元素的成绩，因此可以将其看做是两部分的成绩。即B[i]=C[i]*D[i]
	 * 其中，C[i]=C[i-1]*A[i-1]，D[i]=D[i+1]*A[i+1]。
	 */
	public static void main(String[] args) {
		Q52 test = new Q52();
		int[] A = { 1, 2, 3, 4, 5, 6, 7, 8, 9 };
		int[] B = new int[9];
		// System.out.println(A[1]);
		test.createMultiplyNums(A, B);
	}

	public void createMultiplyNums(int[] A, int[] B) {
		if (A == null || A.length == 0)
			return;
		if (A.length == B.length && B.length > 1) {
			B[0] = 1;
			for (int i = 1; i < A.length; i++) {
				B[i] = B[i - 1] * A[i - 1];// B[i]中存放的是A[i-1]之前的数组元素的乘积
				// System.out.println(B[i]);
			}
			System.out.println(B[A.length - 1]);
			int temp = 1;
			for (int j = A.length - 2; j >= 0; j--) {
				temp = temp * A[j + 1];
				B[j] = B[j] * temp;
				System.out.println(B[j]);
			}
		}
	}
}
