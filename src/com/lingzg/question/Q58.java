package com.lingzg.question;

import com.lingzg.node.BinaryTreeNode;

public class Q58 {

	/**
	 * 题目：二叉树的下一个结点
	 * 题目说明：给定一棵二叉树和其中一个结点，如何找出中序遍历顺序的下一个结点？树中的结点除了有两个分别指向左右子结点的指针外，
	 * 还有一个指向父结点的指针。 解题思路：首先要明确中序遍历的过程，先左子节点，再根结点，最后是右子树结点。
	 * 1）如果如果一个结点有右子树，那么它的下一个结点就是右子树的最左子结点；
	 * 2）如果结点是它父结点的左子结点，并且父结点没有右子结点，那么下一个结点就是这个结点的父结点；
	 * 3）如果一个结点即没有右子树，并且它还是它父结点的右子树结点。则沿着指向父结点的指针一直向上遍历，直到找到一个结点是某一个结点的左子节点，
	 * 这个某一点就是下一个要遍历的结点。
	 */
	public BinaryTreeNode getNexTreeNode(BinaryTreeNode root, BinaryTreeNode randomTreeNode) {
		if (root == null) {
			return null;
		}
		BinaryTreeNode nextTreeNode = null;// 保存下一个要访问的结点
		if (randomTreeNode.rightNode != null) {// 一个结点的右子树不为空，则下一个要访问的结点就是，右子树的最左子树结点
			BinaryTreeNode nextRightNode = new BinaryTreeNode();

			while (nextRightNode.leftNode != null) {// 右子树的左子结点不为空，则继续遍历
				nextRightNode = nextRightNode.leftNode;
			}

			nextTreeNode = nextRightNode;// 下一个要访问的就是右子树的最左子结点
		} else if (randomTreeNode.parentNode != null) {// randomTreeNode该结点的右子树为空，但是父结点不为空

			BinaryTreeNode currentNode = randomTreeNode;
			BinaryTreeNode parent = randomTreeNode.parentNode;

			while (parent != null && currentNode == parent.rightNode) {// 保证父结点存在，且父结点的右子树是当前结点，
				// 目的是寻找，父结点是某一个结点的左子结点
				currentNode = parent;
				parent = currentNode.parentNode;
			}
			nextTreeNode = parent;
		}
		return nextTreeNode;
	}
}
