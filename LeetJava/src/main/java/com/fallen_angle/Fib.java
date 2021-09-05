package com.fallen_angle;

public class Fib {
	static class Solution {
		public int fib(int n) {
			if (n == 0) {
				return 0;
			}
			if (n == 1 || n == 2) {
				return 1;
			}

			int prev = 1, curr = 1;

			for (int i = 3; i <= n; i++) {
				int sum = prev + curr;
				prev = curr;
				curr = sum % 1000000007;
			}

			return curr;
		}
	}

	public static void main(String[] args) {
		System.out.println(new Solution().fib(45));
	}
}
