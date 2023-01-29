package com.example.leetcode

/*
48. Rotate Image (https://leetcode.com/problems/rotate-image/description/)
*/

fun main() {
  val matrix = arrayOf(
    intArrayOf(1,2,3),
    intArrayOf(4,5,6),
    intArrayOf(7,8,9)
  )

  rotate(matrix)
}

fun rotate(matrix: Array<IntArray>): Unit {
  val m = matrix.size
  val n = matrix[0].size

  var start = 0
  var end = m - 1
  while (start < end) {
    var temp = matrix[start]
    matrix[start++] = matrix[end]
    matrix[end--] = temp
  }

  for (i in 0 until m) {
    for (j in i+1 until n) {
      var temp = matrix[i][j]
      matrix[i][j] = matrix[j][i]
      matrix[j][i] = temp
    }
  }
}