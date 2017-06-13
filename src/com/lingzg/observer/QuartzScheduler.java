package com.lingzg.observer;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Quartz核心类，相当于Observable（被观察者）
 * 
 * @author will
 *
 */
public class QuartzScheduler {

	private ArrayList<SchedulerListener> internalSchedulerListeners = new ArrayList<SchedulerListener>(10);
	// private ArrayList<JobListener> interanlJobListeners = new
	// ArrayList<JobListener>(); // 一个Observable可以包含多组监听器

	public Date scheduleJob(Trigger trigger) {
		if (trigger == null) {
			return null;
		}

		System.out.println("Schedule job, trigger: " + trigger);

		notifySchedulerListenersScheduled(trigger);

		return new Date();
	}

	public void unScheduleJob(Trigger trigger) {
		if (trigger == null) {
			return;
		}

		System.out.println("Unschedule job, trigger: " + trigger);

		notifyShedulerListenerUnScheduled(trigger);
	}

	// 注册SchedulerListener
	public void addInternalSchedulerListener(SchedulerListener schedulerListener) {
		synchronized (internalSchedulerListeners) {
			internalSchedulerListeners.add(schedulerListener);
		}
	}

	// 移除SchedulerListener
	public boolean removeInternalSchedulerListener(SchedulerListener schedulerListener) {
		synchronized (internalSchedulerListeners) {
			return internalSchedulerListeners.remove(schedulerListener);
		}
	}

	public List<SchedulerListener> getInternalSchedulerListeners() {
		synchronized (internalSchedulerListeners) {
			return java.util.Collections.unmodifiableList(new ArrayList<SchedulerListener>(internalSchedulerListeners));
		}
	}

	public void notifySchedulerListenersScheduled(Trigger trigger) {
		for (SchedulerListener listener : getInternalSchedulerListeners()) {
			listener.jobScheduled(trigger);
		}
	}

	public void notifyShedulerListenerUnScheduled(Trigger trigger) {
		for (SchedulerListener listener : getInternalSchedulerListeners()) {
			listener.jobUnScheduled(trigger);
		}
	}
}
