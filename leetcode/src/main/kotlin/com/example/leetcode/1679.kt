package com.example.leetcode

/*
1679. Max Number of K-Sum Pairs (https://leetcode.com/problems/max-number-of-k-sum-pairs/?envType=study-plan-v2&envId=leetcode-75)

You are given an integer array nums and an integer k.
In one operation, you can pick two numbers from the array whose sum equals k and remove them from the array.
Return the maximum number of operations you can perform on the array.

Example 1:
Input: nums = [1,2,3,4], k = 5

Output: 2
Explanation: Starting with nums = [1,2,3,4]:
- Remove numbers 1 and 4, then nums = [2,3]
- Remove numbers 2 and 3, then nums = []
There are no more pairs that sum up to 5, hence a total of 2 operations.

Example 2:
Input: nums = [3,1,3,4,3], k = 6
Output: 1
Explanation: Starting with nums = [3,1,3,4,3]:
- Remove the first two 3's, then nums = [1,4,3]
There are no more pairs that sum up to 6, hence a total of 1 operation.

 */

fun main() {
	println(maxOperations(intArrayOf(1,2,3,4), 5))

	println(maxOperations(intArrayOf(3,1,3,4,3), 6))
}

fun maxOperations(nums: IntArray, k: Int): Int {
	nums.sort()

	var result = 0
	var left = 0
	var right = nums.size-1

	while (left < right) { // 여기조건에서 동일한 값이 남어오게되면 거르게 되어 있음
		var sum = nums[left] + nums[right]

		if (sum == k) {
			result++
			left++
			right--
		} else if (sum > k) {
			right--
		} else {
			left++
		}
	}

	return result
}