package three.four

/*
4. 연속 부분수열
N개의 수로 이루어진 수열이 주어집니다.
이 수열에서 연속부분수열의 합이 특정숫자 M이 되는 경우가 몇 번 있는지 구하는 프로그램을 작성하세요.
만약 N=8, M=6이고 수열이 다음과 같다면
1 2 1 3 1 1 1 2
합이 6이 되는 연속부분수열은 {2, 1, 3}, {1, 3, 1, 1}, {3, 1, 1, 1}로 총 3가지입니다.

입력
첫째 줄에 N(1≤N≤100,000), M(1≤M≤100,000,000)이 주어진다.
수열의 원소값은 1,000을 넘지 않는 자연수이다.

출력
첫째 줄에 경우의 수를 출력한다.

예시 입력 1
8 6
1 2 1 3 1 1 1 2
예시 출력 1
3
 */

fun main() {
  val arr = intArrayOf(1, 2, 1, 3, 1, 1, 1, 2)
  val m = 6

  println(solution(arr, m))
}

fun solution(arr: IntArray, m: Int): Int {
  var result = mutableListOf<List<Int>>()

  for (i in arr.indices) {
    var tmpSum = 0
    var tmpArr = mutableListOf<Int>()

    for (j in i until arr.size) {
      if (tmpSum == m) {
        result.add(tmpArr)
        break
      } else if(tmpSum > m) {
        break
      } else {
        tmpSum += arr[j]
        tmpArr.add(arr[j])
      }
    }
  }

  println(result)

  return 0
}