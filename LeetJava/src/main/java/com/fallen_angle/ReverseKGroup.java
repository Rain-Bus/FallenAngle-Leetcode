package com.fallen_angle;

import com.fallen_angle.structures.ListNode;


/**
25
 */
public class ReverseKGroup {
	public static void main(String[] args) {
		ListNode list = ListNode.generateListFromArr(new int[]{1,2,3,4,5,6});
		System.out.println(ListNode.traverseList(new SolutionReverseKGroup().reverseKGroup(list, 3)));
	}
}


class SolutionReverseKGroup {
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