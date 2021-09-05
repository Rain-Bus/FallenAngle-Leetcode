package com.fallen_angle;

import com.fallen_angle.structures.TreeNode;

/**
98
 */
public class IsValidBST {
}

class IsValidBSTSolution {
	public boolean isValidBST(TreeNode root) {
		return isValidBTS(root, null, null);
	}

	// 使用辅助函数将根节点的限制传递到每个节点。
	public boolean isValidBTS(TreeNode root, TreeNode min, TreeNode max) {
		if (root == null) {
			return true;
		}
		if (max != null && root.val >= max.val) {
			return false;
		}
		if (min != null && root.val <= min.val) {
			return false;
		}
		return isValidBTS(root.left, min, root) && isValidBTS(root.right, root, max);
	}
}