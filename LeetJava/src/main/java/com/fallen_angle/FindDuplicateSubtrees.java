package com.fallen_angle;

import com.fallen_angle.structures.TreeNode;

import java.util.*;

/*
652
 */

public class FindDuplicateSubtrees {
}

class FindDuplicateSubtreesSolution {

	Map<String, Integer> count = new HashMap<>();
	List<TreeNode> nodes = new ArrayList<>();

	public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
		traverseTreeVal(root);
		return nodes;
	}

	public String traverseTreeVal(TreeNode root) {
		if (root == null) {
			return "#";
		}
		String resStr = root.val + "," + traverseTreeVal(root.left) + "," + traverseTreeVal(root.right);
		count.put(resStr, count.getOrDefault(resStr, 0)+1);
		if (count.get(resStr) == 2) {
			nodes.add(root);
		}

		return resStr;
	}
}