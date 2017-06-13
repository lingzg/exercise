package com.lingzg.httpxc;

public class TestMethod {
	public TestMethod() { /// xx/weblogic60b2_win.exe
		try {
			SiteInfoBean bean = new SiteInfoBean("http://127.0.0.1:8080/baotai/static/app/shipin.mp4", "F:\\ceshi",
					"shipin.mp4", 5);
			SiteFileFetch fileFetch = new SiteFileFetch(bean);
			fileFetch.start();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		new TestMethod();
	}
}
