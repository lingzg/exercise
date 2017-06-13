package com.lingzg.question;

import java.util.Stack;

import com.lingzg.node.BinaryTreeNode;

public class Q61 {

	/**
	 * 题目：按之字形顺序打印二叉树 题目说明：请实现一个函数按照之字形顺序打印二叉树，
	 * 即第一行按照从左到右的顺序打印，第二层按照从右到左的顺序打印，第三行再按照从左到右的顺序打印，依次类推。
	 * 解题思路：要使用两个栈交替操作来实现打印之字形二叉树，两个栈的入栈顺序恰好相反，
	 * stack1的入栈顺序是从左到右，stack2是从右到左。出栈时恰好出现之字形顺序。
	 */
	public static void main(String[] args) {
		BinaryTreeNode root = new BinaryTreeNode();
		BinaryTreeNode node1 = new BinaryTreeNode();
		BinaryTreeNode node2 = new BinaryTreeNode();
		BinaryTreeNode node3 = new BinaryTreeNode();
		BinaryTreeNode node4 = new BinaryTreeNode();
		BinaryTreeNode node5 = new BinaryTreeNode();
		BinaryTreeNode node6 = new BinaryTreeNode();
		BinaryTreeNode node7 = new BinaryTreeNode();
		BinaryTreeNode node8 = new BinaryTreeNode();
		root.leftNode = node1;
		root.rightNode = node2;
		node1.leftNode = node3;
		node1.rightNode = node4;
		node2.leftNode = node5;
		node2.rightNode = node6;
		node3.leftNode = node7;
		node3.rightNode = node8;
		root.value = 1;
		node1.value = 2;
		node2.value = 3;
		node3.value = 4;
		node4.value = 5;
		node5.value = 6;
		node6.value = 7;
		node7.value = 8;
		node8.value = 9;
		Q61 test = new Q61();
		test.PrintBinaryTree(root);
	}

	public void PrintBinaryTree(BinaryTreeNode root) {
		if (root == null) {
			return;
		}
		Stack<BinaryTreeNode> stack1 = new Stack<BinaryTreeNode>();// 存放奇数行
		Stack<BinaryTreeNode> stack2 = new Stack<BinaryTreeNode>();// 存放偶数行
		stack2.push(root);// 记得根结点入stack2中，否则会出现奇数行和偶数行交错一行
		while (stack1.isEmpty() || stack2.isEmpty()) {
			if (stack1.isEmpty() && stack2.isEmpty()) {
				break;
			}
			if (stack2.isEmpty()) {
				while (!stack1.isEmpty()) {// stack1不为空，则出栈并将它的孩子结点从右到左存入到stack2中
					if (stack1.peek().rightNode != null) {
						stack2.push(stack1.peek().rightNode);
					}
					if (stack1.peek().leftNode != null) {
						stack2.push(stack1.peek().leftNode);
					}
					System.out.print(stack1.pop().value + " ");
				}
				System.out.println();
			} else {
				while (!stack2.isEmpty()) {// stack2不为空，则出栈并将它的孩子结点从左到右存入到stack1中
					if (stack2.peek().leftNode != null) {
						// temp.add(stack2.peek().leftNode.value);
						stack1.push(stack2.peek().leftNode);
					}
					if (stack2.peek().rightNode != null) {
						// temp.add(stack2.peek().rightNode.value);
						stack1.push(stack2.peek().rightNode);
					}
					System.out.print(stack2.pop().value + " ");
				}
				System.out.println();
			}
		}
	}
}
