package com.example.leetcode

/*
2352. Equal Row and Column Pairs

Given a 0-indexed n x n integer matrix grid, return the number of pairs (ri, cj) such that row ri and column cj are equal.
A row and column pair is considered equal if they contain the same elements in the same order (i.e., an equal array).
 */

fun main() {
	val params1 = arrayOf(
		intArrayOf(3,2,1),
		intArrayOf(1,7,6),
		intArrayOf(2,7,7),
	)

	println(equalPairs(params1))

	val params2 = arrayOf(
		intArrayOf(3,1,2,2),
		intArrayOf(1,4,4,5),
		intArrayOf(2,4,2,2),
		intArrayOf(2,4,2,2),
	)
	println(equalPairs(params2))
}

fun equalPairs(grid: Array<IntArray>): Int {
	val n = grid.size
	var ans = 0

	for (i in 0 until  n) {
		for (j in 0 until n) {
			var k = 0

			while (k < n) {
				if (grid[i][k] != grid[k][j]) break // 행과 열 비교
				k += 1
			}

			if (k == n) ans++

		}
	}

	return ans
}