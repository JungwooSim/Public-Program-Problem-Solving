package one.eleven

/*
11. 문자열 압축
설명
알파벳 대문자로 이루어진 문자열을 입력받아 같은 문자가 연속으로 반복되는 경우 반복되는
문자 바로 오른쪽에 반복 횟수를 표기하는 방법으로 문자열을 압축하는 프로그램을 작성하시오.
단 반복횟수가 1인 경우 생략합니다.

입력
첫 줄에 문자열이 주어진다. 문자열의 길이는 100을 넘지 않는다.

출력
첫 줄에 압축된 문자열을 출력한다.

예시 입력 1
KKHSSSSSSSE

예시 출력 1
K2HS7E

예시 입력 2
KSTTTSEEKFKKKDJJGG
예시 출력 2
KST3SE2KFK3DJ2G2
 */

fun main() {
  println(solution("KKHSSSSSSSE"))
}

fun solution(str: String): String {
  var count = 1
  var pre = ' '

  var result = ""

  for (c in str) {
    if (c == pre) {
      count++
    } else {
      if (count > 1) {
        result += "${count}"
      }
      result += "${c}"
      count = 1
    }
    pre = c
  }

  // 마지막 알파벳의 개수 출력
  if (count > 1) {
    result += "${count}"
  }

  return result
}

/*
count = 1
이전의 값을 가지고 있을 수 있는 변수 생성

현재 값이 이전과 동일한지 비교
동일하면 count ++
동일하지 않으면 count 출력
단, 출력하는데 count 가 1 초과 일 때만
 */
