package com.example.leetcode

/*
53. Maximum Subarray (https://leetcode.com/problems/maximum-subarray/)
Given an integer array nums, find the subarray with the largest sum, and return its sum.

Example 1:
Input: nums = [-2,1,-3,4,-1,2,1,-5,4]
Output: 6
Explanation: The subarray [4,-1,2,1] has the largest sum 6.

Example 2:
Input: nums = [1]
Output: 1
Explanation: The subarray [1] has the largest sum 1.

Example 3:
Input: nums = [5,4,-1,7,8]
Output: 23
Explanation: The subarray [5,4,-1,7,8] has the largest sum 23.

Example 4:
Input: nums = [-1]
Output: -1

 */

fun main() {
  println(maxSubArray(intArrayOf(-2, 1, -3, 4, -1, 2, 1, -5, 4)))
  println(maxSubArray(intArrayOf(1)))
  println(maxSubArray(intArrayOf(5, 4, -1, 7, 8)))
  println(maxSubArray(intArrayOf(-1)))
}

fun maxSubArray(nums: IntArray): Int {
  var maxEndingHere = nums[0]
  var maxSoFar = nums[0]

  for (i in 1 until nums.size) {
    maxEndingHere = maxOf(nums[i], maxEndingHere + nums[i])
    maxSoFar = maxOf(maxSoFar, maxEndingHere)
  }

  return maxSoFar
}