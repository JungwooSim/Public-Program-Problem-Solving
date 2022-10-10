package com.example.leetcode


/*
49. Group Anagrams

Given an array of strings strs, group the anagrams together. You can return the answer in any order.
An Anagram is a word or phrase formed by rearranging the letters of a different word or phrase, typically using all the original letters exactly once.

Example 1:
Input: strs = ["eat","tea","tan","ate","nat","bat"]
Output: [["bat"],["nat","tan"],["ate","eat","tea"]]

Example 2:
Input: strs = [""]
Output: [[""]]

Example 3:
Input: strs = ["a"]
Output: [["a"]]

Constraints:
1 <= strs.length <= 104
0 <= strs[i].length <= 100
strs[i] consists of lowercase English letters.

 */

fun main() {
  val input = arrayOf("eat","tea","tan","ate","nat","bat")
  groupAnagrams(input)
}

fun groupAnagrams(strs: Array<String>): List<List<String>> {
  var result: ArrayList<ArrayList<String>> = arrayListOf()
  var map: MutableMap<String, ArrayList<String>> = HashMap()

  for (str in strs) {
    var temp = str.toCharArray().apply { sort() }.joinToString("")

    if (map.containsKey(temp)) {
      map[temp]!!.add(str)
    } else {
      map[temp] = arrayListOf(str)
    }
  }

  for (i in map.values) {
    result.add(i)
  }

  return result
}