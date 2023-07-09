package com.example.leetcode

import java.util.*

/*
215. Kth Largest Element in an Array (https://leetcode.com/problems/kth-largest-element-in-an-array/description/?envType=study-plan-v2&envId=leetcode-75)
(medium)

Given an integer array nums and an integer k, return the kth largest element in the array.
Note that it is the kth largest element in the sorted order, not the kth distinct element.
Can you solve it without sorting?

Example 1:
Input: nums = [3,2,1,5,6,4], k = 2
Output: 5

Example 2:
Input: nums = [3,2,3,1,2,4,5,5,6], k = 4
Output: 4

 */

fun main() {
	println(findKthLargest(intArrayOf(3,2,1,5,6,4), 2))

	println(findKthLargest(intArrayOf(3,2,3,1,2,4,5,5,6), 4))
}

fun findKthLargest(nums: IntArray, k: Int): Int {
	val PQ = PriorityQueue<Int>()

	nums.forEach {
		PQ.add(it)
		if (PQ.size > k) PQ.poll()
	}

	return PQ.peek()
}