package com.example.leetcode

/*
338. Counting Bits (https://leetcode.com/problems/counting-bits/description/?envType=study-plan-v2&id=leetcode-75)

Given an integer n, return an array ans of length n + 1 such that for each i (0 <= i <= n),
ans[i] is the number of 1's in the binary representation of i.
(어떤 양의 정수 n이 주어지면 0~n 까지 총 n+1 개의 배열을 만들어 이진수로 변환시 1의 개수를 반환하는 것이다.)

Example 1:
Input: n = 2
Output: [0,1,1]
Explanation:
0 --> 0
1 --> 1
2 --> 10

Example 2:
Input: n = 5
Output: [0,1,1,2,1,2]
Explanation:
0 --> 0
1 --> 1
2 --> 10
3 --> 11
4 --> 100
5 --> 101

 */

fun main() {
	println(countBits(2).contentToString())
	println("--")
	println(countBits(10).contentToString())
}

// 풀이 정리하면, 우선 다이나믹 프로그램으로 처리.
// 0과 1의 값의 바이너리 값에서 1의 개수를 계산한것을 기반으로 모두 계산하게 된다.

fun countBits(n: Int): IntArray {
	val result = IntArray(n+1)

	for (i in result.indices) {
//		println("i : ${i} / " + i.toUInt().toString(radix = 2))

		result[i] = result[i shr 1] + (i and 1)
//		println(i)
		val a = i shr 1
		val b = i and 1
//		println("${i} / i shr 1 : ${a}")
//		println("${i} / i and 1 : ${b}")

	}

	return result
}