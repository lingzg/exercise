package com.lingzg.observer;

import java.util.Observable;
import java.util.Observer;

/**
 * 使用java.util包中的标准类实现观察者模式
 * 
 * @author will
 *
 */
public class JDKObserverDemo {

	public static void main(String[] args) {
		JDKObserverDemo jod = new JDKObserverDemo();

		// 被观察者
		MyObservable myObservable = jod.new MyObservable("hello");
		// 观察者
		Observer myObserver = jod.new MyObserver();
		// 注册
		myObservable.addObserver(myObserver);
		// 改变被观察者状态，触发观察者回调函数
		myObservable.setValue("will");
	}

	class MyObservable extends Observable {

		private String watchedValue; // 被观察的值

		public MyObservable(String watchedValue) {
			this.watchedValue = watchedValue;
		}

		public void setValue(String newValue) {
			if (!watchedValue.equals(newValue)) {
				watchedValue = newValue;

				setChanged();
				notifyObservers(newValue);
			}
		}

		@Override
		public String toString() {
			return "MyObservable";
		}
	}

	class MyObserver implements Observer {
		@Override
		public void update(Observable o, Object arg) {
			System.out.println(o + "'s state changed, argument is: " + arg);
		}
	}
}
