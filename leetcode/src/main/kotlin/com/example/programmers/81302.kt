package programmers

/*
거리두기 확인하기 (https://school.programmers.co.kr/learn/courses/30/lessons/81302)

 */

fun main() {

  val input = arrayOf(
    arrayOf("POOOP", "OXXOX", "OPXPX", "OOXOX", "POXXP"),
    arrayOf("POOPX", "OXPXP", "PXXXO", "OXXXO", "OOOPP"),
    arrayOf("PXOPX", "OXOXP", "OXPOX", "OXXOP", "PXPOX"),
    arrayOf("OOOXX", "XOOOX", "OOOXX", "OXOOX", "OOOOO"),
    arrayOf("PXPXP", "XPXPX", "PXPXP", "XPXPX", "PXPXP")
  )

  println(solution(input).contentToString())
}

fun solution(places: Array<Array<String>>): IntArray {
  val answer: IntArray = IntArray(places.size, {1})

  for (placeIndex in places.indices) {
    var result = true
    val placeArr = createPlaceArr(places[placeIndex])
    for (row in placeArr.indices) {
      for (col in placeArr[row].indices) {

        // 현재 위치에 응시자가 없으면 패스
        if (placeArr[row][col] != 'P') continue
        val isDistance = isDistanced(placeArr, row, col)
        if (!isDistance) result = false
      }
    }
    if (!result) answer[placeIndex] = 0
  }

  return answer
}

fun createPlaceArr(place: Array<String>): Array<CharArray> {
  val placeArr = Array(5) { CharArray(5) {' '} }

  for (rowIndex in place.indices) { // Ex. POOOP
    for (colIndex in place[rowIndex].indices) { // Ex. P
//      println("rowIndex : ${rowIndex} , colIndex : ${colIndex}, place[rowIndex][colIndex] : ${place[rowIndex][colIndex]}")
      placeArr[rowIndex][colIndex] = place[rowIndex][colIndex]
    }
  }

  return placeArr
}

fun isDistanced(
  placeArr: Array<CharArray>,
  pointX: Int,
  pointY: Int
): Boolean {
  val dx = arrayOf(0, 1, 0, -1)
  val dy = arrayOf(-1, 0, 1, 0)

  for (i in 0 until 4) {
    var checkX = pointX + dx[i]
    var checkY = pointY + dy[i]

    // 배열의 범위에서 벗어날때
    if (checkX < 0 || checkY < 0 || checkX > 4 || checkY > 4) continue

    when (placeArr[checkX][checkY]) {
      'P' -> return false
      'O' -> {
        for (j in 0 until 4) {
          // 왔던곳은 패스
          if (i == j) continue

          var checkX = pointX + dx[j]
          var checkY = pointY + dy[j]

          // 배열의 범위에서 벗어날때
          if (checkX < 0 || checkY < 0 || checkX > 4 || checkY > 4) continue

          if (placeArr[checkX][checkY] == 'P') return false

          return true
        }
      }
    }
  }
  return true
}

// 체크포인트 3개
// 1. 현재 위치에 사람이 앉아있다면,
// 2. 상하좌우 에 빈테이블 있는지 확인