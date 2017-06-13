package com.lingzg.question;

import com.lingzg.node.BinaryTreeNode;

public class Q59 {

	/**
	 * 题目：对称的二叉树 题目说明：请实现一个函数，用来判断一棵二叉树是不是对称的。如果一棵二叉树和它的镜像一样，那么它就是对称的。
	 * 解题思路：要判断一棵二叉树是不是对称的，要先判断它的左右子树是不是对称的，如果对称则判断左子树的右结点和右子树的左结点是不是对称的，依次类推。
	 * 因此可以利用递归来实现。例如二叉树的一种遍历方式为前序遍历（根，左，右）则定义对称的遍历方式为对称前序遍历方式（根，右，左）
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
		node2.value = 6;
		node3.value = 5;
		node4.value = 7;
		node5.value = 7;
		node6.value = 5;

		System.out.println(isSymmetric(root));
	}

	public static boolean isSymmetric(BinaryTreeNode root) {
		return isSymmetrical(root, root);
	}

	public static boolean isSymmetrical(BinaryTreeNode root1, BinaryTreeNode root2) {
		if (root1 == null && root2 == null) {// 当根结点均为空时，二叉树对称
			return true;
		}
		if (root1 == null || root2 == null) {// 其中有一个为空，则不对称
			return false;
		}
		if (root1.value != root2.value) {// 两个结点都存在，如果值不同，则不对称
			return false;
		}

		return isSymmetrical(root1.leftNode, root2.rightNode) && isSymmetrical(root1.rightNode, root2.leftNode);// 递归左右子树进行比较
	}
}
