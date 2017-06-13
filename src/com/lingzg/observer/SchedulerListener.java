package com.lingzg.observer;

//监听接口，回调函数，Client注册监听时需要提供回调函数实现
public interface SchedulerListener {

	void jobScheduled(Trigger trigger);

	void jobUnScheduled(Trigger trigger);
}
