package com.fallen_angle;

import com.fallen_angle.structures.TreeNode;

import java.util.Deque;
import java.util.LinkedList;
import java.util.TreeMap;


/**
 * 230
 */
public class KthSmallest {
	public static void main(String[] args) {
		TreeNode root = TreeNode.generateTree(new Integer[]{5,3,6,2,4,null,null,1}, TreeNode.SEQUENCE);
		new KthSmallestSolution().kthSmallest(root,3);
	}
}

class KthSmallestSolution {
	public int kthSmallest(TreeNode root, int k) {
		Deque<TreeNode> stack = new LinkedList<>();
		stack.add(root);
		int i = 0;
		while (!stack.isEmpty()) {
			if (stack.peek().left != null) {
				stack.push(stack.peek().left);
			} else {
				TreeNode cur;
				while ((cur = stack.pop()).right == null) {
					i++;
					if (i == k) {
						return cur.val;
					}
				}
				i++;
				if (i == k) {
					return cur.val;
				}
				stack.push(cur.right);
			}
		}
		return 0;
	}

	public int kthSmallestStack(TreeNode root, int k) {
		Deque<TreeNode> stack = new LinkedList<>();
		while (true) {
			while (root != null) {
				stack.push(root);
				root = root.left;
			}
			root = stack.pop();
			if (--k == 0) {
				return root.val;
			}
			root = root.right;
		}
	}
}

/*
也可以对二叉搜索树中序遍历然后直接取下标为k-1的数。
 */