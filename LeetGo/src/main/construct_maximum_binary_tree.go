package main

import (
	. "./structure"
	"fmt"
)

//func constructMaximumBinaryTree(nums []int) *TreeNode {
//
//}

func main() {
	nums := []int{3, 2, 1, 6, 0, 5}
	nums1 := nums[3:4]
	fmt.Println(nums1)
	//constructMaximumBinaryTree(nums)
}

func constructMaximumBinaryTree(nums []int) *TreeNode {
	if len(nums) == 0 {
		return nil
	}
	maxIndex := findMaxIndex(nums)
	node := new(TreeNode)
	node.Val = nums[maxIndex]
	node.Left = constructMaximumBinaryTree(nums[0:maxIndex])
	node.Right = constructMaximumBinaryTree(nums[maxIndex+1 : len(nums)])
	return node
}

func findMaxIndex(nums []int) int {
	index := 0
	max := nums[0]
	for i := 1; i < len(nums); i++ {
		if nums[i] > max {
			index = i
			max = nums[i]
		}
	}
	return index
}
