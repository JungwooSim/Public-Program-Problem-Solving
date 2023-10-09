package programmers.aaa

/*
카펫 : https://school.programmers.co.kr/learn/courses/30/lessons/42842
 */

fun main() {
  println(
    solution(10, 2).contentToString()
  )

  println(
    solution(8, 1).contentToString()
  )

  println(
    solution(24, 24).contentToString()
  )
}

fun solution(brown: Int, yellow: Int): IntArray {

  for (width in 3 .. 5000) {
    for (height in 3 .. width) {
      var boundary = (width + height - 2) * 2
      var center = width * height - boundary

      if (brown == boundary && yellow == center) return intArrayOf(width, height)
    }
  }

  return intArrayOf()
}