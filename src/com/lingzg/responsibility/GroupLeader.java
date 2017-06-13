package com.lingzg.responsibility;

/**
 * 小组长类：
 * @author lingzg
 *
 */
public class GroupLeader extends Leader {
	public int limit() {
		return 1000;// 说明小组长有1000元的批复权限
	}

	public void handler(int money) {
		System.out.println("小组长批复了" + money);
	}
}
