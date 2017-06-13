package com.lingzg.observer;

import java.util.Collections;
import java.util.HashSet;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.Set;

/**
 * 上面的实现直接将被观察者对象作为回调函数参数，这样做很不优雅，在简单的场景可能奏效。但事实上更多情况下，一个被观察者有很多种事件或者状态，
 * 而每个观察者可能感兴趣的事件或状态都不相同，或者为了信息隐藏的目的，不想让每个观察者都能访问到Observable内部的所有状态。
 * 这样我继续演化代码为下面这个版本，注意我这里没有很细致地考虑并发问题。
 * 
 * 似乎看起来挺完美了，但还是不够完美。因为事件被硬编码为被观察者类的属性。这样事件类型在编译时期就被定死了，
 * 如果要增加新的事件类型就不得不修改IObservable接口和Observable类，这大大削减了灵活性。相当于被观察者耦合于这些具体的事件，
 * 那么我们如何来打破这个限制呢？答案是引入一个新的组件，让那个组件来管理事件、观察者、被观察者之间的关系，事件发生时也由那个组件来调用观察者的回调函数。
 * 这也是一种解耦吧，有点类似Spring的IOC容器。至于具体实现，我觉得Guava EventBus做得已经蛮好了，可以参考我前面提到的链接。
 * 
 * @author lingzg
 *
 */
public class MultiEventObserverPattern {

	public static void main(String[] args) {
		MultiEventObserverPattern meop = new MultiEventObserverPattern();

		IObservable observable = meop.new Observable();

		IObserver observerA = meop.new Observer("ObserverA");
		IObserver observerB = meop.new Observer("ObserverB");

		// 注册感兴趣的事件
		observable.registerObserver(observable.getEventA(), observerA);
		observable.registerObserver(observable.getEventB(), observerB);

		// 改变被观察者状态
		observable.changeStateA();
		observable.changeStateB();
	}

	interface IEvent {
		void eventChange();

		String getState();
	}

	class EventA implements IEvent {

		private static final String INITIALIZED = "Initialized";
		private static final String PENDING = "Pending";

		private String state;

		public EventA() {
			this.state = INITIALIZED;
		}

		@Override
		public void eventChange() {
			System.out.println("EventA change");
			this.state = PENDING;
		}

		@Override
		public String toString() {
			return "EventA";
		}

		@Override
		public String getState() {
			return state;
		}

	}

	class EventB implements IEvent {

		private static final String NEW = "New";
		private static final String IDLE = "Idle";

		private String state;

		public EventB() {
			this.state = NEW;
		}

		@Override
		public void eventChange() {
			System.out.println("EventB change");
			this.state = IDLE;
		}

		@Override
		public String toString() {
			return "EventB";
		}

		@Override
		public String getState() {
			return state;
		}
	}

	// 被观察者(Observable)，有的地方叫Subject
	interface IObservable {
		void registerObserver(IEvent event, IObserver observer);

		void unregisterObserver(IEvent event, IObserver observer);

		// 通知观察者某个事件发生了
		void notifyObservers(IEvent event);

		void changeStateA();

		void changeStateB();

		IEvent getEventA();

		IEvent getEventB();
	}

	class Observable implements IObservable {

		private IEvent eventA;
		private IEvent eventB;

		private Hashtable<IEvent, Set<IObserver>> eventObserverMapping;

		public Observable() {
			this(null);
		}

		// 这里如果evenObserverMapping传入的某些Set<IObserver>是未被同步修饰的，那么也没办法
		public Observable(Hashtable<IEvent, Set<IObserver>> eventObserverMapping) {
			if (eventObserverMapping == null) {
				eventObserverMapping = new Hashtable<IEvent, Set<IObserver>>();
			}
			this.eventObserverMapping = new Hashtable<IEvent, Set<IObserver>>();

			this.eventA = new EventA();
			this.eventB = new EventB();
		}

		@Override
		public void registerObserver(IEvent event, IObserver observer) {
			Set<IObserver> observers = eventObserverMapping.get(event);
			if (observers == null) {
				observers = Collections.synchronizedSet(new HashSet<IObserver>());
				observers.add(observer);
				eventObserverMapping.put(event, observers);
			} else {
				observers.add(observer);
			}
		}

		@Override
		public void unregisterObserver(IEvent event, IObserver observer) {
			Set<IObserver> observers = eventObserverMapping.get(event);
			if (observers != null) {
				observers.remove(observer);
			}
		}

		@Override
		public void notifyObservers(IEvent event) {
			Set<IObserver> observers = eventObserverMapping.get(event);
			if (observers != null && observers.size() > 0) {
				Iterator<IObserver> iter = observers.iterator();
				while (iter.hasNext()) {
					iter.next().update(event);
				}
			}
		}

		@Override
		public void changeStateA() {
			// 改变状态A会触发事件A
			eventA.eventChange();
			notifyObservers(eventA);
		}

		@Override
		public void changeStateB() {
			// 改变状态B会触发事件B
			eventB.eventChange();
			notifyObservers(eventB);
		}

		@Override
		public IEvent getEventA() {
			return eventA;
		}

		@Override
		public IEvent getEventB() {
			return eventB;
		}

	}

	interface IObserver {
		void update(IEvent event);
	}

	class Observer implements IObserver {

		private String name;

		public Observer(String name) {
			this.name = name;
		}

		@Override
		public void update(IEvent event) {
			System.out.println(String.format("%s receive %s's change, current observalbe's state is %s", name, event,
					event.getState()));
		}

	}
}
