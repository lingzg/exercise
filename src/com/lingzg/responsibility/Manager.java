package com.lingzg.responsibility;

/**
 * 经理类
 * @author lingzg
 *
 */
public class Manager extends Leader {
	@Override
	public int limit() {
		return 10000;
	}

	@Override
	public void handler(int money) {
		System.out.println("经理批复了" + money);
	}
}