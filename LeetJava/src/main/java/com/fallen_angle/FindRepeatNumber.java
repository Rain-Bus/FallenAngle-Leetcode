package com.fallen_angle;

import java.util.HashSet;

/**
 * 剑指 Offer 03
 */
public class FindRepeatNumber {
	public int findRepeatNumber(int[] nums) {
		HashSet<Integer> hashSet = new HashSet<>();
		for (int num: nums) {
			if (!hashSet.add(num)) {
				return num;
			}
		}
		return -1;
	}
}
