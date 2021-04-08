package com.fallen_angle;


import java.util.*;

public class SubsetsWithDup {
	public static void main(String[] args) {
		System.out.println(new SolutionSubsetsWithDup().subsetsWithDup(new int[]{3,2,4,1}));
	}
}


@Deprecated
class SolutionSubsetsWithDup {
	public List<List<Integer>> subsetsWithDup(int[] nums) {
		Map<Integer, Integer> countMap = new HashMap<>(10);
		for (int num: nums) {
			countMap.merge(num, 1, Integer::sum);
		}
		Integer[] keys = countMap.keySet().toArray(new Integer[0]);
		Integer[] values = countMap.values().toArray(new Integer[0]);
		int countValue = 1;
		for (int value: values) {
			countValue *= value + 1;
		}
		System.out.println(Arrays.toString(keys));
		System.out.println(Arrays.toString(values));
		int[] modArr = new int[keys.length];
		List<List<Integer>> result = new ArrayList<>();
		for (int i = 1; i < keys.length-1; i++) {
			modArr[i-1] = 1;
			for (int j = i; j < keys.length; j++) {
				modArr[i-1] *= values[j] + 1;
			}
		}
		if (modArr.length > 1) {
			modArr[modArr.length-2] = values[keys.length-1] + 1;
		}
		modArr[modArr.length-1] = 1;
		System.out.println(Arrays.toString(modArr));
		for (int i=0; i<countValue; i++) {
			List<Integer> resultList = new ArrayList<>();
			int value = i;
			for (int j=0; j<keys.length && value!=0; j++) {
				int eleNums = value/modArr[j];
				for (int eleNum=0; eleNum < eleNums; eleNum++) {
					resultList.add(keys[j]);
				}
				value = value % modArr[j];
			}
			System.out.println(i);
			System.out.println(resultList);
			result.add(resultList);
		}

		return result;
	}
}