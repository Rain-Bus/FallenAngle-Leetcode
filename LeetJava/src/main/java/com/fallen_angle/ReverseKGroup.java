package com.fallen_angle;

import com.fallen_angle.structures.ListNode;


/**
25
 */
public class ReverseKGroup {
	public static void main(String[] args) {
		ListNode list = ListNode.generateListFromArr(new int[]{1,2,3,4,5,6});
		System.out.println(ListNode.traverseList(new SolutionReverseKGroup().reverseKGroup(list, 2)));
	}
}


class SolutionReverseKGroupTemp {
	public ListNode reverseKGroup(ListNode head, int k) {
		if (k == 1) {
			return head;
		}
		boolean finishFlag = false;
		boolean firstFlag = true;
		ListNode frontNode = head;
		ListNode endNode = head;
		ListNode lastEndNode = null;
		while (!finishFlag) {
			int i;
			for (i = 0; i < k && frontNode != null; i++, frontNode = frontNode.next);
			if (i < k) break;
			ListNode nextNode = endNode.next;
			ListNode lastNode = frontNode;
			ListNode firstNode = endNode;

			for (i = 0; i < k; i++) {
				endNode.next = lastNode;
				lastNode = endNode;
				endNode = nextNode;
				nextNode = nextNode.next;
			}

			if (firstFlag) {
				head = lastNode;
				firstFlag = false;
			} else {
				lastEndNode.next = lastNode;
			}

			lastEndNode = firstNode;
		}
		return head;
	}
}

class SolutionReverseKGroup {

	ListNode a, b;

	public ListNode reverseKGroup(ListNode head, int k) {
		if (head == null)	return null;
		a = b = head;
		for (int i = 0; i < k; i++) {
			if (b == null)  return head;
			b = b.next;
		}
		ListNode newHead = reverseGroup(a, k);
		a.next = reverseKGroup(b, k);
		return newHead;
	}

	ListNode successor = null;

	ListNode reverseGroup(ListNode head, int n) {
		if (n == 1) {
			successor = head.next;
			return head;
		}
		ListNode last = reverseGroup(head.next, n-1);
		head.next.next = head;
		head.next = successor;
		return last;
	}
}