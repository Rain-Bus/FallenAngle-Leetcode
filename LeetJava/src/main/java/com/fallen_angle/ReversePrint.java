package com.fallen_angle;

import com.fallen_angle.structures.ListNode;

public class ReversePrint {
	class Solution {
		public int[] reversePrint(ListNode head) {
			int count = 0;
			ListNode countNode = head;
			while (countNode != null) {
				count++;
				countNode = countNode.next;
			}

			int[] reverse = new int[count];
			for (int i = count-1; i >=0; i--) {
				reverse[i] = head.val;
				head = head.next;
			}
			return reverse;
		}
	}
}
