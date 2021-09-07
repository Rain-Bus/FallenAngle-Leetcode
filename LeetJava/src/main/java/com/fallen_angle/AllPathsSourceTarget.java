package com.fallen_angle;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 797
 */
public class AllPathsSourceTarget {
}

class AllPathsSourceTargetSolution {

	public List<List<Integer>> res = new ArrayList<>();

	public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
		List<Integer> path = new LinkedList<>();
		traverse(graph, 0, path);
		return res;
	}

	void traverse(int[][] graph, int s, List<Integer> path) {
		path.add(s);
		for (int i = 0; i < graph[s].length; i++) {
//			path.add(graph[s][i]);
			traverse(graph, graph[s][i], path);
		}
		res.add(path);
	}
}