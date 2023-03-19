package com.example.leetcode

/*
62. Unique Paths (https://leetcode.com/problems/unique-paths/description/)

There is a robot on an m x n grid. The robot is initially located at the top-left corner (i.e., grid[0][0]). The robot tries to move to the bottom-right corner (i.e., grid[m - 1][n - 1]). The robot can only move either down or right at any point in time.
Given the two integers m and n, return the number of possible unique paths that the robot can take to reach the bottom-right corner.
The test cases are generated so that the answer will be less than or equal to 2 * 109.

Example 1.
Input: m = 3, n = 7
Output: 28

Example 2.
Input: m = 3, n = 2
Output: 3
 */

fun main() {
  println(uniquePaths(3, 7))

  println(uniquePaths(3, 2))
}

fun uniquePaths(m: Int, n: Int): Int {
  val dp = Array(m) { IntArray(n) }

  for (i in 0 until m) {
    dp[i][0] = 1
  }
  for (j in 0 until n) {
    dp[0][j] = 1
  }

//  dpPrint(dp)

  for (i in 1 until m) {
    for (j in 1 until n) {
      dp[i][j] = dp[i-1][j] + dp[i][j-1]
    }
  }

  return dp[m-1][n-1]
}

fun dpPrint(dp: Array<IntArray>) {
  for (m in dp.indices) {
    for (n in 0 until dp[m].size) {
      print("${dp[m][n]} ")
    }
    println()
  }
  println("-----")
}