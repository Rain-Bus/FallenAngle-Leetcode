package com.fallen_angle;

import java.util.PriorityQueue;

class MedianFinder {

	private PriorityQueue<Integer> large;
	private PriorityQueue<Integer> small;

	public MedianFinder() {
		large = new PriorityQueue<>();
		small = new PriorityQueue<>((a, b) -> b-a);
	}

	public void addNum(int num) {
		if (large.size() <= small.size()) {
			small.offer(num);
			large.offer(small.poll());
		} else {
			large.offer(num);
			small.offer(large.poll());
		}
	}

	public double findMedian() {
		if (small.size() < large.size()) {
			return large.peek();
		} else if (small.size() > large.size()) {
			return small.peek();
		} else {
			return (large.peek() + small.peek()) / 2.0;
		}
	}
}