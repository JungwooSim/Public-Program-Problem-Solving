package com.example.leetcode.findFirst

/*
34. Find First and Last Position of Element in Sorted Array

Given an array of integers nums sorted in non-decreasing order, find the starting and ending position of a given target value.
If target is not found in the array, return [-1, -1].
You must write an algorithm with O(log n) runtime complexity.

Example 1:
Input: nums = [5,7,7,8,8,10], target = 8
Output: [3,4]

Example 2:
Input: nums = [5,7,7,8,8,10], target = 6
Output: [-1,-1]

Example 3:
Input: nums = [], target = 0
Output: [-1,-1]

 */
fun main() {
  val input1 = intArrayOf(5,7,7,8,8,10)
  println(searchRange(input1, 8))
}

fun searchRange(nums: IntArray, target: Int): IntArray {
  val first = findFirst(nums, target)
  val last = findLast(nums, target)

  return intArrayOf(first, last)
}

fun findFirst(nums: IntArray, target: Int): Int {
  var low = 0
  var high = nums.size - 1

  while (low <= high) {
    val mid = low + (high - low) / 2
    if ((mid == 0 || nums[mid - 1] < target) && nums[mid] == target) {
      return mid
    } else if (target > nums[mid]) {
      low = mid + 1
    } else {
      high = mid - 1
    }
  }

  return -1
}

fun findLast(nums: IntArray, target: Int): Int {
  var low = 0
  var high = nums.size - 1

  while (low <= high) {
    val mid = low + (high - low) / 2
    if ((mid == nums.size - 1 || nums[mid + 1] > target) && nums[mid] == target) {
      return mid
    } else if (target < nums[mid]) {
      high = mid - 1
    } else {
      low = mid + 1
    }
  }

  return -1
}