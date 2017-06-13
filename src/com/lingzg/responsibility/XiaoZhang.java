package com.lingzg.responsibility;

/**
 * 职员小张申请差旅报销：
 * 小张一共像小组长申请了三笔，这时运行实例如下:
 * CEO批复了50000
 * 小组长批复了500
 * 主管批复了5000
 * 我们可以看到不同的款项由不同的对象进行了处理，小张并不关心谁处理的，他只要找小组长即可。这就是责任链模式的特点。
 * @author lingzg
 *
 */
public class XiaoZhang {
	public static void main(String[] args) {
		GroupLeader groupLeader = new GroupLeader();
		Director director = new Director();
		Manager manager = new Manager();
		CEO ceo = new CEO();
		groupLeader.nextHandler = director;
		director.nextHandler = manager;
		manager.nextHandler = ceo;
		groupLeader.handlerRequest(50000);
		groupLeader.handlerRequest(500);
		groupLeader.handlerRequest(5000);
	}
}
