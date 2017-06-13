package com.lingzg.event;

import java.lang.Thread;

/**
 * Title: 娴嬭瘯绫�Description: 娴嬭瘯浜嗙敱浜庢敼鍙樺睘鎬ц�寮曡捣鐨勪簨浠跺彂鐢�Copyright: Copyright (c) 2005
 * Company: cuijiang
 * 
 * @author not attributable
 * @version 1.0
 */
public class TestDemo implements DemoListener {
	private DemoSource ds;

	public TestDemo() {
		ds = new DemoSource();
		ds.addDemoListener(this);
		System.out.println("");
		try {
			Thread.sleep(3000);
			// 鏀瑰彉灞炴�,瑙﹀彂浜嬩欢
			ds.setName("");
		} catch (InterruptedException ex) {
			ex.printStackTrace();
		}
		ds.addDemoListener(this);
		System.out.println("");
		try {
			Thread.sleep(3000);
			// 鏀瑰彉灞炴�,瑙﹀彂浜嬩欢
			ds.setName("");
		} catch (InterruptedException ex) {
			ex.printStackTrace();
		}
		ds.removeDemoListener(this);
		System.out.println("");
		try {
			Thread.sleep(3000);
			// 鏀瑰彉灞炴�,瑙﹀彂浜嬩欢
			ds.setName("");
		} catch (InterruptedException ex) {
			ex.printStackTrace();
		}

	}

	public static void main(String args[]) {
		new TestDemo();
	}

	/**
	 * demoEvent
	 *
	 * @param dm
	 *            DemoEvent
	 * @todo Implement this test.DemoListener method
	 */
	public void demoEvent(DemoEvent dm) {
		System.out.println("浜嬩欢澶勭悊鏂规硶");
		System.out.println(dm.getName());
		dm.say();
	}
}
