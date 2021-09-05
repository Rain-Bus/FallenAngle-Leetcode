package com.fallen_angle;

import com.fallen_angle.structures.ListNode;

import java.util.List;

/**
 * 142
 */

public class DetectCycle {
}

class DetectCycleSolution {
	public ListNode detectCycle(ListNode head) {
		ListNode slow, fast;
		slow = fast = head;
		while (fast != null) {
			if (fast.next != null) {
				slow = slow.next;
				fast = fast.next.next;
			} else {
				return null;
			}
			if (fast == slow) {
				ListNode pre = head;
				while (pre != slow) {
					pre = pre.next;
					slow = slow.next;
				}
				return slow;
			}
		}
		return null;
	}
}