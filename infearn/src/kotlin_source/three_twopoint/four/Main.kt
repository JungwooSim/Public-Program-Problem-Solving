package kotlin_source.three_twopoint.four


/*
4. 연속 부분수열
- 설명
N개의 수로 이루어진 수열이 주어집니다.
이 수열에서 연속부분수열의 합이 특정숫자 M이 되는 경우가 몇 번 있는지 구하는 프로그램을 작성하세요.
만약 N=8, M=6이고 수열이 다음과 같다면
1 2 1 3 1 1 1 2
합이 6이 되는 연속부분수열은 {2, 1, 3}, {1, 3, 1, 1}, {3, 1, 1, 1}로 총 3가지입니다.

- 입력
첫째 줄에 N(1≤N≤100,000), M(1≤M≤100,000,000)이 주어진다.
수열의 원소값은 1,000을 넘지 않는 자연수이다.

- 출력
첫째 줄에 경우의 수를 출력한다.

- 예시 입력1
8 6
1 2 1 3 1 1 1 2

- 예시 출력1
3
 */
fun main() {
  val arr = listOf(1, 2, 1, 3, 1, 1, 1, 2)
  val n = 6

  var result = 0

  var sum = 0
  var leftIndex = 0
  for (i in arr.indices) {
    sum += arr[i]

    if (sum == n) result++

    while (sum >= n) {
      sum -= arr[leftIndex]
      leftIndex++

      if (sum == n) result++
    }
  }

  println("result = ${result}")
}

/*
우선 6 이상까지 순차적으로 더해서 값을 구하고
만약 6이상이 되면 하나의 point 지점부터(왼쪽 index) 순차적으로 ++ 하며 차감한다.
 */