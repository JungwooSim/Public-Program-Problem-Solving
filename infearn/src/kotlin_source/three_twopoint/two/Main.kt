package kotlin_source.three_twopoint.two

/*
2. 공통원소 구하기
- 설명
A, B 두 개의 집합이 주어지면 두 집합의 공통 원소를 추출하여 오름차순으로 출력하는 프로그램을 작성

- 입력설명
첫 번째 줄에 집합 A 의 크기 N 이 주어진다
두 번째 줄에 N 개의 원소가 주어진다. (원소가 중복되어 주어지지 않는다.)
세 번째 줄에 집합 B 의 크기 M 이 주어진다.
네 번째 줄에 M 개의 원소가 주어진다. (원소가 중복되어 주어지지 않는다.)
각 집합의 원소는 1,000,000,000 이하의 자연수이다.

- 출력설명
두 집합의 공통원소를 오름차순 정렬하여 출력

- 입력예제1
5
1 3 9 5 2
5
3 2 5 7 8

- 출력예제1
2 3 5
 */
fun main() {
    var arr1 = listOf(1, 3, 9, 5, 2)
    var arr2 = listOf(3, 2, 5, 7, 8)

    arr1 = arr1.sorted()
    arr2 = arr2.sorted()

    val result: ArrayList<Int> = arrayListOf()
    var x = 0
    var y = 0

    while (arr1.size > x && arr2.size > y) {
        if (arr1[x] == arr2[y]) {
            result.add(arr1[x])
            x += 1
            y += 1
        } else if (arr1[x] > arr2[y]) {
            y += 1
        } else if (arr1[x] < arr2[y]) {
            x += 1
        }
    }
    println(result)
}

// 느낀점 : while 안에 if 문을 else if 로 하지 않아서 조금 삽질했음.