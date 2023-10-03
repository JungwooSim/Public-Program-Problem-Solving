package programmers.zzz

/*
모의고사 : https://school.programmers.co.kr/learn/courses/30/lessons/42840?language=kotlin
 */

import java.util.stream.IntStream

fun main() {
  println(solution(intArrayOf(1,2,3,4,5)).contentToString())
  println(solution(intArrayOf(1,3,2,4,2)).contentToString())
}

fun solution(answers: IntArray): IntArray {
  var answer = intArrayOf()
  var peoplePoint = intArrayOf(0, 0, 0)
  var maxPeoplePoint = 0

  for (problem in 0 until answers.size) {

    for (people in 0 until 3) {
      var picked = getPicked(people, problem)

      if (answers[problem] == picked) {
        peoplePoint[people]++
        if(maxPeoplePoint < peoplePoint[people]) {
          maxPeoplePoint = peoplePoint[people]
        }
      }
    }
  }

  return IntStream.range(0, 3)
    .filter { peoplePoint[it] == maxPeoplePoint}
    .map { it + 1 }
    .toArray()
}

fun getPicked(people: Int, problem: Int): Int {
  val rules = arrayOf(
    intArrayOf(1, 2, 3, 4, 5),
    intArrayOf(2, 1, 2, 3, 2, 4, 2, 5),
    intArrayOf(3, 3, 1, 1, 2, 2, 4, 4, 5, 5),
  )

  val rule = rules[people]
  val index = problem % rule.size
  return rule[index]
}
