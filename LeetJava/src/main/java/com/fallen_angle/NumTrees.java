package com.fallen_angle;

import java.util.HashMap;
import java.util.Map;

/**
 * 96
 */
public class NumTrees {
}

class NumTreesSolution {
	Map<Integer, Integer> note = new HashMap<>();
	public int numTrees(int n) {
		if(n == 1 || n == 0) return 1;
		int res = 0;
		if(note.get(n) != null) return note.get(n);
		for(int index = 1; index <= n; index ++) {
			res += numTrees(index - 1) * numTrees(n - index);
		}
		note.put(n, res);
		return res;
	}
}