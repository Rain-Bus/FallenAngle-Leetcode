package com.fallen_angle;

import java.util.Arrays;

public class Exchange {
	class Solution {
//		public int[] exchange(int[] nums) {
//			int leftIndex = 0, rightIndex = nums.length - 1;
//			while (leftIndex < rightIndex) {
//				while ((nums[leftIndex] & 2) != 0 && leftIndex < rightIndex) {
//					leftIndex++;
//				}
//				while ((nums[rightIndex] & 1) != 1 && leftIndex < rightIndex) {
//					rightIndex--;
//				}
//				if (leftIndex >= rightIndex) {
//					break;
//				}
//				int temp = nums[leftIndex];
//				nums[leftIndex] = nums[rightIndex];
//				nums[rightIndex] = temp;
//				leftIndex++;
//				rightIndex--;
//			}
//			return nums;
//		}
		public int[] exchange(int[] nums) {
			int low = 0, fast = 0;
			while (fast < nums.length) {
				if ((nums[fast] & 1) == 1) {
					int temp = nums[low];
					nums[low] = nums[fast];
					nums[fast] = temp;
					low++;
				}
				fast++;
			}
			return nums;
		}
	}
}
