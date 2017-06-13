package com.lingzg.event;

import java.util.EventObject;

/**
 * JAVA鐢ㄦ埛鑷畾涔変簨浠剁洃鍚疄渚嬩唬鐮�Title: 浜嬩欢澶勭悊绫伙紝缁ф壙浜嗕簨浠跺熀绫�Description: Copyright: Copyright (c)
 * 2005 Company: cuijiang
 * 
 * @author not attributable
 * @version 1.0
 */
public class DemoEvent extends EventObject {
	private Object obj;
	private String sName;

	public DemoEvent(Object source, String sName) {
		super(source);
		obj = source;
		this.sName = sName;
	}

	public Object getSource() {
		return obj;
	}

	public void say() {
		System.out.println("杩欎釜鏄�say 鏂规硶...");
	}

	public String getName() {
		return sName;
	}
}
