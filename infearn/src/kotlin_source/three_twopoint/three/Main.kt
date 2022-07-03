package kotlin_source.three_twopoint.three

/*
3. 최대 매출
- 설명
현수의 아빠는 제과점을 운영합니다. 현수 아빠는 현수에게 N일 동안의 매출기록을 주고 연속된 K일 동안의 최대 매출액이 얼마인지 구하라고 했습니다.
만약 N=10이고 10일 간의 매출기록이 아래와 같습니다. 이때 K=3이면
12 15 11 20 25 10 20 19 13 15
연속된 3일간의 최대 매출액은 11+20+25=56만원입니다.
여러분이 현수를 도와주세요.

- 입력
첫 줄에 N(5<=N<=100,000)과 K(2<=K<=N)가 주어집니다.
두 번째 줄에 N개의 숫자열이 주어집니다. 각 숫자는 500이하의 음이 아닌 정수입니다.

- 출력
첫 줄에 최대 매출액을 출력합니다.

- 예시입력1
10 3
12 15 11 20 25 10 20 19 13 15

- 예시출력1
56
 */

fun main() {
    var arr = listOf(12, 15, 11, 20, 25, 10, 20, 19, 13, 15)
    val day = 3

    // 내가 짠 코드
//    var max = 0
//    for (i in 0 until arr.size - day + 1) {
//        var tempMax = 0
//
//        for (j in 0 until day) {
//            tempMax += arr[i + j]
//        }
//
//        max = max.coerceAtLeast(tempMax)
//    }
//    println(max)

    // 좀 더 효율적인 코드
    var sum = 0
    for (i in 0 until day) {
        sum += arr[i]
    }

    var max = sum
    for (i in day until arr.size) {
        sum += arr[i] - arr[i-day]
        max = Math.max(max, sum)
    }
    println(max)
}
// 느낀점 : for 를 두개로 나누면 좀 더 좋은 시간 복잡도로 계산할 수 있다.