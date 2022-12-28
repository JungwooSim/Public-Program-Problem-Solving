package two.nine

import kotlin.math.max

/*
9. 격자판 최대합
설명
5*5 격자판에 아래롸 같이 숫자가 적혀있습니다.
N*N의 격자판이 주어지면 각 행의 합, 각 열의 합, 두 대각선의 합 중 가 장 큰 합을 출력합니다.

입력
첫 줄에 자연수 N이 주어진다.(2<=N<=50)
두 번째 줄부터 N줄에 걸쳐 각 줄에 N개의 자연수가 주어진다. 각 자연수는 100을 넘지 않는다.

출력
최대합을 출력합니다.

예시 입력 1
5
10 13 10 12 15
12 39 30 23 11
11 25 50 53 15
19 27 29 37 27
19 13 30 13 19

예시 출력 1
155
 */

fun main() {
  val arr = arrayOf(
    intArrayOf(10, 13, 10, 12, 15),
    intArrayOf(12, 39, 30, 23, 11),
    intArrayOf(11, 25, 50, 53, 15),
    intArrayOf(19, 27, 29, 37, 27),
    intArrayOf(19, 13, 30, 13, 19)
  )

  println(solution(arr))
}

fun solution(arr: Array<IntArray>): Int {
  var maxValue = 0
  var lowSum = 0
  var colSum = 0
  var crossSum1 = 0
  var crossSum2 = 0

  for (i in arr.indices) {
    for (j in arr[i].indices) {
      lowSum += arr[i][j]
      colSum += arr[j][i]
    }

    crossSum1 += arr[i][i]
    crossSum2 += arr[arr.size - 1 - i][arr.size - 1 - i]

    lowSum = 0
    colSum = 0
    maxValue = max(maxValue, lowSum)
    maxValue = max(maxValue, colSum)
  }

  return max(maxValue, max(crossSum1, crossSum2))
}