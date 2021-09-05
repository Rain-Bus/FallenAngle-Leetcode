package main

import (
	. "./structure"
	"fmt"
)

func main() {
	arr := []int{1, 2, 3, 4, 5}
	head := InitListByArr(arr...)
	//fmt.Println(TraverseToArray(reverseBetweenIterator(head, 1 ,5)))
	fmt.Println(TraverseToArray(reverseBetweenRecursion(head, 1, 4)))
}

/**
这是递归的题解
*/
func reverseBetweenRecursion(head *ListNode, left int, right int) *ListNode {
	if left == 1 {
		return reverseN(head, right-left+1)
	}
	// 将原来的头节点与反转部分的头节点连接起来
	head.Next = reverseBetweenRecursion(head.Next, left-1, right-1)
	return head
}

// 记录后驱，将反转后的尾部链接至后驱
var successor *ListNode

func reverseN(head *ListNode, n int) *ListNode {
	if n == 1 {
		successor = head.Next
		return head
	}
	last := reverseN(head.Next, n-1)
	head.Next.Next = head
	head.Next = successor
	return last
}

/**
这是自己的题解
*/
func reverseBetweenIterator(head *ListNode, left int, right int) *ListNode {
	index := 1
	cur := head
	var pre, nxt, leftLastNode, leftNode *ListNode
	for cur != nil && index <= right {
		nxt = cur.Next
		if index == left-1 { // 记录前驱
			leftLastNode = cur
		} else if index == left { // 记录反转后的尾节点，方便链接至后驱
			leftNode = cur
		} else if index > left && index <= right {
			cur.Next = pre
		}
		pre = cur
		cur = nxt
		index++
	}

	leftNode.Next = nxt // 链接至后驱
	if left == 1 {      // 若改变头节点，返回新的头结点
		head = pre
	} else {
		leftLastNode.Next = pre // 链接至前驱
	}
	return head
}

/*
官方题解：
穿针引线法：
使用虚拟头结点
先获取前驱节点和翻转左节点，然后再获取后继节点和翻转右节点，切断子链表的链接，然后翻转子链表，再接回原链表。

头插法：
记录前驱节点和左节点，然后将之后的每个节点接到前驱节点之后，直到右节点为止。
*/
