package com.fallen_angle;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Stack;

/**
 * 剑指 Offer 09
 */
public class CQueue {

	Deque<Integer> appendStack;
	Deque<Integer> popStack;

	public CQueue() {
		appendStack = new LinkedList<>();
		popStack = new LinkedList<>();
	}

	public void appendTail(int value) {
		appendStack.addFirst(value);
	}

	public int deleteHead() {
		if(popStack.isEmpty()) {
			transferElement();
		}
		if (popStack.isEmpty()) {
			return -1;
		}
		return popStack.removeFirst();
	}

	void transferElement() {
		while (!appendStack.isEmpty()) {
			popStack.addFirst(appendStack.removeFirst());
		}
	}

}
