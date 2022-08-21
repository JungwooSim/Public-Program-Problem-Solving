package com.example.leetcode

fun main() {
    // 1. "abcabcbb"
    // expect : 3
    println(lengthOfLongestSubstring("abcabcbb"))

    // 2. "bbbbb"
    // expect : 1
    println(lengthOfLongestSubstring("bbbbb"))

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
        var index = temp.indexOf(sArray[i])

        if (index !== -1) {
            start += index + 1
        }
        temp = s.substring(start, i + 1)
        if (result.length < temp.length) {
            result = temp
        }
    }

    return result.length
}
