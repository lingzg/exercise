package com.lingzg.event;

import java.util.Enumeration;
import java.util.Vector;

/**
 * Title: 浣跨敤浜嬩欢鐨勭被 Description: 璇ョ被瀹炵幇浜嗙洃鍚櫒鐨勬坊鍔犲拰鐩戝惉鍣ㄦ柟娉曠殑鎵ц锛屽苟涓斿疄鐜颁簡鐢变簬灞炴�鐨勬敼鍙樿�鎵ц浜嬩欢
 * Description: 鍦ㄦ坊鍔犮�鍒犻櫎銆佹墽琛岀洃鍚櫒鐨勬椂鍊欓兘瑕佹敞鎰忓悓姝ラ棶棰�Copyright: Copyright (c) 2005 Company:
 * cuijiang
 * 
 * @author not attributable
 * @version 1.0
 */
public class DemoSource {
	private Vector repository = new Vector();
	private DemoListener dl;
	private String sName = "";

	public DemoSource() {
	}

	// 娉ㄥ唽鐩戝惉鍣紝濡傛灉杩欓噷娌℃湁浣跨敤Vector鑰屾槸浣跨敤ArrayList閭ｄ箞瑕佹敞鎰忓悓姝ラ棶棰�
	public void addDemoListener(DemoListener dl) {
		repository.addElement(dl);// 杩欐瑕佹敞鎰忓悓姝ラ棶棰�
	}

	// 濡傛灉杩欓噷娌℃湁浣跨敤Vector鑰屾槸浣跨敤ArrayList閭ｄ箞瑕佹敞鎰忓悓姝ラ棶棰�
	public void notifyDemoEvent(DemoEvent event) {
		Enumeration enume = repository.elements();// 杩欐瑕佹敞鎰忓悓姝ラ棶棰�
		while (enume.hasMoreElements()) {
			dl = (DemoListener) enume.nextElement();
			dl.demoEvent(event);
		}
	}

	// 鍒犻櫎鐩戝惉鍣紝濡傛灉杩欓噷娌℃湁浣跨敤Vector鑰屾槸浣跨敤ArrayList閭ｄ箞瑕佹敞鎰忓悓姝ラ棶棰�
	public void removeDemoListener(DemoListener dl) {
		repository.remove(dl);// 杩欐瑕佹敞鎰忓悓姝ラ棶棰�
	}

	/**
	 * 璁剧疆灞炴�
	 * 
	 * @param str1
	 *            String
	 */
	public void setName(String str1) {
		boolean bool = false;
		if (str1 == null && sName != null)
			bool = true;
		else if (str1 != null && sName == null)
			bool = true;
		else if (!sName.equals(str1))
			bool = true;
		this.sName = str1;
		// 濡傛灉鏀瑰彉鍒欐墽琛屼簨浠�
		if (bool)
			notifyDemoEvent(new DemoEvent(this, sName));
	}

	public String getName() {
		return sName;
	}
}
