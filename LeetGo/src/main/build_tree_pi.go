package main

import . "./structure"

/**
105
 */
func buildTreePIRecursive(preorder []int, inorder []int) *TreeNode {
	if len(preorder) == 0 {
		return nil
	}
	if len(preorder) == 1 {
		root := new(TreeNode)
		root.Val = preorder[0]
		return root
	}
	index := getIndex(inorder, preorder[0])
	root := new(TreeNode)
	root.Val = preorder[0]
	//var leftPre, rightPre, leftIn, rightIn []int
	//leftIn = inorder[0:index]
	//rightIn = inorder[index + 1: len(inorder)]
	//leftPre = preorder[1: index+1]
	//rightPre = preorder[index+1: len(preorder)]
	//root.Left = buildTreeIPRecursive(leftPre, leftIn)
	//root.Right = buildTreeIPRecursive(rightPre, rightIn)
	root.Left = buildTreeIPRecursive(preorder[1:index+1], inorder[0:index])
	root.Right = buildTreeIPRecursive(preorder[index+1:len(preorder)], inorder[index+1:len(inorder)])
	return root
}

func getIndexPI(arr []int, val int) int {
	for index, num := range arr {
		if num == val {
			return index
		}
	}
	return -1
}
