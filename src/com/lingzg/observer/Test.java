package com.lingzg.observer;

public class Test {
	public static void main(String[] args) {
		QuartzScheduler qs = new QuartzScheduler();

		SchedulerListener listenerA = new SchedulerListener() {

			@Override
			public void jobUnScheduled(Trigger trigger) {
				System.out.println("listenerA job unscheduled: " + trigger.getTriggerName());
			}

			@Override
			public void jobScheduled(Trigger trigger) {
				System.out.println("listenerA job scheduled: " + trigger.getTriggerName());
			}
		};
		SchedulerListener listenerB = new SchedulerListener() {

			@Override
			public void jobUnScheduled(Trigger trigger) {
				System.out.println("listenerB job unscheduled: " + trigger.getTriggerName());
			}

			@Override
			public void jobScheduled(Trigger trigger) {
				System.out.println("listenerB job scheduled: " + trigger.getTriggerName());
			}
		};

		// 注册Scheduler Listener
		qs.addInternalSchedulerListener(listenerA);
		qs.addInternalSchedulerListener(listenerB);

		Trigger triggerA = new Trigger("Key1", "triggerA");
		Trigger triggerB = new Trigger("Key2", "triggerB");
		qs.scheduleJob(triggerA);
		qs.scheduleJob(triggerB);
		qs.unScheduleJob(triggerA);
	}
}
