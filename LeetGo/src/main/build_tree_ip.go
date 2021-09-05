package main

import (
	. "./structure"
	"fmt"
)

/**
106
 */
func buildTreeIPRecursive(inorder []int, postorder []int) *TreeNode {
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
	node.Right = buildTreeIPRecursive(rightIn, rightPost)
	node.Left = buildTreeIPRecursive(leftIn, leftPost)
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

func buildTreeIPIterator(inorder []int, postorder []int) *TreeNode {
	if len(postorder) == 0 {
		return nil
	}
	root := &TreeNode{Val: postorder[len(postorder)-1]}
	stack := []*TreeNode{root}
	inIndex := len(inorder)-1
	for i := len(postorder)-2; i >= 0; i-- {
		cur := stack[len(stack)-1]
		if cur.Val != inorder[inIndex] {
			cur.Right = &TreeNode{Val: postorder[i]}
			stack = append(stack, cur.Right)
		} else {
			for len(stack) != 0 && stack[len(stack)-1].Val == inorder[inIndex] {
				cur = stack[len(stack)-1]
				stack = stack[:len(stack)-1]
				fmt.Println(cur.Val)
				inIndex--
			}
			cur.Left = &TreeNode{Val: postorder[i]}
			stack = append(stack, cur.Right)
		}
	}

	return root
}
