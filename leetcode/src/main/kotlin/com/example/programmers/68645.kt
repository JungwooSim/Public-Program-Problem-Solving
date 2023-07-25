package programmers

/*
삼각 달팽이
 */
fun main() {
  solution(4)
}

fun solution(n: Int): IntArray {

  val triangle = Array(n) { IntArray(n) { 0 } }

  var x = 0
  var y = 0
  var v = 1

  while (true) {
    // 아래로 이동
    while (true) {
      triangle[y][x] = v++
      if (y + 1 == n || triangle[y+1][x] != 0) break
      y += 1
    }

    // 오른쪽으로 한칸 이동
    if (x + 1 == n || triangle[y][x+1] != 0) break
    x += 1

    // 오른쪽 이동
    while (true) {
      triangle[y][x] = v++
      if (x + 1 == n || triangle[y][x+1] != 0) break
      x += 1
    }

    if (triangle[y-1][x-1] != 0) break
    x -= 1
    y -= 1

    // 왼쪽 위로 이동
    while (true) {
      triangle[y][x] = v++
      if (triangle[y-1][x-1] != 0) break
      x -= 1
      y -= 1
    }
    if (y + 1 == n || triangle[y+1][x] != 0) break
    y += 1
  }

  var answer = IntArray(v-1) {0}
  var index = 0
  for (i in 0 until n) {
    for (j in 0 .. i) {
      answer[index++] = triangle[i][j]
    }
  }

  return answer
}