package com.example.programmers

import java.util.LinkedList

/*
캐시 : https://school.programmers.co.kr/learn/courses/30/lessons/17680?language=java

- 입력 형식
캐시 크기(cacheSize)와 도시이름 배열(cities)을 입력받는다.
cacheSize는 정수이며, 범위는 0 ≦ cacheSize ≦ 30 이다.
cities는 도시 이름으로 이뤄진 문자열 배열로, 최대 도시 수는 100,000개이다.
각 도시 이름은 공백, 숫자, 특수문자 등이 없는 영문자로 구성되며, 대소문자 구분을 하지 않는다. 도시 이름은 최대 20자로 이루어져 있다.

- 출력 형식
입력된 도시이름 배열을 순서대로 처리할 때, "총 실행시간"을 출력한다.

- 조건
캐시 교체 알고리즘은 LRU(Least Recently Used)를 사용한다.
cache hit일 경우 실행시간은 1이다.
cache miss일 경우 실행시간은 5이다.

 */

class LRU {
  fun solution(cacheSize: Int, cities: Array<String>): Int {
    var answer = 0
    val cache = LinkedList<String>()
    val cacheMap = mutableMapOf<String, Int>()

    for (city in cities) {
      val city2 = city.lowercase()
      if (cacheMap[city2] == null) {
        cacheMap[city2] = 0
        cache.addFirst(city2)
        if (cache.size > cacheSize) {
          cacheMap.remove(cache.removeLast())
        }
        answer += 5
      } else {
        cache.remove(city2)
        cache.addFirst(city2)

        answer += 1
      }
    }

    return answer
  }
}

fun main() {
  val LRU = LRU()

  println(
    LRU.solution(
      cacheSize = 3,
      cities = arrayOf("Jeju", "Pangyo", "Seoul", "NewYork", "LA", "Jeju", "Pangyo", "Seoul", "NewYork", "LA")
    )
  )

  println(
    LRU.solution(
      cacheSize = 3,
      cities = arrayOf("Jeju", "Pangyo", "Seoul", "Jeju", "Pangyo", "Seoul", "Jeju", "Pangyo", "Seoul")
    )
  )

  println(
    LRU.solution(
      cacheSize = 2,
      cities = arrayOf("Jeju", "Pangyo", "Seoul", "NewYork", "LA", "SanFrancisco", "Seoul", "Rome", "Paris", "Jeju", "NewYork", "Rome")
    )
  )

  println(
    LRU.solution(
      cacheSize = 5,
      cities = arrayOf("Jeju", "Pangyo", "Seoul", "NewYork", "LA", "SanFrancisco", "Seoul", "Rome", "Paris", "Jeju", "NewYork", "Rome")
    )
  )

  println(
    LRU.solution(
      cacheSize = 2,
      cities = arrayOf("Jeju", "Pangyo", "NewYork", "newyork")
    )
  )

  println(
    LRU.solution(
      cacheSize = 0,
      cities = arrayOf("Jeju", "Pangyo", "Seoul", "NewYork", "LA")
    )
  )

}