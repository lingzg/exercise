package com.lingzg.question;

import com.lingzg.node.BinaryTreeNode;

public class Q62 {

	/**
	 * 题目：序列化二叉树 题目说明：请实现两个函数，分别用来序列化和反序列化二叉树。
	 * 解题思路：区分一下序列化和反序列化：把对象转换为字节序列的过程称为对象的序列化。把字节序列恢复为对象的过程称为对象的反序列化。
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
		Q62 test = new Q62();
		System.out.println(test.Serialize(root));
		// System.out.println();
		// String string = "1,2,4,$,$,$,3,5,$,$,6,$,$";
		test.Deserialize(test.Serialize(root));
	}

	public String Serialize(BinaryTreeNode root) {// 序列化，递归将对象转化为字节序列
		StringBuilder stringBuilder = new StringBuilder();
		if (root == null) {
			stringBuilder.append("$,");
			// System.out.print("$" + ",");
			return stringBuilder.toString();
		}
		// System.out.print(root.value + ",");
		stringBuilder.append(root.value + ",");
		stringBuilder.append(Serialize(root.leftNode));
		stringBuilder.append(Serialize(root.rightNode));
		return stringBuilder.toString();
	}

	int point = -1;

	public BinaryTreeNode Deserialize(String str) {// 反序列化，将字节序列转化为对象
		point++;
		if (point >= str.length()) {
			return null;
		}
		BinaryTreeNode node = null;
		String[] strArray = str.split(",");// 以逗号分隔形成数组
		if (!strArray[point].equals("$")) {
			node = new BinaryTreeNode();// 二叉树的结点对象
			node.value = Integer.valueOf(strArray[point]);// 将字符转化成value值
			node.leftNode = Deserialize(str);
			node.rightNode = Deserialize(str);
			System.out.print(node.value + ",");
		}
		return node;
	}
}
