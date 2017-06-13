package com.lingzg.question;

import com.lingzg.node.BinaryTreeNode;

public class Q63 {

	/**
	 * 题目：二叉搜索树的第K个结点 题目说明：给定一棵二叉搜索树，请找出其中的第K个大的结点。
	 * 解题思路：由于是二叉搜索树，因此中序遍历二叉树时，产生的序列是按照递增顺序排好序的，因此只需要找到第K个结点并访问就可以了。
	 */
	public static void main(String[] args) {
		BinaryTreeNode root = new BinaryTreeNode();
		BinaryTreeNode node1 = new BinaryTreeNode();
		BinaryTreeNode node2 = new BinaryTreeNode();
		BinaryTreeNode node3 = new BinaryTreeNode();
		BinaryTreeNode node4 = new BinaryTreeNode();
		BinaryTreeNode node5 = new BinaryTreeNode();
		root.leftNode = node1;
		root.rightNode = node2;
		node1.leftNode = node3;
		node2.leftNode = node4;
		node2.rightNode = node5;
		root.value = 1;
		node1.value = 2;
		node2.value = 3;
		node3.value = 4;
		node4.value = 5;
		node5.value = 6;
		Q63 test = new Q63();
		System.out.println(test.findKthNode(root, 3).value);
	}

	public BinaryTreeNode findKthNode(BinaryTreeNode root, int k) {
		if (root == null || k <= 0) {
			return null;
		}
		return findNode(root, k);
	}

	private BinaryTreeNode findNode(BinaryTreeNode root, int k) {
		BinaryTreeNode aimNode = null;// 用来返回第K个结点

		if (root.leftNode != null) {// 要中序遍历，必须从最左子结点开始遍历，此时K不变
			aimNode = findNode(root.leftNode, k);
		}
		if (aimNode == null) {// 最左子结点为空时，要判断k的值
			if (k == 1) {// k=1时递归结束，保存该结点
				aimNode = root;
			}
			k--;
		}
		if (aimNode == null && root.rightNode != null) {// 查找右子树的结点值
			aimNode = findNode(root.rightNode, k);
		}
		return aimNode;
	}
}
