package leetcode.b

/*
206. Reverse Linked List (https://leetcode.com/problems/reverse-linked-list/)

Given the head of a singly linked list, reverse the list, and return the reversed list.
 */

class ListNode(var `val`: Int) {
  var next: ListNode? = null
}

fun main() {

}

fun reverseList(head: ListNode?): ListNode? {
  var prev: ListNode? = null // 이전
  var current: ListNode? = head
  var next: ListNode? // 다음

  while (current != null) {
    next = current.next // 4
    current.next = prev // null
    prev = current // 5
    current = next //
  }

  return prev
}

// 5 4 3 2 1
// 1 2 3 4 5