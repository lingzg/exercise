package com.lingzg.question;

import java.util.LinkedList;
import java.util.Queue;

import com.lingzg.node.BinaryTreeNode;

public class Q60 {

	/**
	 * 题目：把二叉树打印成多行 题目说明：从上到下按层打印二叉树，同一层的结点按从左到右的顺序打印，每一层打印到一行。
	 * 解题思路：利用层次遍历算法，设置变量last指向当前层的最后一个结点，
	 * 设置变量count记录当前层已经访问的结点个数，当count和last相等时，表示该层访问结束。
	 */
	public static void main(String[] args) {
		BinaryTreeNode root = new BinaryTreeNode();
		BinaryTreeNode node1 = new BinaryTreeNode();
		BinaryTreeNode node2 = new BinaryTreeNode();
		BinaryTreeNode node3 = new BinaryTreeNode();
		BinaryTreeNode node4 = new BinaryTreeNode();
		BinaryTreeNode node5 = new BinaryTreeNode();
		BinaryTreeNode node6 = new BinaryTreeNode();

		root.leftNode = node1;
		root.rightNode = node2;
		node1.leftNode = node3;
		node1.rightNode = node4;
		node2.leftNode = node5;
		node2.rightNode = node6;

		root.value = 8;
		node1.value = 6;
		node2.value = 10;
		node3.value = 5;
		node4.value = 7;
		node5.value = 9;
		node6.value = 11;
		PrintBinaryTreeNode(root);
	}

	public static void PrintBinaryTreeNode(BinaryTreeNode root) {
		if (root == null) {
			return;
		}
		Queue<BinaryTreeNode> queue = new LinkedList<BinaryTreeNode>();
		queue.add(root);// 添加root到queue中
		int nextLevel = 0;
		int toBePrint = 1;

		while (!queue.isEmpty()) {
			BinaryTreeNode curNode = queue.peek();// peek()只是获取队列首元素
			System.out.print(curNode.value + " ");

			if (curNode.leftNode != null) {
				queue.add(curNode.leftNode);
				nextLevel++;
			}
			if (curNode.rightNode != null) {
				queue.add(curNode.rightNode);
				nextLevel++;
			}

			queue.poll();// 删除队列首元素
			toBePrint--;// 将要打印的元素数目减1
			if (toBePrint == 0) {
				System.out.println();
				toBePrint = nextLevel;
				nextLevel = 0;
			}
		}
	}
}
