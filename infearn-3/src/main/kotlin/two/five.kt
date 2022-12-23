package two.five

/*
5. 소수(에라토스테네스 체)
설명
자연수 N이 입력되면 1부터 N까지의 소수의 개수를 출력하는 프로그램을 작성하세요.
만약 20이 입력되면 1부터 20까지의 소수는 2, 3, 5, 7, 11, 13, 17, 19로 총 8개입니다.

입력
첫 줄에 자연수의 개수 N(2<=N<=200,000)이 주어집니다.

출력
첫 줄에 소수의 개수를 출력합니다.

예시 입력 1
20

예시 출력 1
8
 */
fun main() {
  println(solution(20))
}

fun solution(n: Int): Int {
  var result = 0
  var ch = arrayOfNulls<Int>(n+1)

  for (i in 2..n) {
    if (ch[i] == null) {
      result++
      for (j in i..n step i) {
        ch[j] = 1
      }
    }
  }

  return result
}

