package com.fallen_angle;

import com.fallen_angle.structures.TreeNode;

/*
226
 */

public class DeleteNodeBST {

}

class DeleteNodeBSTSolution {
	public TreeNode deleteNode(TreeNode root, int key) {
		if (root == null) {
			return null;
		}
		if (root.val < key) {
			root.right = deleteNode(root.right, key);
		} else if (root.val > key) {
			root.left = deleteNode(root.left, key);
		} else  {
			if (root.left == null) return root.right;
			if (root.right == null) return root.left;
			TreeNode cur = root.left;
			while (cur.right != null) {
				cur = cur.right;
			}
			root.val = cur.val;
			root.left = deleteNode(root.left, cur.val);
			return root;
		}
		return root;
	}
}