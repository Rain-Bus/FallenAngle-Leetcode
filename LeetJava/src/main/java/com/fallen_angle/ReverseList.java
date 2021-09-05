package com.fallen_angle;

import com.fallen_angle.structures.ListNode;

import java.util.LinkedList;

public class ReverseList {
	public static void main(String[] args) {
		ListNode testList = ListNode.generateListFromArr(new int[]{1,2,3,4,5});
		System.out.println(ListNode.traverseList(new ReverseListSolution().reverseListIterator(testList)));
	}
}

class ReverseListSolution {
	public ListNode reverseListRecursive(ListNode head) {
		if (head == null) return null;
		if (head.next == null) return head;
		ListNode last = reverseListRecursive(head.next);
		head.next.next = head;
		head.next = null;
		return last;
	}

	public ListNode reverseListIterator(ListNode head) {
		ListNode cur, pre, nxt;
		cur = head;
		pre = null;
		while (cur != null) {
			nxt = cur.next;
			cur.next = pre;
			pre = cur;
			cur = nxt;
		}
		return pre;
	}
}