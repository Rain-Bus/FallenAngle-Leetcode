package com.fallen_angle;

import com.fallen_angle.structures.TreeNode;

/**
 * 700
 */
public class SearchBST {
}

class SearchBSTSolution {
	public TreeNode searchBST(TreeNode root, int val) {
		if (root == null) {
			return null;
		}
		if (root.val > val) return searchBST(root.left, val);
		if (root.val < val) return searchBST(root.right, val);
		return root;
	}
}