package com.example.programmers.KAKAO_BLIND_RECRUITMENT_2020.one

/*
- 제목 : 문자열 압축

- 문제 설명

데이터 처리 전문가가 되고 싶은 "어피치"는 문자열을 압축하는 방법에 대해 공부를 하고 있습니다.
최근에 대량의 데이터 처리를 위한 간단한 비손실 압축 방법에 대해 공부를 하고 있는데, 문자열에서 같은 값이 연속해서 나타나는 것을 그 문자의 개수와 반복되는 값으로 표현하여 더 짧은 문자열로 줄여서 표현하는 알고리즘을 공부하고 있습니다.
간단한 예로 "aabbaccc"의 경우 "2a2ba3c"(문자가 반복되지 않아 한번만 나타난 경우 1은 생략함)와 같이 표현할 수 있는데, 이러한 방식은 반복되는 문자가 적은 경우 압축률이 낮다는 단점이 있습니다.
예를 들면, "abcabcdede"와 같은 문자열은 전혀 압축되지 않습니다. "어피치"는 이러한 단점을 해결하기 위해 문자열을 1개 이상의 단위로 잘라서 압축하여 더 짧은 문자열로 표현할 수 있는지 방법을 찾아보려고 합니다.
예를 들어, "ababcdcdababcdcd"의 경우 문자를 1개 단위로 자르면 전혀 압축되지 않지만,
2개 단위로 잘라서 압축한다면 "2ab2cd2ab2cd"로 표현할 수 있습니다. 다른 방법으로 8개 단위로 잘라서 압축한다면 "2ababcdcd"로 표현할 수 있으며, 이때가 가장 짧게 압축하여 표현할 수 있는 방법입니다.
다른 예로, "abcabcdede"와 같은 경우, 문자를 2개 단위로 잘라서 압축하면 "abcabc2de"가 되지만, 3개 단위로 자른다면 "2abcdede"가 되어 3개 단위가 가장 짧은 압축 방법이 됩니다.
이때 3개 단위로 자르고 마지막에 남는 문자열은 그대로 붙여주면 됩니다.
압축할 문자열 s가 매개변수로 주어질 때, 위에 설명한 방법으로 1개 이상 단위로 문자열을 잘라 압축하여 표현한 문자열 중 가장 짧은 것의 길이를 return 하도록 solution 함수를 완성해주세요.

입출력 예
"aabbaccc" -> 7
"ababcdcdababcdcd" -> 9
"abcabcdede" -> 8
"abcabcabcabcdededededede" -> 14
"xababcdcdababcdcd" -> 17

 */
fun main() {
//    println(solution("aabbaccc"))
  println(solution("ababcdcdababcdcd"))
//    println(solution("abcabcdede"))
//    println(solution("abcabcabcabcdededededede"))
//    println(solution("xababcdcdababcdcd"))
}

fun solution(s: String): Int {
  var answer = Integer.MAX_VALUE

  // 최대 압축은 n / 2 이므로
  for (i in 1 .. s.length / 2) {
    var sb = StringBuilder() // 압축 결과 문자열
    var prevStr = "" // 비교용 이전 문자열
    var count: Int = 1 // 연속 개수

    for (j in 0 .. (s.length-i) step i) {
      var curStr = s.substring(j, j + i)

      // 문자열 연속 여부 체크
      if (prevStr.equals(curStr)) {
        count++
        continue
      } else if (count > 1) {
        sb.append("${count}${prevStr}")
        count = 1
      } else {
        sb.append(prevStr)
      }
      prevStr = curStr
    }
    sb.append(if (count > 1) "${count}${prevStr}" else "${prevStr}")

    if (s.length % i != 0) {
      sb.append(s.substring((s.length - s.length % i), s.length))
    }

    answer = Math.min(answer, sb.length)
    sb = StringBuilder()
  }

  return answer
}