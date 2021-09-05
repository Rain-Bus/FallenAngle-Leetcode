package com.fallen_angle;

public class ReplaceSpace {
	static class Solution {
		public String replaceSpace(String s) {
			StringBuilder builder = new StringBuilder();
			int blankIndex = 0;
			for (int index = 0; index < s.length(); index++) {
				if (s.charAt(index) == ' ') {
					builder.append(s.substring(blankIndex, index));
					builder.append("%20");
					blankIndex = index+1;
				}
			}
			builder.append(s.substring(blankIndex, s.length()));
			return builder.toString();
		}
	}

	public static void main(String[] args) {
		Solution solution = new Solution();
		System.out.println(solution.replaceSpace("sa is  a sa sa;"));
	}
}
