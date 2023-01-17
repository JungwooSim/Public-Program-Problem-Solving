package four.four

import java.util.TreeSet

/*
4. 모든 아나그램 찾기
설명
S문자열에서 T문자열과 아나그램이 되는 S의 부분문자열의 개수를 구하는 프로그램을 작성하세요.
아나그램 판별시 대소문자가 구분됩니다. 부분문자열은 연속된 문자열이어야 합니다.

입력
첫 줄에 첫 번째 S문자열이 입력되고, 두 번째 줄에 T문자열이 입력됩니다.
S문자열의 길이는 10,000을 넘지 않으며, T문자열은 S문자열보다 길이가 작거나 같습니다.

출력
S단어에 T문자열과 아나그램이 되는 부분문자열의 개수를 출력합니다.

예시 입력 1
bacaAacba
abc
예시 출력 1
3

힌트
출력설명: {bac}, {acb}, {cba} 3개의 부분문자열이 "abc"문자열과 아나그램입니다.
 */

fun main() {
  println(solution("bacaAacba", "abc"))
}

fun solution(str: String, find: String): Int {

  var result = 0

  val findTs = TreeSet<Char>()

  find.forEach {
    findTs.add(it)
  }

  println(findTs.toString())

  val loopSize = (str.length - find.length)

  for (i in 0 .. loopSize) {
    val ts = TreeSet<Char>()
    for (j in find.indices) {
      ts.add(str[i+j])
    }
    if (findTs.size == ts.size) {
      val a = StringBuilder()
      val b = StringBuilder()
      findTs.forEach { a.append(it) }
      ts.forEach { b.append(it) }

      if (a.toString() == b.toString()) result++
    }
  }
  return result
}
