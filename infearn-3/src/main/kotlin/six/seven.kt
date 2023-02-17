package six.seven

/*
7. 좌표 정렬
N개의 평면상의 좌표(x, y)가 주어지면 모든 좌표를 오름차순으로 정렬하는 프로그램을 작성하세요.
정렬기준은 먼저 x값의 의해서 정렬하고, x값이 같을 경우 y값에 의해 정렬합니다.

입력
첫째 줄에 좌표의 개수인 N(3<=N<=100,000)이 주어집니다.
두 번째 줄부터 N개의 좌표가 x, y 순으로 주어집니다. x, y값은 양수만 입력됩니다.

출력
N개의 좌표를 정렬하여 출력하세요.

예시 입력 1
5
2 7
1 3
1 2
2 5
3 6

예시 출력 1
1 2
1 3
2 5
2 7
3 6
 */

data class Point(var a: Int, var b: Int)

fun main() {
  val arr = listOf<IntArray>(
    intArrayOf(2, 7),
    intArrayOf(1, 3),
    intArrayOf(1, 2),
    intArrayOf(2, 5),
    intArrayOf(3, 6),
  )

  solution(arr)
}

fun solution(arr: List<IntArray>) {
  val li = ArrayList<Point>()

  for (i in arr.indices) {
    li.add(Point(arr[i][0], arr[i][1]))
  }

  li.sortWith(compareBy({it.a}, {it.b}))

  li.forEach {
    println("${it.a} ${it.b}")
  }
}