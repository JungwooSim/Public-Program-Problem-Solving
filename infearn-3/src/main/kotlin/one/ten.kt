package one

import kotlin.math.min

/*
10. 가장 짧은 문자거리
설명
한 개의 문자열 s와 문자 t가 주어지면 문자열 s의 각 문자가 문자 t와 떨어진 최소거리를 출력하는 프로그램을 작성하세요.

입력
첫 번째 줄에 문자열 s와 문자 t가 주어진다. 문자열과 문자는 소문자로만 주어집니다.
문자열의 길이는 100을 넘지 않는다.

출력
첫 번째 줄에 각 문자열 s의 각 문자가 문자 t와 떨어진 거리를 순서대로 출력한다.

예시 입력 1
teachermode e

예시 출력 1
1 0 1 2 1 0 1 2 2 1 0

 */
fun main() {
  println(solution("teachermode", 'e'))
}

fun solution(str: String, findChar: Char) {
  val strSize = str.length

  val leftAnswer = arrayOfNulls<Int>(strSize)
  val rightAnswer = arrayOfNulls<Int>(strSize)
  var p = 1000

  for (i in str.indices) {
    if (str[i] == findChar) {
      p = 0
    } else {
      p++
    }
    leftAnswer[i] = p
  }

  p = 1000

  for (i in str.indices.reversed()) {
    if (str[i] == findChar) {
      p = 0
    } else {
      p++
    }
    rightAnswer[i] = p
  }

  for (i in 0 until strSize) {
    print("${min(leftAnswer[i]!!, rightAnswer[i]!!)} ")
  }
}
