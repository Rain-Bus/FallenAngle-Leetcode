package com.fallen_angle;


import java.nio.channels.ByteChannel;

/**
 * 190
 */
public class ReverseBits {
	public static void main(String[] args) {
		System.out.println(new SolutionReverseBits().reverseBits(1000100101));
		System.out.println(new SolutionReverseBits().reverseBitsLogic(1000010101));
		System.out.println(new SolutionReverseBits().reverseBitsDivide(1));
		System.out.println(Integer.reverse(1));
	}
}


class SolutionReverseBits {
	// you need treat n as an unsigned value

	private static final int M1 = 0x55555555; // 01010101010101010101010101010101
	private static final int M2 = 0x33333333; // 00110011001100110011001100110011
	private static final int M4 = 0x0f0f0f0f; // 00001111000011110000111100001111
	private static final int M8 = 0x00ff00ff; // 00000000111111110000000011111111

	public int reverseBitsDivide(int n) {
		n = n >>> 1 & M1 | (n & M1) << 1;
		n = n >>> 2 & M2 | (n & M2) << 2;
		n = n >>> 4 & M4 | (n & M4) << 4;
		n = n >>> 8 & M8 | (n & M8) << 8;
		return n >>> 16 | n << 16;
	}

	public int reverseBits(int n) {
		int result = 0;
		int times = 31;
		int currentVal = n;
		for (; currentVal != 0 && times > 0; currentVal = currentVal >> 1, times--) {
			result = (result + currentVal % 2) << 1;
		}
		if (currentVal == -1) {
			return  (1 - result);
		}
		return result << times;
	}

	public int reverseBitsLogic(int n) {
		int res = 0;
		for (int i = 0; i < 32 && n != 0; ++i) {
			res |= (n & 1) << (31 - i);
			n >>>= 1;
		}
		return res;
	}
}