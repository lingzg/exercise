package com.lingzg.responsibility;

/**
 * 主管类：
 * 
 * @author lingzg
 *
 */
public class Director extends Leader {
	@Override
	public int limit() {
		return 5000;
	}

	@Override
	public void handler(int money) {
		System.out.println("主管批复了" + money);
	}
}
