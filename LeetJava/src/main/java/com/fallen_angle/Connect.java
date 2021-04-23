package com.fallen_angle;

import java.util.LinkedList;
import java.util.Queue;

public class Connect {
}

class ConnectSolution {
//	public Node connect(Node root) {
//		Queue<Node> levelNodes = new LinkedList<>();
//		levelNodes.offer(root);
//		while (!levelNodes.isEmpty()) {
//			int curLevelLength = levelNodes.size();
//			for (int i = 0; i < curLevelLength; i++) {
//				Node cur = levelNodes.poll();
//				if (i < curLevelLength - 1)
//				cur.next = levelNodes.peek();
//				if (cur.left != null) {
//					levelNodes.add(cur.left);
//					levelNodes.add(cur.right);
//				}
//			}
//		}
//		return root;
//	}

	public void connectTwoNode(Node node1 , Node node2) {
		if (node1 == null) return;
		node1.next = node2;
		connectTwoNode(node1.left, node1.right);
		connectTwoNode(node2.left, node2.right);
		connectTwoNode(node1.right, node2.left);
	}
}

class Node {
	public int val;
	public Node left;
	public Node right;
	public Node next;

	public Node() {
	}

	public Node(int _val) {
		val = _val;
	}

	public Node(int _val, Node _left, Node _right, Node _next) {
		val = _val;
		left = _left;
		right = _right;
		next = _next;
	}
}