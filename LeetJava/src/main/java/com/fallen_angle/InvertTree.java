package com.fallen_angle;

import com.fallen_angle.structures.TreeNode;

public class InvertTree {
	public static void main(String[] args) {
		TreeNode root = TreeNode.generateTree(new Integer[]{1,2,3,4,5,6,7,8,9}, TreeNode.SEQUENCE);
		System.out.println(TreeNode.traverseTree(root, TreeNode.SEQUENCE));
	}
}

class InvertTreeSolution {
	public TreeNode invertTree(TreeNode root) {
		if (root.left.left == null)	return root;
		invertTree(root.left);
		invertTree(root.right);
		TreeNode temp = root.left;
		root.left = root.right;
		root.right = temp;
		return root;
	}
}