package com.fallen_angle;

public class Search2DMatrix {
	public static void main(String[] args) {
		System.out.println(new SolutionSearch2DMatrix().searchMatrix(new int[][]{{1},{3},{5}}, 3));
	}
}

class SolutionSearch2DMatrix {
	public boolean searchMatrixTwoDivide(int[][] matrix, int target) {
		int rowLow = 0;
		int rowHigh = matrix.length - 1;
		int rowLocate = 0;
		while (rowLow <= rowHigh) {
			int rowMid = (rowLow + rowHigh) >> 1;
			if (matrix[rowMid][0] <= target) {
				rowLocate = rowMid;
				rowLow = rowMid + 1;
			} else {
				rowHigh = rowMid - 1;
			}
		}

		int colLow = 0;
		int colHigh = matrix[0].length - 1;
		int colLocate = 0;
		while (colLow <= colHigh) {
			int colMid = (colLow + colHigh) >> 1;
			if (matrix[rowLocate][colMid] <= target) {
				colLocate = colMid;
				colLow = colMid + 1;
			} else {
				colHigh = colMid -1;
			}
		}

		return matrix[rowLocate][colLocate] == target;
	}

	public boolean searchMatrix(int[][] matrix, int target) {
		int m = matrix.length;
		int n = matrix[0].length;
		int low = 0;
		int high = m * n - 1;
		while (low <= high) {
			int mid = (low + high) >> 1;
			if (matrix[mid/n][mid%n] < target) {
				low = mid + 1;
			} else if (matrix[mid/n][mid%n] > target) {
				high = mid - 1;
			} else {
				return true;
			}
		}
		return false;
	}
}