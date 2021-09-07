package main

// LRUCache  146/
type LRUCache struct {
	capacity, size int
	cache          map[int]*DLinkNode
	head, tail     *DLinkNode
}

type DLinkNode struct {
	key, val   int
	prev, next *DLinkNode
}

func initDLinkNode(key, val int) *DLinkNode {
	return &DLinkNode{key: key, val: val}
}

func (this *LRUCache) Constructor(capacity int) LRUCache {
	lru := LRUCache{
		size:     0,
		capacity: capacity,
		head:     initDLinkNode(0, 0),
		tail:     initDLinkNode(0, 0),
		cache:    map[int]*DLinkNode{},
	}
	lru.head.next = lru.tail
	lru.tail.prev = lru.head
	return lru
}

func (this *LRUCache) Get(key int) int {
	if this.cache[key] != nil {
		return this.moveToRecent(key)
	}
	return -1
}

func (this *LRUCache) Put(key int, value int) {
	if node, ok := this.cache[key]; ok {
		node.val = value
		this.moveToRecent(key)
		return
	} else if this.capacity <= this.size {
		this.remove(this.head.next.key)
	}
	this.add(key, value)
}

func (this *LRUCache) remove(key int) {
	node := this.cache[key]
	delete(this.cache, key)
	this.deleteDLinkNode(node)
}

func (this *LRUCache) add(key, val int) {
	node := initDLinkNode(key, val)
	this.addDLinkNode(node)
	this.cache[key] = node
	this.size++
}

func (this *LRUCache) moveToRecent(key int) int {
	node := this.cache[key]
	this.deleteDLinkNode(node)
	this.addDLinkNode(node)
	return node.val
}

func (this *LRUCache) deleteDLinkNode(node *DLinkNode) {
	node.prev.next = node.next
	node.next.prev = node.prev
}

func (this *LRUCache) addDLinkNode(node *DLinkNode) {
	node.next = this.tail
	node.prev = this.tail.prev
	this.tail.prev.next = node
	this.tail.prev = node
}

func (this *LRUCache) main() {
	lru := this.Constructor(2)
	lru.Put(1,0)
	lru.Put(2,2)
	lru.Get(1)
	lru.Put(3,3)
	lru.Get(2)
	lru.Put(4,4)
	lru.Get(1)
	lru.Get(3)
	lru.Get(4)
}