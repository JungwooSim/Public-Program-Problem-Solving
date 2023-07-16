package leetcode

/*
17. Letter Combinations of a Phone Number (https://leetcode.com/problems/letter-combinations-of-a-phone-number/?envType=study-plan-v2&envId=leetcode-75)
Medium

Given a string containing digits from 2-9 inclusive, return all possible letter combinations that the number could represent. Return the answer in any order.

A mapping of digits to letters (just like on the telephone buttons) is given below. Note that 1 does not map to any letters.

Example 1:
Input: digits = "23"
Output: ["ad","ae","af","bd","be","bf","cd","ce","cf"]


Example 2:
Input: digits = ""
Output: []

Example 3:
Input: digits = "2"
Output: ["a","b","c"]

 */
fun main() {
  println(letterCombinations("23"))

  println(letterCombinations(""))

  println(letterCombinations("2"))
}

fun letterCombinations(digits: String): List<String> {
  if (digits.isEmpty()) return emptyList()

  val digitToLettersMap = mapOf(
    '2' to "abc",
    '3' to "def",
    '4' to "ghi",
    '5' to "jkl",
    '6' to "mno",
    '7' to "pqrs",
    '8' to "tuv",
    '9' to "wxyz"
  )
  val result = mutableListOf<String>()
  dfs(digits, digitToLettersMap, "", 0, result)

  return result
}

fun dfs(
  digits: String, // 입력받은 다이얼 숫자
  digitToLettersMap: Map<Char, String>, // 다이얼 정의한것
  currentCombination: String, // 현재 조합
  index: Int, // 시작위치
  result: MutableList<String> // 결과
) {
  if (index == digits.length) {
    result.add(currentCombination)
    return
  }

  val digit = digits[index]
  val letters = digitToLettersMap[digit] ?: "" // abc
  for (letter in letters) {
    dfs(digits, digitToLettersMap, currentCombination + letter, index + 1, result)
  }
}