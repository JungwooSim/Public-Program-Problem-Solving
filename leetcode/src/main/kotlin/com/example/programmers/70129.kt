package programmers.a

/*
이진 변환 반복하기 : https://school.programmers.co.kr/learn/courses/30/lessons/70129
 */

fun main() {
  println(solution("110010101001").contentToString())
  println(solution("01110").contentToString())
  println(solution("1111111").contentToString())
}

fun solution(s: String): IntArray {
  var answer: IntArray = intArrayOf(0, 0)

  var tempStr = s
  while (tempStr != "1") {
    val zeroRemoveStr = zeroRemove(tempStr)
    val zeroCnt = tempStr.length - zeroRemoveStr.length
    tempStr = Integer.toBinaryString(zeroRemoveStr.length)
    answer[0]++
    answer[1] += zeroCnt // 0 개수
  }

  return answer
}

fun zeroRemove(s: String): String {
  return s.replace("0", "")
}