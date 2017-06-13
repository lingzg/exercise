package com.lingzg.question;

import java.util.ArrayList;
import java.util.Comparator;

import com.lingzg.node.BinaryTreeNode;

public class Q64 {

	/**
	 * 题目：数据流中的中位数 题目说明：如何得到一个数据流的中位数？如果从数据流中读取奇数个数值，那么中位数就是所有数值排序之后位于中间的数值。
	 * 如果从数据流中读取偶数个数值，那么中位数就是所有数值排序之后中间两个数的平均值。 解题思路：下面的代码主要描述了堆的相关操作，大顶堆和小顶堆。
	 */
	public static void main(String[] args) {
		DynamicArray array = new DynamicArray();
		BinaryTreeNode root = new BinaryTreeNode();
		root.value = 5;
		array.insert(root);
		System.out.println(array.getMedian());
	}

	private static class Heap<BinaryTreeNode> {
		private ArrayList<BinaryTreeNode> data;// 堆中元素存放的集合
		private Comparator<BinaryTreeNode> cmp;// 比较器

		public Heap(Comparator cmp) {// 构造函数比较器对象
			this.cmp = cmp;
			this.data = new ArrayList<BinaryTreeNode>(64);
		}

		public void shiftUp(int index) {// 向上调整，其中index是被移动的元素的起始位置
			if (index < 0 || index >= data.size()) {
				throw new IllegalArgumentException(index + "");
			}

			BinaryTreeNode intent = data.get(index);// 获取开始调整的元素对象

			while (index > 0) {
				int indexParent = (index - 1) / 2;// 找到要调整元素的父结点
				BinaryTreeNode parent = data.get(indexParent);// 父结点对象值
				// 比较当前结点和父结点的大小，如果当前结点大于父结点的对象值，则向上移动
				if (cmp.compare(intent, parent) > 0) {
					// 父结点下移，并记录其下移后的位置
					data.set(index, parent);
					index = indexParent;
				} else {// 当前结点小于父结点，不移动元素
					break;
				}
			}
			// 此处index记录的是最后一个被下放的父结点的位置，因此将最开始调整的元素值value放入到index的位置即可
			data.set(index, intent);
		}

		public void shiftDown(int index) {// 向下调整，其中index是被移动的元素的起始位置
			// 合法性判断，检查位置是否正确
			if (index < 0 || index >= data.size()) {
				throw new IllegalArgumentException(index + "");
			}

			BinaryTreeNode intent = data.get(index);// 获取调整元素的对象
			int leftIndex = 2 * index + 1;
			while (leftIndex < data.size()) {// 左子节点存在
				// 取左子节点的元素对象,假设左子节点为两个子结点的最大致
				BinaryTreeNode maxChild = data.get(leftIndex);
				// 子结点中最大元素的位置
				int maxIndex = leftIndex;

				int rightIndex = leftIndex + 1;// 右结点的位置
				if (rightIndex < data.size()) {// 如果右结点存在
					BinaryTreeNode rightChild = data.get(rightIndex);
					// 比较左右子结点的大小，将较大的元素存入到maxChild 中
					if (cmp.compare(rightChild, maxChild) > 0) {
						maxChild = rightChild;
						maxIndex = rightIndex;
					}
				}

				if (cmp.compare(maxChild, intent) > 0) {// 子结点中较大的元素比父结点的值要大
					// 将较大的结点向上移动
					data.set(index, maxChild);
					// 记录上移结点的位置
					index = maxIndex;
					// 上移结点的左子节点的位置
					leftIndex = 2 * index + 1;
				} else {// 最大节点不必父结点大，说明父子结点已经是从大到小排好序了
					break;
				}
			}
			// index记录的是最后一个被上移的子结点，将最开始调整的元素存入到index的位置即可
			data.set(index, intent);
		}

		public void add(BinaryTreeNode item) {
			data.add(item);// 添加到最后
			// 添加完后，上移，完成重构
			shiftUp(data.size() - 1);
		}

		public BinaryTreeNode deleteTop() {
			if (data.isEmpty())
				throw new RuntimeException("堆是空的！");

			// 获取堆顶元素
			BinaryTreeNode first = data.get(0);
			// 删除最后一个元素
			BinaryTreeNode last = data.remove(data.size() - 1);
			// 删除元素可能是堆顶元素且为最后一个元素
			if (data.size() == 0) {
				return last;
			} else {
				// 将删除的元素放入堆顶
				data.set(0, last);
				shiftDown(0);// 自上向下调整堆
				return first;// 返回堆顶元素
			}
		}

		public BinaryTreeNode getTop() {// 获取堆顶元素，但不删除
			// 如果堆已经为空，则抛出异常
			if (data.isEmpty()) {
				throw new RuntimeException("堆已经为空！");
			}
			return data.get(0);
		}

		public int size() {// 获取堆的大小
			return data.size();
		}

		public boolean isEmpty() {// 判断堆是否为空
			return data.isEmpty();
		}

		public void clear() {// 清空堆
			data.clear();
		}

		public ArrayList<BinaryTreeNode> getData() {// 获取堆中所有的数据
			return data;
		}
	}

	// 升序比较器
	private static class InoComparator implements Comparator<Integer> {
		@Override
		public int compare(Integer o1, Integer o2) {
			return o1 - o2;
		}
	}

	// 降序比较器
	private static class DescComparator implements Comparator<Integer> {
		@Override
		public int compare(Integer o1, Integer o2) {
			return o2 - o1;
		}
	}

	// 数据流
	private static class DynamicArray {
		private Heap<BinaryTreeNode> max;
		private Heap<BinaryTreeNode> min;

		public DynamicArray() {
			max = new Heap<BinaryTreeNode>(new InoComparator());// 大顶堆，存放小数的
			min = new Heap<BinaryTreeNode>(new DescComparator());// 小顶堆，存放大数的
		}

		// 插入数据
		public void insert(BinaryTreeNode node) {
			// 先判断堆中已经有的数据是不是偶数个,如果是偶数个，则将node添加到小顶堆中
			if ((min.size() + max.size()) % 2 == 0) {
				// 大堆中有数据，并且插入的元素比大堆中的元素小，则添加到大堆中
				if (max.size() > 0 && node.value < max.getTop().value) {
					max.add(node);
					// 删除堆顶元素，大堆中的最大元素
					node = max.deleteTop();
				}
				min.add(node);
			} else {// 两堆中的总数是奇数时，将数据插入到大堆中
					// 小堆中有数据，并且插入的元素比小堆中的元素大
				if (min.size() > 0 && node.value > min.getTop().value) {
					min.add(node);
					node = min.deleteTop();
				}
				max.add(node);

			}
		}

		public double getMedian() {// 获取中位数
			int size = max.size() + min.size();
			if (size == 0) {
				throw new RuntimeException("没有元素");
			}
			if ((size & 1) == 1) {// 奇数个元素
				return min.getTop().value;
			} else {
				return (max.getTop().value + min.getTop().value) / 2.0;
			}

		}
	}
}
