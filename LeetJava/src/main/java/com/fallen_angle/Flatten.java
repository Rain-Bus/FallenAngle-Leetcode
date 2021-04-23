package com.fallen_angle;

import com.fallen_angle.structures.TreeNode;
import sun.reflect.generics.tree.Tree;

import java.util.TreeMap;

public class Flatten {

	public static void main(String[] args) {
		TreeNode root = TreeNode.generateTree(new Integer[]{1,2,5,3,4,null,6}, TreeNode.SEQUENCE);
		new FlattenSolution().flatten(root);
		System.out.println(root);
	}
}


class FlattenSolution {
	public void flatten(TreeNode root) {
		if (root == null) return;
		flatten(root.left);
		flatten(root.right);

		TreeNode left = root.left;
		TreeNode right = root.right;
		TreeNode cur = root;

		// 将左节点反转至右节点。
		root.left = null;
		root.right = left;

		// 将原来的右子树接至当前右子树，末端。
		while (cur.right != null) {
			cur = cur.right;
		}
		cur.right = right;
	}
}

/*
LeetCode 题解
1. 先对树进行先序遍历，然后将先序遍历的结果再重新整合成一个树。
2. 我们也可以边遍，边展开，但是，这样的话会导致当前节点本来有的右节点会被覆盖掉。
	我们可以通过记录上一个节点，从而防止被覆盖的情况。
 */