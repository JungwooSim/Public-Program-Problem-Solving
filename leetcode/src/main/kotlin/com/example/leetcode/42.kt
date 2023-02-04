package com.example.leetcode

import java.lang.Integer.max

/*
42. Trapping Rain Water (https://leetcode.com/problems/trapping-rain-water/)

Given n non-negative integers representing an elevation map where the width of each bar is 1, compute how much water it can trap after raining.

 */

fun main() {
  val arr = intArrayOf(0,1,0,2,1,0,1,3,2,1,2,1)

  println(trap(arr))
}

fun trap(height: IntArray): Int {
  var result = 0
  var left = 0
  var right = height.size - 1
  var leftMax = height[left]
  var rightMax = height[right]

  while (left < right) {
    leftMax = max(leftMax, height[left])
    rightMax = max(rightMax, height[right])

    if (leftMax <= rightMax) {
      result += leftMax - height[left]
      println("LEFT : ${result} = ${leftMax} - ${height[left]}")
      left++
    } else {
      result += rightMax - height[right]
      println("RIGHT : ${result} = ${rightMax} - ${height[right]}")
      right--
    }
  }

  return result
}