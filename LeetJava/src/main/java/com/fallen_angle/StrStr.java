package com.fallen_angle;

public class StrStr {
	public static void main(String[] args) {
		System.out.println(new StrStrSolution().strStr("aaabaaabbbabaa","babb"));
	}
}


class StrStrSolution {
	public int strStr(String haystack, String needle) {
		int index = -1;
		if (needle.length() > haystack.length()) {
			return -1;
		}
		if (needle.length() == 0) {
			return 0;
		}
		int i = 0, j=0;
		char[] hayChars = haystack.toCharArray();
		char[] nedChars = needle.toCharArray();
		for (; i<haystack.length() - nedChars.length + 1; i++) {
			if (hayChars[i] == nedChars[0]) {
				for (; j<nedChars.length; j++) {
					if (hayChars[i + j] != nedChars[j]) {
						j = 0;
						break;
					}
				}
				if (j == needle.length()) {
					return i;
				}
			}
		}
		return -1;
	}
}