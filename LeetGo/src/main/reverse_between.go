package main

import (
	. "./strcuture"
	"fmt"
)

func main() {
	arr := []int{1,2,3,4,5}
	head := InitListByArr(arr...)
	fmt.Println(TraverseToArray(reverseBetweenIterator(head, 1 ,5)))
}


/**
Mine answer

 */
func reverseBetweenIterator(head *ListNode, left int, right int) *ListNode {
	index := 1
	cur := head
	var pre, nxt, leftLastNode, leftNode *ListNode
	for cur != nil && index <= right {
		nxt = cur.Next
		if index == left - 1 {
			leftLastNode = cur
		} else if index == left {
			leftNode = cur
		} else if index > left && index <= right {
			cur.Next = pre
		}
		pre = cur
		cur = nxt
		index++
	}

	leftNode.Next = nxt
	if left == 1 {
		head = pre
	} else {
		leftLastNode.Next = pre
	}
	return head
}