package com.example.leetcode

/*
205. Isomorphic Strings (https://leetcode.com/problems/isomorphic-strings/?envType=study-plan&id=level-1)

Given two strings s and t, determine if they are isomorphic.
Two strings s and t are isomorphic if the characters in s can be replaced to get t.
All occurrences of a character must be replaced with another character while preserving the order of characters.
No two characters may map to the same character, but a character may map to itself.

Example 1:
Input: s = "egg", t = "add"
Output: true

Example 2:
Input: s = "foo", t = "bar"
Output: false

Example 3:
Input: s = "paper", t = "title"
Output: true
 */

fun main() {
  println(isIsomorphic("egg", "add"))
  println(isIsomorphic("foo", "bar"))
  println(isIsomorphic("paper", "title"))
  println(isIsomorphic("bbbaaaba", "aaabbbba"))
  println(isIsomorphic("badc", "baba"))
}

fun isIsomorphic(s: String, t: String): Boolean {
  if (s.length != t.length) return false

  val map = mutableMapOf<Char, Char>()

  for (i in s.indices) {
    val sChar = s[i]
    val tChar = t[i]

    if (map.containsKey(sChar)) {
      if (map[sChar] != tChar) return false
    } else {
      if (map.containsValue(tChar)) return false // 매칭되어있는 값이 아닐 경우
      map[sChar] = tChar
    }
  }

  return true
}
