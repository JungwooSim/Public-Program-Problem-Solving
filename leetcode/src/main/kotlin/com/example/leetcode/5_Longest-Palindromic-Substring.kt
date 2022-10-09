package com.example.leetcode

/*
link : https://leetcode.com/problems/longest-palindromic-substring/

 */
fun main() {
    // 1. "babad"
    // expect : "bab"
    println(longestPalindrome("babad"))

//     1. "cbbd"
//     expect : "bb"
//    println(longestPalindrome("cbbd"))
}

fun longestPalindrome(s: String): String {

    val s: CharArray = s.toCharArray()
    var temp = ""
    var result = ""

    for (v in s) {
        temp += v

        for (i in 0 until (temp.length / 2)) {

//            println("temp : $temp / i : $i")
            if (temp[i] != temp[temp.length - 1 - i]) {
                println("temp : $temp / i : $i")
                temp = temp.substring(i + 1, temp.length)
//                println("temp : $temp / i : $i")
            } else {
                result = temp
            }
        }


//        println(temp.length)
        println("---")
    }
    println(temp)
    println(result)

    return ""
}

// 순차적으로 한번더 확인