package six

import java.util.*

/*
1. 올바른 괄호
괄호가 입력되면 올바른 괄호이면 “YES", 올바르지 않으면 ”NO"를 출력합니다.
(())() 이것은 괄호의 쌍이 올바르게 위치하는 거지만, (()()))은 올바른 괄호가 아니다.

입력
첫 번째 줄에 괄호 문자열이 입력됩니다. 문자열의 최대 길이는 30이다.

출력
첫 번째 줄에 YES, NO를 출력한다.

예시 입력 1
(()(()))(()
예시 출력 1
NO
 */

fun main() {
  println(solution("(()(()))(()"))

  println(solution("(())"))
}

fun solution(str: String): String {

  val stack = Stack<Char>()

  for (i in str) {
    if (i == '(') {
      stack.push(i)
    } else {
      if (stack.empty()) return "NO"
      stack.pop()
    }
  }

  if (stack.size != 0) return "NO"
  return "YES"
}