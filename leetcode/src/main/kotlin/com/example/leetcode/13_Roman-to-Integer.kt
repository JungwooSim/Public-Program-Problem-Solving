package com.example.leetcode

/*
link : https://leetcode.com/problems/roman-to-integer/

 */
fun main() {

    // 1
    // expect : 3
    println(romanToInt("III"))

    // 2
    // expect : 58
    println(romanToInt("LVIII"))

    // 3
    // expect : 1994
    println(romanToInt("MCMXCIV"))
}

fun romanToInt(s: String): Int {
    val symbol = mapOf(
        'I' to 1,
        'V' to 5,
        'X' to 10,
        'L' to 50,
        'C' to 100,
        'D' to 500,
        'M' to 1000,
    )

    var result = 0

    var preValue = 0
    for (c in s.toCharArray()) {
        var value = symbol[c]!!

        if (preValue < value) {
            result -= preValue
            result += value - preValue
        } else {
            result += value
        }

        preValue = value
    }

    return result
}
