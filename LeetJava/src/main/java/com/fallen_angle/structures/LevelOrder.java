package com.fallen_angle.structures;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 102
 */
public class LevelOrder {

	public static void main(String[] args) {
		TreeNode root = TreeNode.generateTree(new Integer[]{1,2,3,4,5,6}, TreeNode.SEQUENCE);
		System.out.println(new LevelOrderSolution().levelOrder(root));
	}
}

class LevelOrderSolution {
	public List<List<Integer>> levelOrder(TreeNode root) {
		if (root == null) {
			return new ArrayList<>();
		}
		Queue<TreeNode> queue = new LinkedList<>();
		List<List<Integer>> result = new ArrayList<>();
		queue.add(root);
		while (!queue.isEmpty()) {
			int curNum = queue.size();
			List<Integer> curLevelVal = new ArrayList<>();
			for (int i = 0; i < curNum; i++) {
				TreeNode curNode = queue.remove();
				curLevelVal.add(curNode.val);
				if (curNode.left != null) {
					queue.add(curNode.left);
				}
				if (curNode.right != null) {
					queue.add(curNode.right);
				}
			}
			result.add(curLevelVal);
		}
		return result;
	}
}