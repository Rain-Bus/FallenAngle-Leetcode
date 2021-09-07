package com.fallen_angle;

/**
 * 剑指 Offer 04
 */
public class FindNumberIn2DArray {
	public boolean findNumberIn2DArray(int[][] matrix, int target) {
		for (int[] row : matrix) {
			if (row.length > 0 && row[0] > target) {
				break;
			}
			for (int colOfRow: row) {
				if (colOfRow > target) {
					break;
				} else if (colOfRow == target) {
					return true;
				}
			}
		}
		return false;
	}
}

// 从右上开始查找，根据线性，可以排除部分数字