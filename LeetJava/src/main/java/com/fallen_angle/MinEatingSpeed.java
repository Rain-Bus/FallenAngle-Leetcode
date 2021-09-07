package com.fallen_angle;

import java.util.Arrays;

public class MinEatingSpeed {
}

class MinEatingSpeedSolution {
	public int minEatingSpeed(int[] piles, int h) {
		int sum = 0;
		for (int pile: piles) {
			sum += pile;
		}
		int fast = sum / h;
		int slow = 1;
		int mid = (fast + slow) >> 1;
		while (fast > slow) {
			int hours = 0;
			for (int pile: piles) {
				hours += (pile / mid) + (pile % mid) == 0 ? 0 : 1;
			}
			if (hours <= h) {
				fast = mid - 1;
			} else {
				slow = mid + 1;
			}
		}
		return slow;
	}
}