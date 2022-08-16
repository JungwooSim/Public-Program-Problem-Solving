package com.example.leetcode

/*
grade : middle
https://leetcode.com/problems/letter-combinations-of-a-phone-number/

 */
fun main() {

    // 1
    // expect : ["ad","ae","af","bd","be","bf","cd","ce","cf"]
    println(letterCombinations("23"))

    // 2
    // expect : []
    println(letterCombinations(""))

    // 3
    // expect : ["a","b","c"]
    println(letterCombinations("2"))
}

fun letterCombinations(digits: String): List<String> {
    val combinations: MutableList<String> = mutableListOf()

    val phoneKey = arrayOf(
        "",
        "",
        "abc",
        "def",
        "ghi",
        "jkl",
        "mno",
        "pqrs",
        "tuv",
        "wxyz",
    )

    findCombinations(combinations, digits, StringBuilder(), 0, phoneKey)

    return combinations
}

fun findCombinations(combinations: MutableList<String>, digits: String, previous: StringBuilder, index: Int, lettersAndNumbersMappings: Array<String>) {

    // Base condition for recursion to stop
    if (index == digits.length) {
        combinations.add(previous.toString())
        return
    }

    // Get the letters corresponding to the current index of digits string
    val letters = lettersAndNumbersMappings[digits[index] - '0']

    // Loop through all the characters in the current combination of letters
    for (c in letters.toCharArray()) {
        findCombinations(combinations, digits, previous.append(c), index + 1, lettersAndNumbersMappings)
        previous.deleteCharAt(previous.length - 1)
    }
}