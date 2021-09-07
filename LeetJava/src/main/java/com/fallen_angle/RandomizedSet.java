package com.fallen_angle;

import java.util.*;

class RandomizedSet {

	Map<Integer, Integer> VTI;
	List<Integer> values;

	public RandomizedSet() {
		VTI = new HashMap<>();
		values = new ArrayList<>();
	}

	public boolean insert(int val) {
		if (VTI.containsKey(val)) {
			return false;
		}
		VTI.put(val, VTI.size());
		values.add(val);
		return true;
	}

	public boolean remove(int val) {
		if (!VTI.containsKey(val)) {
			return false;
		}
		int index = VTI.remove(val);
		values.set(index, values.get(values.size() - 1));
		values.remove(values.size() - 1);
		if (index != values.size()) {
			VTI.put(values.get(index), index);
		}
		return true;
	}

	public int getRandom() {
		return values.get((int) (Math.random() * values.size()));
	}

	public static void main(String[] args) {
		RandomizedSet set = new RandomizedSet();
		set.insert(1);
		set.insert(1);
		set.insert(2);
		set.remove(1);
		set.remove(2);
	}
}