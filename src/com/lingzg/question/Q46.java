package com.lingzg.question;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;

public class Q46 {

	/**
	 * 题目：求1+2+ ... +n 题目说明：求1+2+ ...
	 * +n，要求不能使用乘除法、for、while、if、else、switch、case等关键字及条件判断语句(A ? B : C)。
	 * 解题思路：利用反射找到函数名递归得到最终结果
	 */
	public static void main(String args[])
			throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		Q46Template tCalculate = new Q46Template();
		System.out.println(tCalculate.sum(100));
	}
}

class Q46Template {
	/*
	 * 求1+2+...+n，不能使用乘除法，循环等 利用反射找到函数名递归得到
	 */
	public int teminator(int n) {
		return 0;
	}

	public int sum(int n) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		ArrayList<Boolean> testArrayList = new ArrayList<Boolean>();
		testArrayList.add(false);
		testArrayList.add(true);
		Method[] sMethods = this.getClass().getMethods();
		int index = testArrayList.indexOf(n == 0);
		return n-- + (Integer) sMethods[index].invoke(this, n);
	}
}