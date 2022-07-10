package kotlin_source.three_twopoint.five

/*
5. 연속된 자연수의 합
- 설명
N입력으로 양의 정수 N이 입력되면 2개 이상의 "연속된 자연수"의 합으로 정수 N을 표현하는 방법의 가짓수를 출력하는 프로그램을 작성하세요.
만약 N=15이면
7+8=15
4+5+6=15
1+2+3+4+5=15
와 같이 총 3가지의 경우가 존재한다.

- 입력
첫 번째 줄에 양의 정수 N(7<=N<1000)이 주어집니다.

- 출력
첫 줄에 총 경우수를 출력합니다.

- 예시입력1
15

- 예시출력1
3
 */
fun main() {
  val n = 15

//  solution1(n)
  solution2(n)
}


/**
 * "연속된 자연수의 합" 이라는 특징을 이용하여 n / 2 + 1 공식을 사용
 * 만약 n = 15 일 경우, 연속된 자연수의 합이 15가 되기 위한 최대 값은 "n / 2 + 1" 까지만 해당 된다.
 */
fun solution2(n: Int) {
  val arr = mutableListOf<Int>()
  val loopSize = n / 2 + 1

  // 1 ~ "n / 2 + 1" 까지 배열 생성
  for (i in 1 .. loopSize) {
    arr.add(i)
  }

  var result = 0
  var sum = 0
  var leftIndex = 0
  for (i in arr.indices) {
    sum += arr[i]

    if (sum == n) result++

    while (sum >= n) {
      sum -= arr[leftIndex++]

      if (sum == n) result++
    }
  }

  println("result = ${result}")
}

/**
 * "연속 부분수열" 문제와 동일한 방식으로 풀이
 */
fun solution1(n: Int) {
  val arr = mutableListOf<Int>()

  // 1 ~ n 까지 배열 생성
  for (i in 1 until n) {
    arr.add(i)
  }

  var result = 0
  var sum = 0
  var leftIndex = 0
  for (i in arr.indices) {
    sum += arr[i]

    if (sum == n) result++

    while (sum >= n) {
      sum -= arr[leftIndex++]

      if (sum == n) result++
    }
  }

  println("result = ${result}")
}