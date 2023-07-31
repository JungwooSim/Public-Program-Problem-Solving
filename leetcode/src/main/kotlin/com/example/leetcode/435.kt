package com.example.leetcode

/*
435. Non-overlapping Intervals (https://leetcode.com/problems/non-overlapping-intervals/description/)
Medium

Given an array of intervals intervals where intervals[i] = [starti, endi], return the minimum number of intervals you need to remove to make the rest of the intervals non-overlapping.

Example 1:
Input: intervals = [[1,2],[2,3],[3,4],[1,3]]
Output: 1
Explanation: [1,3] can be removed and the rest of the intervals are non-overlapping.

Example 2:
Input: intervals = [[1,2],[1,2],[1,2]]
Output: 2
Explanation: You need to remove two [1,2] to make the rest of the intervals non-overlapping.

Example 3:
Input: intervals = [[1,2],[2,3]]
Output: 0
Explanation: You don't need to remove any of the intervals since they're already non-overlapping.
 */

fun main() {
  println(
    eraseOverlapIntervals(
      arrayOf(
        intArrayOf(1, 2),
        intArrayOf(2, 3),
        intArrayOf(3, 4),
        intArrayOf(1, 3),
      )
    )
  )

  println(
    eraseOverlapIntervals(
      arrayOf(
        intArrayOf(1, 2),
        intArrayOf(1, 2),
        intArrayOf(1, 2),
      )
    )
  )
//
  println(
    eraseOverlapIntervals(
      arrayOf(
        intArrayOf(1, 2),
        intArrayOf(2, 3),
      )
    )
  )
}

fun eraseOverlapIntervals(intervals: Array<IntArray>): Int {
  intervals.sortBy { it[1] } // end 값을 기준으로 오름차순

  var count = 1
  var prevEnd = intervals[0][1]

  for (i in 1 until intervals.size) {
    val currentStart = intervals[i][0]

    if (currentStart >= prevEnd) {
      count++
      prevEnd = intervals[i][1]
    }
  }

  return intervals.size - count
}