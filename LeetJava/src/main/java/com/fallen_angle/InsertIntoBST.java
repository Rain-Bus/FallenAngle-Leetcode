package com.fallen_angle;

import com.fallen_angle.structures.TreeNode;

public class InsertIntoBST {
}

class InsertIntoBSTSolution {
	public TreeNode insertIntoBST(TreeNode root, int val) {
		if (root == null)	return new TreeNode(val);
		if (root.val > val)	root.left = insertIntoBST(root.left, val);
		if (root.val < val)	root.right = insertIntoBST(root.right, val);
		return root;
	}
}