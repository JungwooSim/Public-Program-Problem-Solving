package leetcode

/*
38. Count and Say (https://leetcode.com/problems/count-and-say/)

The count-and-say sequence is a sequence of digit strings defined by the recursive formula:
countAndSay(1) = "1"
countAndSay(n) is the way you would "say" the digit string from countAndSay(n-1), which is then converted into a different digit string.

To determine how you "say" a digit string, split it into the minimal number of substrings such that each substring contains exactly one unique digit.
Then for each substring, say the number of digits, then say the digit.
Finally, concatenate every said digit.

For example, the saying and conversion for digit string "3322251":

Example 1:
Input: n = 1
Output: "1"
Explanation: This is the base case.

Example 2:
Input: n = 4
Output: "1211"

Explanation:
countAndSay(1) = "1"
countAndSay(2) = say "1" = one 1 = "11"
countAndSay(3) = say "11" = two 1's = "21"
countAndSay(4) = say "21" = one 2 + one 1 = "12" + "11" = "1211"

 */

fun main() {
  println(countAndSay(5))
}

fun countAndSay(n: Int): String {
  if (n == 1) return "1"
  if (n == 2) return "11"
  if (n == 3) return "21"

  var defaultStr = "21"
  var output = ""

  // 단순 반복문을 돌리기 위함
  for (n in 4..n) {

    var countTarget = ""
    var isNumberChange: Boolean = false
    var countNumber = 1
    output = ""

    // 로직 수월하게 1부터 시작
    for (i in 1 until defaultStr.length) {
      isNumberChange = defaultStr[i-1] != defaultStr[i]

      // 1부터 시작하므로 -1 해줘야함
      if (i == 1) {
        countTarget = defaultStr[0].toString()
      } else {
        countTarget = defaultStr[i-1].toString()
      }

      if (isNumberChange) {
        output += "$countNumber" + countTarget
        countNumber = 1
      } else {
        countNumber++
      }
    }

    // 마지막 값 추가
    output += "$countNumber" + defaultStr[defaultStr.length-1]

    defaultStr = output
  }

  return output
}