package kotlin_source.three_twopoint.one

import java.util.Scanner

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

입력예제
3
1 3 5
5
2 3 6 7 9

출력예제
1 2 3 3 5 6 7 9
 */
fun main() {
    val scanner = Scanner(System.`in`)

    val arr1 = listOf(1, 3, 5)
    val arr2 = listOf(2, 3, 6, 7, 9)

    val result: ArrayList<Int> = arrayListOf()

    var x = 0
    var y = 0

    while (arr1.size > x && arr2.size > y) {
        if (arr1[x] >= arr2[y]) {
            result.add(arr2[y])
            y += 1
        } else {
            result.add(arr1[x])
            x += 1
        }
    }

    while (arr1.size > x) {
        result.add(arr1[x])
        x += 1
    }

    while (arr2.size > y) {
        result.add(arr2[y])
        y += 1
    }

    println(result)
}

/**
 느낀점 : array 를 입력받는게 정해져있으므로 while 문을 그 수만큼 생성함
 */