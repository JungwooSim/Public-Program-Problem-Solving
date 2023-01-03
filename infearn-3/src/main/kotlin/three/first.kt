package three.first

import java.lang.Integer.max

/*
1. 두 배열 합치기
설명
오름차순으로 정렬이 된 두 배열이 주어지면 두 배열을 오름차순으로 합쳐 출력하는 프로그램을 작성하세요.

입력
첫 번째 줄에 첫 번째 배열의 크기 N(1<=N<=100)이 주어집니다.
두 번째 줄에 N개의 배열 원소가 오름차순으로 주어집니다.
세 번째 줄에 두 번째 배열의 크기 M(1<=M<=100)이 주어집니다.
네 번째 줄에 M개의 배열 원소가 오름차순으로 주어집니다.
각 리스트의 원소는 int형 변수의 크기를 넘지 않습니다.

출력
오름차순으로 정렬된 배열을 출력합니다.

예시 입력 1
3
1 3 5
5
2 3 6 7 9

예시 출력 1
1 2 3 3 5 6 7 9
 */

fun main() {
  val arr1 = intArrayOf(1, 3, 5)
  val arr2 = intArrayOf(2, 3, 6, 7, 9)

  solution(arr1, arr2)
}

fun solution(arr1: IntArray, arr2: IntArray) {
  var result = arrayListOf<Int>()
  var p1 = 0
  var p2 = 0
  var n = arr1.size
  var m = arr2.size

  while (p1 < n && p2 < m) {
    if (arr1[p1] < arr2[p2]) {
      result.add(arr1[p1])
      p1++
    } else {
      result.add(arr2[p2])
      p2++
    }
  }

  while (p1 < n) {
    result.add(arr1[p1])
    p1++
  }

  while (p2 < m) {
    result.add(arr2[p2])
    p2++
  }

  result.forEach { print("${it} ") }
}