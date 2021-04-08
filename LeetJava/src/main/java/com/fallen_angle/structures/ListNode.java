package com.fallen_angle.structures;

import java.util.ArrayList;
import java.util.List;

public class ListNode {
    public int val;
    public ListNode next;
    public ListNode() {}
    public ListNode(int val) { this.val = val; }
    public ListNode(int val, ListNode next) { this.val = val; this.next = next; }

    public static ListNode generateListFromArr(int[] arr) {
    	ListNode head = new ListNode();
    	ListNode current = head;
    	ListNode last = null;
    	for (int value : arr) {
    		if (last != null) {
    			current = new ListNode();
    			last.next = current;
			}
    		current.val = value;
    		last = current;
		}
    	return head;
	}

	public static List<Integer> traverseList(ListNode head) {
		ListNode current = head;
		List<Integer> elem = new ArrayList<>();
		while (current != null) {
			elem.add(current.val);
			current = current.next;
		}
		return elem;
	}
}