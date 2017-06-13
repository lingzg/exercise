package com.lingzg.question;

import com.lingzg.node.ListNode;

public class Q57 {

	/**
	 * 题目：删除链表中重复的结点 题目说明：在一个排序的链表中，如何删除重复的结点。例如：1 2 3 3 4 4 5 删除操作后为 1 2 5
	 * 解题思路：解决该题的一个关键点是，该链表已经是排好序的，这样便于比较操作和删除结点。操作思路如下：
	 * 1.新建一个头节点，以防第一个节点被删除，使得链表没有头结点。
	 * 2.保存当前节点的上个节点，循环遍历整个链表，如果当前节点的值与下一个节点的值相等，则将当前节点的值与next.next节点的值比较，
	 * 直到不相等或者null为止，最后将当前节点的上个节点pre指向最后比较不相等的节点。
	 * 3.如果当前节点与next节点不相等，则直接节点指针全部向后移动一位。
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
		six.nextNode = null;

		head.data = 1;
		first.data = 2;
		second.data = 3;
		third.data = 3;
		fourth.data = 4;
		five.data = 4;
		six.data = 5;
		// System.out.println(DelDuplication(head).nextNode.nextNode.nextNode.data);
		ListNode headListNode = DelDuplication(head);
		while (headListNode != null) {
			System.out.println(headListNode.data);
			headListNode = headListNode.nextNode;
		}
	}

	public static ListNode DelDuplication(ListNode head) {
		// 合法性判断
		if (head == null) {
			return head;
		}
		ListNode firstListNode = new ListNode();// 用来保存头结点
		firstListNode.nextNode = head;// 添加在head的前边
		ListNode current = head;// 当前的结点
		ListNode pre = firstListNode;// 当前结点的前驱结点

		while (current != null && current.nextNode != null) {
			if (current.data == current.nextNode.data) {// 当前结点和next值相等
				int data = current.data;
				while (current != null && current.data == data) {
					current = current.nextNode;
				}
				pre.nextNode = current;
			} else {
				pre = current;
				current = current.nextNode;
			}
		}
		return firstListNode;
	}
}
