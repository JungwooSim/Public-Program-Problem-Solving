package com.example.leetcode
/*
link : https://leetcode.com/problems/longest-substring-without-repeating-characters/
 */
fun main() {
    // 1. "abcabcbb"
    // expect : 3
//    println(lengthOfLongestSubstring("abcabcbb"))

    // 2. "bbbbb"
    // expect : 1
//    println(lengthOfLongestSubstring("bbbbb"))

    // 3. "pwwkew"
    // expect : 3
    println(lengthOfLongestSubstring("pwwkew"))
}

fun lengthOfLongestSubstring(s: String): Int {
    var start = 0
    var temp = ""
    var result = ""

    var sArray = s.toCharArray()

    for ((i, value) in sArray.withIndex()) {
        // temp 문자열에 sArray[i] 문자가 있는지 확인 , 있으면 문자열에서 해당 문자 위치 반환. 없으면 -1 반환
        var index = temp.indexOf(sArray[i])

        // 만약 있으면, start 위치를 해당 위치로 변경
        if (index >= 0) {
            start += index + 1
        }

        temp = s.substring(start, i + 1)

        if (result.length < temp.length) {
            result = temp
        }
    }

    return result.length
}
