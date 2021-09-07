package com.fallen_angle;

import java.util.*;

public class FreqStack {

	private Map<Integer, LinkedList<Integer>> FTK;
	private Map<Integer, Integer> KTF;
	private int maxFreq;

	public FreqStack() {
		FTK = new HashMap<>();
		KTF = new HashMap<>();
	}

	public void push(int val) {
		int freq = KTF.getOrDefault(val, 0) + 1;
		if (maxFreq < freq) {
			maxFreq = freq;
		}
		LinkedList<Integer> freqList = FTK.getOrDefault(freq, new LinkedList<>());
		freqList.offer(val);
		KTF.put(val, freq);
		FTK.put(freq, freqList);
		System.out.println(KTF);
	}

	public int pop() {
		Deque<Integer> freqList = FTK.get(maxFreq);
		int maxFreqVal = freqList.pop();
		if (freqList.isEmpty()) {
			FTK.remove(maxFreq);
			maxFreq--;
			KTF.put(maxFreqVal, maxFreq);
			return maxFreqVal;
		}
		KTF.put(maxFreqVal, maxFreq-1);
		return maxFreqVal;
	}
}