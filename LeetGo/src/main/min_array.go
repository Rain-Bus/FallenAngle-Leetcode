package main

/**
剑指Offer11
 */
func minArray(numbers []int) int {
	if numbers[len(numbers) - 1] > numbers[0] {
		return numbers[0]
	}
	min := numbers[0]
	for _,ele := range numbers {
		if ele < min {
			return ele
		}
	}
	return min
}

func main() {
	println(minArrayBin([]int{2,2,2,0,1}))
}

func minArrayBin(numbers []int) int {
	low, high, mid := 0, len(numbers) - 1, len(numbers) >> 1
	for low < high {
		if numbers[mid] > numbers[low] {
			low = mid + 1
		} else if numbers[mid] < numbers[low] {
			high = mid
		} else {
			low++
		}
		mid = (low + high) >> 1
	}
	return numbers[mid]
}