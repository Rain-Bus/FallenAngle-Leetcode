package com.fallen_angle;

import com.fallen_angle.structures.TreeNode;

public class IsSymmetric {
	class Solution {
		public boolean isSymmetric(TreeNode root) {
			if (root == null) {
				return true;
			}
			return isSymmetric(root.left, root.right);
		}

		boolean isSymmetric(TreeNode left, TreeNode right) {
			if (left == null && right == null) {
				return true;
			} else if (left == null || right == null || left.val != right.val) {
				return false;
			}
			return isSymmetric(left.left, right.right) && isSymmetric(left.right, right.left);
		}
	}
}
