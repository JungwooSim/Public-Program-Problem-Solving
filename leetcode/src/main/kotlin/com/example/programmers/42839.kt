package programmers.aaaaa

/*
소수 찾기 : https://school.programmers.co.kr/learn/courses/30/lessons/42839?language=kotlin
 */

fun main() {
  println(solution("17"))
  println(solution("011"))
}

fun solution(numbers: String): Int {
  val primes = mutableSetOf<Int>()
  val numbersV2 = numbers.chars()
    .map { i -> i.toChar() - '0' }
    .toArray()

  getPrimes(
    acc = 0,
    numbers = numbersV2,
    isUsed = BooleanArray(numbersV2.size),
    primes = primes,
  )

  return primes.size
}

fun isPrimes(n: Int): Boolean{
  if (n <= 1) {
    return false
  }

  for (i in 2 until n) {
    if (n % i == 0) {
      return false
    }
  }

  return true
}

fun getPrimes(acc: Int, numbers: IntArray, isUsed: BooleanArray, primes: MutableSet<Int>) {
  if (isPrimes(acc)) {
    primes.add(acc)
  }

  for (i in 0 until numbers.size) {
    if (isUsed[i]) continue // 카드 사용 검증
    val nextAcc = acc * 10 + numbers[i] // acc 값의 자리수 증가 후 현재 카드값 추가
    isUsed[i] = true
    getPrimes(
      acc = nextAcc,
      numbers = numbers,
      isUsed = isUsed,
      primes = primes,
    )
    isUsed[i] = false
  }
}