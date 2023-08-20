package programmers

/*
문자열 압축 : https://school.programmers.co.kr/learn/courses/30/lessons/60057
level : 2

 */


fun main() {
  println(solution("aabbaccc"))
  println(solution("ababcdcdababcdcd"))
  println(solution("abcabcdede"))
  println(solution("abcabcabcabcdededededede"))
  println(solution("xababcdcdababcdcd"))
}

fun solution(s: String): Int {
  var min = Integer.MAX_VALUE

  // 전체 탐색
  for (i in 1 .. s.length) {
    val compressed = compress(s, i)

    if (compressed < min) {
      min = compressed
    }
  }

  return min
}

// 문자열을 압축, 압축된 문자열의 길이 반환
fun compress(source: String, length: Int): Int {
  val builder = StringBuilder()

  var last = ""
  var count = 0
  for (token in split(source, length)) {
    if (token == last) {
      count++
    } else {
      if (count > 1) builder.append(count)
      builder.append(last)
      last = token
      count = 1
    }

  }

  if (count > 1) builder.append(count)
  builder.append(last)

  return builder.length
}

// 설정된 길이만큼 문자열 잘라낸 token 배열 생성
fun split(source: String, length: Int): List<String> {
  val tokens = arrayListOf<String>()

  for (startIndex in source.indices step length) {
    var endIndex = startIndex + length

    // OOI 대비
    if (endIndex > source.length) {
      endIndex = source.length
    }

    tokens.add(source.substring(startIndex, endIndex))
  }


  return tokens
}