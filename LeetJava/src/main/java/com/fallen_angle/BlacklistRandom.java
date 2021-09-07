package com.fallen_angle;

import java.security.SecureRandom;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class BlacklistRandom {
	int[] arr;
	Map<Integer, Integer> map;
	int size;
	Random random = new Random();

	public BlacklistRandom(int n, int[] blacklist) {
		size = n - blacklist.length;
		int last = n -1;
		map = new HashMap<>();
		for (int b: blacklist) {
			map.put(b, 1);
		}
		for (int b: blacklist) {
			if(b >= size) {
				continue;
			}
			while (map.containsKey(last)) {
				last--;
			}
			map.put(b, last);
			last--;
		}
	}

	public int pick() {
		int index = random.nextInt(size);
		return arr[map.getOrDefault(index, index)];
	}
}
