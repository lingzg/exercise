package com.lingzg.observer;

public class Trigger {
	private String triggerKey;
	private String triggerName;

	public Trigger(String triggerKey, String triggerName) {
		this.triggerKey = triggerKey;
		this.triggerName = triggerName;
	}

	public String getTriggerKey() {
		return triggerKey;
	}

	public void setTriggerKey(String triggerKey) {
		this.triggerKey = triggerKey;
	}

	public String getTriggerName() {
		return triggerName;
	}

	public void setTriggerName(String triggerName) {
		this.triggerName = triggerName;
	}

	public String toString() {
		return String.format("{triggerKey: %s, triggerName: %s}", triggerKey, triggerName);
	}

}
