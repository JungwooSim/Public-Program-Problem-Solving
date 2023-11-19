package com.example.programmers

/*
불량 사용자 : https://school.programmers.co.kr/learn/courses/30/lessons/64064
 */
fun main() {
  val solution = Solution()

  println(
    solution.solution(
      user_id = arrayOf("frodo", "fradi", "crodo", "abc123", "frodoc"),
      banned_id = arrayOf("fr*d*", "abc1**")
    )
  )

  println(
    solution.solution(
      user_id = arrayOf("frodo", "fradi", "crodo", "abc123", "frodoc"),
      banned_id = arrayOf("*rodo", "*rodo", "******")
    )
  )

  println(
    solution.solution(
      user_id = arrayOf("frodo", "fradi", "crodo", "abc123", "frodoc"),
      banned_id = arrayOf("fr*d*", "*rodo", "******", "******")
    )
  )

}

class Solution {
  fun solution(user_id: Array<String>, banned_id: Array<String>): Int {

    var banSet: MutableSet<MutableSet<String>> = mutableSetOf()

    /*
    [["frodo", "fradi"],["abc123"]]
     */
    val bans: List<List<String>> = banned_id.map {
      it.replace("*", ".")
    }.map { banned ->
      user_id.filter { id ->
        id.matches(Regex(banned)) // fr.d. 로 검색
      }.toList()
    }

    count(
      index = 0,
      banned = mutableSetOf(),
      bans = bans,
      banSet = banSet,
    )

    return banSet.size
  }

  fun count(
    index: Int, // 상태변수
    banned: MutableSet<String>, // 상태변수 (중복 방지)
    bans: List<List<String>>, // 불량 사용자 아이디별로 매칭되는 사용자 아이디 정보
    banSet: MutableSet<MutableSet<String>>,
  ) {

    if (index == bans.size) {
      banSet.add(banned)
      return
    }

    for (id in bans[index]) {
      if (banned.contains(id)) continue

      banned.add(id)
      count(
        index = index + 1,
        banned = banned,
        bans = bans,
        banSet = banSet,
      )
      banned.remove(id)
    }
  }
}