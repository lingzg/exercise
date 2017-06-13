package com.lingzg.responsibility;

/**
 * 老板类
 * @author lingzg
 *
 */
public class CEO extends Leader {
	@Override
	public int limit() {
		return Integer.MAX_VALUE;
	}

	@Override
	public void handler(int money) {
		System.out.println("CEO批复了" + money);
	}
}
