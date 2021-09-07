package main

// LFUCache 460/
type LFUCache struct {
	minFreq, size, capacity int
	KTV, KTF                map[int]int
	FTK                     map[int][]int
}

func Constructor(capacity int) LFUCache {
	return LFUCache{KTF: map[int]int{}, KTV: map[int]int{}, FTK: map[int][]int{}, minFreq: 0, size: 0, capacity: capacity}
}

func (this *LFUCache) Get(key int) int {
	if val, ok := this.KTV[key]; ok {
		this.increaseFreq(key)
		return val
	}
	return -1
}

func (this *LFUCache) Put(key int, value int) {
	if this.capacity == 0 {
		return
	}
	if _, ok := this.KTV[key]; ok {
		this.KTV[key] = value
		this.increaseFreq(key)
		return
	} else if this.capacity <= this.size {
		this.remove(this.FTK[this.minFreq][0])
	}
	this.add(key, value)
}

func (this *LFUCache) add(key, val int) {
	this.KTV[key] = val
	this.KTF[key] = 1
	this.moveFTK(0, key)
	this.minFreq = 1
	this.size++
}

func (this *LFUCache) remove(key int) {
	delete(this.KTV, key)
	freq := this.KTF[key]
	delete(this.KTF, key)
	this.deleteFTK(freq, key)
	if len(this.FTK[freq]) == 0 {
		delete(this.FTK, freq)
	}
}

func (this *LFUCache) increaseFreq(key int) {
	freq := this.KTF[key]
	this.KTF[key]++
	this.moveFTK(freq, key)
	this.deleteFTK(freq, key)
	if len(this.FTK[freq]) == 0 {
		delete(this.FTK, freq)
		if this.minFreq == freq {
			this.minFreq = freq + 1
		}
	}
}

func (this *LFUCache) moveFTK(freq, key int) {
	if val, ok := this.FTK[freq+1]; ok {
		this.FTK[freq+1] = append(val, key)
	} else {
		this.FTK[freq+1] = []int{key}
	}
}

func (this *LFUCache) deleteFTK(freq, key int)  {
	keyIndex := findIndex(this.FTK[freq], key)
	this.FTK[freq] = append(this.FTK[freq][:keyIndex], this.FTK[freq][keyIndex+1:]...)
}

func findIndex(arr []int, target int) int {
	for index, val := range arr {
		if val == target {
			return index
		}
	}
	return -1
}

func main() {
	lfu := Constructor(2)
	lfu.Put(2,1)
	lfu.Put(2,2)
	lfu.Get(2)
	lfu.Put(1,1)
	lfu.Put(4,1)
	lfu.Get(2)
}

/*
如果想进一步优化性能，可以使用LinkedHashSet
 */