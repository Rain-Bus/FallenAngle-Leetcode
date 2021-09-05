package com.fallen_angle;

public class CoinChange {
	static class Solution {

		int[] minResult;

		public int coinChange(int[] coins, int amount) {
			minResult = new int[amount+1];
			if (amount < 0) {
				return -1;
			}
			if (amount == 0) {
				return 0;
			}

			if (minResult[amount] == 0) {

				int res = Integer.MAX_VALUE;

				for (int coin : coins) {
					int subProblem = coinChange(coins, amount - coin);
					if (subProblem == -1) {
						continue;
					}
					res = Math.min(res, 1 + subProblem);
				}
				minResult[amount] = res;
			} else {
				return minResult[amount];
			}

			return minResult[amount] == Integer.MAX_VALUE ? minResult[amount] : -1;

		}
	}

	public static void main(String[] args) {
		System.out.println(new Solution().coinChange(new int[]{1,3,5}, 9));
	}
}
