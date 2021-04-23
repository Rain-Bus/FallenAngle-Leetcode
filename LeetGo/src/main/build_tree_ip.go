package main

import . "./structure"

func buildTree(inorder []int, postorder []int) *TreeNode {
	length := len(postorder)
	if length == 0 {
		return nil
	} else if length == 1 {
		return &TreeNode{Val: postorder[0]}
	}
	inIndex := getIndex(inorder, postorder[length-1])
	node := new(TreeNode)
	node.Val = postorder[length-1]
	leftIn := inorder[0:inIndex]
	rightIn := inorder[inIndex+1 : length]
	leftPost := postorder[0:inIndex]
	rightPost := postorder[inIndex : length-1]
	node.Right = buildTree(rightIn, rightPost)
	node.Left = buildTree(leftIn, leftPost)
	return node
}

func getIndex(inorder []int, val int) int {
	for index, value := range inorder {
		if value == val {
			return index
		}
	}
	return -1
}
