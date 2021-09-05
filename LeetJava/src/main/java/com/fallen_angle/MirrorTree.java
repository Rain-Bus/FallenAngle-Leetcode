package com.fallen_angle;

import com.fallen_angle.structures.TreeNode;

/**
 * 剑指 Offer 27
 */
public class MirrorTree {
	class Solution {
		public TreeNode mirrorTree(TreeNode root) {
			if (root == null) return null;
			mirrorTree(root.left);
			mirrorTree(root.right);
			TreeNode temp;
			temp = root.left;
			root.left = root.right;
			root.right = temp;
			return root;
		}
	}
}
