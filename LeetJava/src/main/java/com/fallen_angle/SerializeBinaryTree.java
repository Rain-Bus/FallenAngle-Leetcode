package com.fallen_angle;

import com.fallen_angle.structures.TreeNode;

import java.util.Arrays;

public class SerializeBinaryTree {

	String treeSerialize = "";

	// Encodes a tree to a single string.
	public String serialize(TreeNode root) {
		treeSerialize += ",";
		if (root == null) {
			treeSerialize += "#";
			return treeSerialize;
		}
		treeSerialize += root.val;
		serialize(root.left);
		serialize(root.right);
		return treeSerialize;
	}

	// Decodes your encoded data to tree.
	public TreeNode deserialize(String data) {
		return deserialize(data.split(","));
	}

	int index;

	public TreeNode deserialize(String[] data) {
		index++;
		if (index >= data.length) {
			return null;
		}
		if ("#".equals(data[index])) {
			return null;
		}
		TreeNode root = new TreeNode(Integer.parseInt(data[index]));
		root.left = deserialize(data);
		root.right = deserialize(data);
		return root;
	}
	public static void main(String[] args) {
		TreeNode root = TreeNode.generateTree(new Integer[]{1,2,3,4}, TreeNode.SEQUENCE);
		System.out.println(Arrays.toString(new SerializeBinaryTree().serialize(root).split(",")));
	}
}
