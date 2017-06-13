package com.lingzg.responsibility;

/**
 * 责任链(Chain of
 * Responsibility)模式是一种对象的行为模式。在责任链模式里，很多对象由每一个对象对其下家的引用而连接起来形成一条链。请求在这个链上
 * 传递，直到链上的某一个对象决定处理此请求。发出这个请求的客户端并不知道链上的哪一个对象最终处理这个请求，这使得系统可以在不影响客户端的情况下动态
 * 地重新组织和分配责任。
 * 责任链模式属于行为型设计模式之一，怎么理解责任链？责任链是可以理解成数个对象首尾连接而成，每一个节点就是一个对象，每个对象对应不同的处理逻辑，
 * 直至有一个对象响应处理请求结束。这一种模式成为责任链模式。
 * 也就是说每一个客户（Client）都由销售人员接待，客户提出不同的权限，由销售人员交给不同的对象进行递次处理。客户并不关心哪个对象处理了他的请求，
 * 这样就降低了请求发送者和接受者之间的耦合关系。下面我们通过一个出差差旅费批准为例，实现以下责任链模式，首先定义一个抽象的领导类：
 * 
 * @author lingzg
 *
 */
public abstract class Leader {
	protected Leader nextHandler;// 上一级领导

	public final void handlerRequest(int money) {
		if (money <= limit()) {// 小于限制，可以批复
			handler(money);
		} else {
			if (nextHandler != null) {
				nextHandler.handlerRequest(money);// 交给上一级领导处理
			}
		}
	}

	/*
	 * 批款限额
	 */
	public abstract int limit();

	/*
	 * 批款
	 */
	public abstract void handler(int money);
}
