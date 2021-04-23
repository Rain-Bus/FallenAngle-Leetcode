package structure

type ListNode struct {
	Val  int
	Next *ListNode
}

func InitListByArr(arr ...int) *ListNode {
	var pre, cur, head *ListNode
	head = new(ListNode)
	cur = head
	for i := 0; i < len(arr); i++ {
		if i != 0 {
			cur = new(ListNode)
			pre.Next = cur
		}
		cur.Val = arr[i]
		pre = cur
	}
	return head
}

func TraverseToArray(head *ListNode) []int {
	cur := head
	var list []int
	for cur != nil {
		list = append(list, cur.Val)
		cur = cur.Next
	}
	return list
}
