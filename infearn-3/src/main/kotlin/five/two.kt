package six.two

import java.util.*

/*
2. 괄호문자제거
입력된 문자열에서 소괄호 ( ) 사이에 존재하는 모든 문자를 제거하고 남은 문자만 출력하는 프로그램을 작성하세요.

입력
첫 줄에 문자열이 주어진다. 문자열의 길이는 100을 넘지 않는다.

출력
남은 문자만 출력한다.

예시 입력 1
(A(BC)D)EF(G(H)(IJ)K)LM(N)
예시 출력 1
EFLM
 */

fun main() {
  println(solution("(A(BC)D)EF(G(H)(IJ)K)LM(N)"))
}

fun solution(str: String): String {
  val stack = Stack<Char>()
  var result = ""


  for (i in str) {
    if (i == '(') {
      stack.push(i)
    } else if(i == ')') {
      stack.pop()
    } else {
      if (stack.empty()) result += i
    }
  }

  return result
}