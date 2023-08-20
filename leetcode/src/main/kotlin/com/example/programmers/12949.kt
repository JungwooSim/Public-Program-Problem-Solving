package programmers

/*
행렬의 곱셈 : https://school.programmers.co.kr/learn/courses/30/lessons/12949
level : 2

 */

fun main() {
  var result = solution(
    arrayOf(
      intArrayOf(1, 4),
      intArrayOf(3, 2),
      intArrayOf(4, 1)
    )
    , arrayOf(
      intArrayOf(3, 3),
      intArrayOf(3, 3),
    )
  )
  println("")


  result = solution(
    arrayOf(
      intArrayOf(2, 3, 2),
      intArrayOf(4, 2, 4),
      intArrayOf(3, 1, 4),
    )
    , arrayOf(
      intArrayOf(5, 4, 3),
      intArrayOf(2, 4, 1),
      intArrayOf(3, 1, 1),
    )
  )

  println("")
}

fun solution(arr1: Array<IntArray>, arr2: Array<IntArray>): Array<IntArray> {
  // arr1의 행의 개수만큼 반복
  return Array(arr1.size){ i ->
    // arr2의 행의 개수만큼 반복
    IntArray(arr2[0].size){ j ->
      var value = 0
      // arr1의 열의 개수만큼 반복 or arr2의 행의 개수만큼 반복
      for(k in arr2.indices){
        value += arr1[i][k] * arr2[k][j]
      }
      // 계산된 결과의 원소값을 반환
      value
    }
  }
}