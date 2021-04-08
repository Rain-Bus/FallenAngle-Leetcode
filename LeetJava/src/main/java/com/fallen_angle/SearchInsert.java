package com.fallen_angle;

/**
 * 35
 */
public class SearchInsert {
	public static void main(String[] args)  {
		int[] nums = new int[]{1,3,5,6};
		System.out.println(new SolutionSearchInsert().searchInsert(nums, 7));
	}
}

class SolutionSearchInsert {
	public int searchInsert(int[] nums, int target) {
		int low = 0, high = nums.length-1;
		int result = nums.length;
		while (low <= high) {
			int mid = (low + (high-low >> 1));
			if (target <= nums[mid]) {
				result = mid;
				high = mid - 1;
			} else {
				low = mid + 1;
			}
		}
		return result;
	}
}