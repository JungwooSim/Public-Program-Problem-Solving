package six.three

import java.util.*

/*
3. 크레인 인형뽑기(카카오)

 */


fun main() {
  val arr = arrayOf(
    intArrayOf(0, 0, 0, 0, 0),
    intArrayOf(0, 0, 1, 0, 3),
    intArrayOf(0, 2, 5, 0, 1),
    intArrayOf(4, 2, 4, 4, 2),
    intArrayOf(3, 5, 1, 3, 1),
  )

  val findArr = intArrayOf(1, 5, 3, 5, 1, 2, 1, 4)

  println(solution(arr, findArr))
}

fun solution(arr: Array<IntArray>, findArr: IntArray): Int {
  val stackArr = Array(arr.size) {Stack<Int>()}
  val resultStack = Stack<Int>()
  var result = 0

  for (i in arr.indices) {
    for (j in arr[i].size-1 downTo 0) {
      if (arr[j][i] != 0) stackArr[i].push(arr[j][i])
    }
  }

  for (find in findArr) {
    if (!stackArr[find-1].empty()) {
      var temp = stackArr[find-1].pop()

      if (resultStack.isNotEmpty() && temp == resultStack.peek()) {
        resultStack.pop()
        result++
      } else {
        resultStack.push(stackArr[find-1].pop())
      }
    }
  }

  return result
}
