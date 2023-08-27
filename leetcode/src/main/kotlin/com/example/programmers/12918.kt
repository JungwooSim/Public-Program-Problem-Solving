package programmers.b

/*
문자열 다루기 : https://school.programmers.co.kr/learn/courses/30/lessons/12918
 */

fun main() {
  println(solution("a234"))

  println(solution("1234"))
}

fun solution(s: String): Boolean {
  val regex = Regex("[0-9]{4}|[0-9]{6}")

  return regex.matches(s)
}