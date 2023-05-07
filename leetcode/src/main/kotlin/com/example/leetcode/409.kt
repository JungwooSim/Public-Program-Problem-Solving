package leetcode

/*
409. Longest Palindrome (https://leetcode.com/problems/longest-palindrome/?envType=study-plan&id=level-1)

Given a string s which consists of lowercase or uppercase letters, return the length of the longest palindrome that can be built with those letters.
Letters are case sensitive, for example, "Aa" is not considered a palindrome here.

Example 1:
Input: s = "abccccdd"
Output: 7
Explanation: One longest palindrome that can be built is "dccaccd", whose length is 7.

Example 2:
Input: s = "a"
Output: 1
Explanation: The longest palindrome that can be built is "a", whose length is 1.

 */

fun main() {
	println(
		longestPalindrome("aaaa")
	)

//	println(
//		longestPalindrome("a")
//	)
}

/*
회문을 만들 수 있는 문자를 조합하기 위해서 크게 짝수와 홀수를 계산하는게 먼저다.

만약 각 문자가 모두 짝수라면 해당 문자 개수 만큼 회문을 만들 수 있다.
근데, 각 문자가 모두 홀수라면 1번만 가능하다. (abcd -> ab : ba)

그래서 전략은 짝수 문자 개수 합한다음에 홀수개가 있다면 더해주면 된다.
 */

fun longestPalindrome(s: String): Int {
	val charCount = IntArray(128) // 각 단어별 빈도수 저장
	var palindromeLength = 0
	var hasOddFrequency = false

	// 각 단어별 빈도수 저장
	for (i in s.indices) {
		charCount[s[i].toInt()]++
	}

	for (count in charCount) {
		palindromeLength += count / 2 * 2 // 각 단어 길이 계산

		// 단어의 길이가 짝수인지 홀수 기록 (회문을 하기 위해선 짝수여야하기 때문)
		if (palindromeLength % 2 == 0) hasOddFrequency = true
	}

	// 홀수개가 있다면 더해주는 부분 (단 원래 문자열의 개수를 초과해선 안됨)
	if (hasOddFrequency && palindromeLength < s.length) palindromeLength++

	return palindromeLength
}