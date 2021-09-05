package com.fallen_angle.structures;

import java.util.*;

public class TreeNode {

    public static final String SEQUENCE = "seq";

    public int val;
    public TreeNode left;
    public TreeNode right;
    public TreeNode() {}
    public TreeNode(int val) { this.val = val; }
    public TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }

    public static TreeNode generateTree(Integer[] arr, String order) {
        TreeNode root;
        switch (order) {
            case SEQUENCE: root = generateTreeSequence(arr, 0); break;
            default: root = null;
        }
        return root;
    }

    public static List<Integer> traverseTree(TreeNode root, String order){
        result.clear();
        switch (order) {
            case SEQUENCE: return traverseTreeSequence(root);
            default: return null;
        }
    }

    static TreeNode generateTreeSequence(Integer[] arr, int index) {
        if (index >= arr.length) {
            return null;
        }
        TreeNode node = null;
        if (arr[index] != null){
            node = new TreeNode(arr[index]);
            node.left = generateTreeSequence(arr, 2*index+1);
            node.right = generateTreeSequence(arr, 2*index+2);
        }
        return node;
    }

    static List<Integer> result = new ArrayList<>();
    static List<Integer> traverseTreeSequence(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }
        Queue<TreeNode> levelNodes = new LinkedList<>();
        List<Integer> res = new ArrayList<>();
        levelNodes.offer(root);
        while (!levelNodes.isEmpty()) {
            int curLevelNum = levelNodes.size();
            for (int i = 0; i < curLevelNum; i++) {
                TreeNode curNode = levelNodes.poll();
                if (curNode == null) {
                    res.add(null);
                } else {
                    levelNodes.add(curNode.left);
                    levelNodes.add(curNode.right);
                    res.add(curNode.val);
                }
            }
        }
        while (true) {
            if (Objects.isNull(res.get(res.size() - 1))) {
                res.remove(res.size() - 1);
            } else {
                break;
            }
        }
        return res;
    }

}