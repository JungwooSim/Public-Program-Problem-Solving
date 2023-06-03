package com.example.leetcode

/*
643. Maximum Average Subarray I

You are given an integer array nums consisting of n elements, and an integer k.
Find a contiguous subarray whose length is equal to k that has the maximum average value and return this value.
Any answer with a calculation error less than 10-5 will be accepted.

Example 1:
Input: nums = [1,12,-5,-6,50,3], k = 4
Output: 12.75000
Explanation: Maximum average is (12 - 5 - 6 + 50) / 4 = 51 / 4 = 12.75

Example 2:
Input: nums = [5], k = 1
Output: 5.00000

 */

fun main() {
	println(
		findMaxAverage(
			intArrayOf(1,12,-5,-6,50,3),
			4
		)
	)

	println(
		findMaxAverage(
			intArrayOf(5),
			1
		)
	)

}

fun findMaxAverage(nums: IntArray, k: Int): Double {
	var totalSum = nums.slice(0 until k).sum() // 0 ~ K 까지 합
	var maxAverage = totalSum.toDouble() / k.toDouble()

	for (i in k until nums.size) {
		totalSum += nums[i] - nums[i-k]
		maxAverage = maxOf(maxAverage, totalSum.toDouble() / k.toDouble())
	}

	return maxAverage
}