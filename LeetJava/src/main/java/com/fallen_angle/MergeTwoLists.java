package com.fallen_angle;

import com.fallen_angle.structures.ListNode;

/**
 * 剑指 Offer 25
 */
public class MergeTwoLists {
	static class Solution {
		public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
			ListNode head = new ListNode(), cur = head;
			while (l1 != null && l2 != null) {
				if (l1.val < l2.val) {
					cur.next = l1;
					l1 = l1.next;
				} else {
					cur.next = l2;
					l2 = l2.next;
				}
				cur = cur.next;
			}
			cur.next = l1 != null ? l1 : l2;
			return head.next;
		}
	}

	public static void main(String[] args) {

		new Solution().mergeTwoLists(
				ListNode.generateListFromArr(new int[]{1,2,4}),
				ListNode.generateListFromArr(new int[]{1,3,4})
		);
	}
}
