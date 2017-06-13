package com.lingzg.observer;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/**
 * 简单的观察者模式实现
 * 观察者模式中用到了回调: A. 观察者将自己注册到被观察者的监听者列表，且观察者类自身提供了一个回调函数 B.
 * 被观察者（Observable或Subject）维护观察者列表，并且可以注册和解注册观察者 C.
 * 一旦被观察者状态发生改变，它可以调用notifyObservers()，这个方法将遍历观察者列表并逐个调用 观察者提供的回调函数
 * 
 * @author will
 *
 */
public class SimpleObserverPattern {

	public static void main(String[] args) {
		SimpleObserverPattern sop = new SimpleObserverPattern();

		List<IObserver> observers = new ArrayList<IObserver>();
		IObserver observerA = sop.new Observer("ObserverA");
		IObserver observerB = sop.new Observer("ObserverB");
		observers.add(observerA);
		observers.add(observerB);

		IObservable observable = sop.new Observable(observers);
		observable.registerObserver(sop.new Observer("ObserverC"));

		observable.changeState();
		observable.close();
	}

	// 被观察者，有的地方叫Subject
	interface IObservable {
		void registerObserver(IObserver observer);

		void unregisterObserver(IObserver observer);

		void notifyObservers();

		String getState();

		void changeState();

		void close();
	}

	class Observable implements IObservable {

		private static final String NEW = "New";
		private static final String CHANGED = "Changed";
		private static final String CLOSED = "Closed";

		private String state;
		private List<IObserver> observers;

		public Observable() {
			this(null);
		}

		public Observable(List<IObserver> observers) {
			if (observers == null) {
				observers = new ArrayList<IObserver>();
			}
			this.observers = Collections.synchronizedList(observers);
			this.state = NEW;
		}

		@Override
		public void registerObserver(IObserver observer) {
			observers.add(observer);
		}

		@Override
		public void unregisterObserver(IObserver observer) {
			observers.remove(observer);
		}

		@Override
		public void notifyObservers() {
			Iterator<IObserver> iter = observers.iterator();
			while (iter.hasNext()) {
				iter.next().update(this);
			}
		}

		@Override
		public String getState() {
			return state;
		}

		@Override
		public void changeState() {
			this.state = CHANGED;
			notifyObservers();
		}

		@Override
		public void close() {
			this.state = CLOSED;
			notifyObservers();
		}
	}

	interface IObserver {
		void update(IObservable observalbe);
	}

	class Observer implements IObserver {

		private String name;

		public Observer(String name) {
			this.name = name;
		}

		@Override
		public void update(IObservable observalbe) {
			System.out.println(String.format("%s receive observalbe's change, current observalbe's state is %s", name,
					observalbe.getState()));
		}

	}
}