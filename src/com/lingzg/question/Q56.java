package com.lingzg.question;

import com.lingzg.node.ListNode;

public class Q56 {

	/**
	 * 题目：链表中环的入口结点 题目说明：一个链表中包含环，如何找出环的入口结点？
	 * 解题思路：要判断链表中环的入口结点，先判断链表中是否有环存在，如果有环则找出环的结点数，最后再遍历链表找出入口结点。
	 * 1）判断是否有环：遍历链表，一个以+1的速度前进，一个以+2的速度遍历，直到它们相遇为止。找到相遇结点
	 * 2）相遇后一个结点不动，快结点不动，慢节点继续直到再次相遇，求出环的结点数i；
	 * 3）从头遍历，快结点先走i个结点，然后慢节点和快结点一起前进，直到在环的入口处再次相遇。
	 */
	public static void main(String[] args) {
		ListNode head = new ListNode();
		ListNode first = new ListNode();
		ListNode second = new ListNode();
		ListNode third = new ListNode();
		ListNode fourth = new ListNode();
		ListNode five = new ListNode();
		ListNode six = new ListNode();

		head.nextNode = first;
		first.nextNode = second;
		second.nextNode = third;
		third.nextNode = fourth;
		fourth.nextNode = five;
		five.nextNode = six;
		six.nextNode = third;

		first.data = 1;
		second.data = 2;
		third.data = 3;
		fourth.data = 4;
		five.data = 5;
		six.data = 6;
		ListNode newListNode = JudgeCircle(head);
		int m = TheNumsOfCircle(newListNode);
		System.out.println(EntryNode(head, m).data);
	}

	public static ListNode JudgeCircle(ListNode head) {
		if (head == null) {
			return null;
		}
		ListNode slow = head;
		ListNode fast = slow.nextNode;
		if (fast != null) {
			while (slow != fast) {
				slow = slow.nextNode;
				fast = fast.nextNode.nextNode;
			}
			// System.out.println(fast.data);
			return fast;
		}
		return null;// 链表中存在环，返回fast结点所在的位置
	}

	// 判断环中结点个数
	public static int TheNumsOfCircle(ListNode head) {
		int i = 0;
		if (JudgeCircle(head) != null) {
			ListNode cur = JudgeCircle(head);
			ListNode cur1 = cur.nextNode;
			while (cur != cur1) {
				cur1 = cur1.nextNode;
				i++;
			}
		}
		return i + 1;
	}

	public static ListNode EntryNode(ListNode head, int i) {
		ListNode t = head;
		ListNode h = head;
		for (int j = 0; j < i; j++) {
			h = h.nextNode;
		}
		while (t != h) {
			t = t.nextNode;
			h = h.nextNode;
		}
		// System.out.println(t.data);
		return t;
	}
}
