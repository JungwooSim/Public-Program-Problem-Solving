package com.example.leetcode

/*
36. Valid Sudoku (https://leetcode.com/problems/valid-sudoku/)
Determine if a 9 x 9 Sudoku board is valid. Only the filled cells need to be validated according to the following rules:
Each row must contain the digits 1-9 without repetition.
Each column must contain the digits 1-9 without repetition.
Each of the nine 3 x 3 sub-boxes of the grid must contain the digits 1-9 without repetition.

A Sudoku board (partially filled) could be valid but is not necessarily solvable.
Only the filled cells need to be validated according to the mentioned rules.

 */

fun main() {
  val board1 = arrayOf(
    charArrayOf('5', '3', '.', '.', '7', '.', '.', '.', '.'),
    charArrayOf('6', '.', '.', '1', '9', '5', '.', '.', '.'),
    charArrayOf('.', '9', '8', '.', '.', '.', '.', '6', '.'),
    charArrayOf('8', '.', '.', '.', '6', '.', '.', '.', '3'),
    charArrayOf('4', '.', '.', '8', '.', '3', '.', '.', '1'),
    charArrayOf('7', '.', '.', '.', '2', '.', '.', '.', '6'),
    charArrayOf('.', '6', '.', '.', '.', '.', '2', '8', '.'),
    charArrayOf('.', '.', '.', '4', '1', '9', '.', '.', '5'),
    charArrayOf('.', '.', '.', '.', '8', '.', '.', '7', '9'),
  )

  val board2 = arrayOf(
    charArrayOf('8', '3', '.', '.', '7', '.', '.', '.', '.'),
    charArrayOf('6', '.', '.', '1', '9', '5', '.', '.', '.'),
    charArrayOf('.', '9', '8', '.', '.', '.', '.', '6', '.'),
    charArrayOf('8', '.', '.', '.', '6', '.', '.', '.', '3'),
    charArrayOf('4', '.', '.', '8', '.', '3', '.', '.', '1'),
    charArrayOf('7', '.', '.', '.', '2', '.', '.', '.', '6'),
    charArrayOf('.', '6', '.', '.', '.', '.', '2', '8', '.'),
    charArrayOf('.', '.', '.', '4', '1', '9', '.', '.', '5'),
    charArrayOf('.', '.', '.', '.', '8', '.', '.', '7', '9'),
  )

  val board3 = arrayOf(
    charArrayOf('.','.','4','.','.','.','6','3','.'),
    charArrayOf('.','.','.','.','.','.','.','.','.'),
    charArrayOf('5','.','.','.','.','.','.','9','.'),
    charArrayOf('.','.','.','5','6','.','.','.','.'),
    charArrayOf('4','.','3','.','.','.','.','.','1'),
    charArrayOf('.','.','.','7','.','.','.','.','.'),
    charArrayOf('.','.','.','5','.','.','.','.','.'),
    charArrayOf('.','.','.','.','.','.','.','.','.'),
    charArrayOf('.','.','.','.','.','.','.','.','.'),
  )

  println("board1 : ${isValidSudoku(board1)}")
  println("board2 : ${isValidSudoku(board2)}")
  println("board3 : ${isValidSudoku(board3)}")
}

fun isValidSudoku(board: Array<CharArray>): Boolean {
  val checkPoint = arrayOf(
    arrayOf(1, 1),
    arrayOf(1, 4),
    arrayOf(1, 7),
    arrayOf(4, 1),
    arrayOf(4, 4),
    arrayOf(4, 7),
    arrayOf(7, 1),
    arrayOf(7, 4),
    arrayOf(7, 7),
  )

  for (cp in checkPoint) {
//    println("squareCheck : ${squareCheck(board, cp[0], cp[1])}")
    if (!squareCheck(board, cp[0], cp[1])) return false
  }

  if (!rowCheck(board)) return false
  if (!lineCheck(board)) return false

  return true
}

fun rowCheck(board: Array<CharArray>): Boolean {
  for (i in board.indices) {
    var numberCount = 0
    val numbers = mutableSetOf<Char>()

    for (j in board[i].indices) {
      if (board[i][j] != '.') {
        numbers.add(board[i][j])
        numberCount++
      }
    }
    if (numberCount != numbers.size) return false
  }
  return true
}

fun lineCheck(board: Array<CharArray>): Boolean {
  for (i in board.indices) {
    var numberCount = 0
    val numbers = mutableSetOf<Char>()

    for (j in board[i].indices) {
      if (board[j][i] != '.') {
        numbers.add(board[j][i])
        numberCount++
      }
    }
    if (numberCount != numbers.size) return false
  }
  return true
}

fun squareCheck(board: Array<CharArray>, x: Int, y: Int): Boolean {
  var numberCount = 0
  val numbers = mutableSetOf<Char>()

  if (board[y-1][x-1] != '.') {
    numberCount++
    numbers.add(board[y-1][x-1])
  }
  if (board[y-1][x-0] != '.') {
    numberCount++
    numbers.add(board[y-1][x-0])
  }
  if (board[y-1][x+1] != '.') {
    numberCount++
    numbers.add(board[y-1][x+1])
  }
  if (board[y][x-1] != '.') {
    numberCount++
    numbers.add(board[y][x-1])
  }
  if (board[y][x] != '.') {
    numberCount++
    numbers.add(board[y][x])
  }
  if (board[y][x+1] != '.') {
    numberCount++
    numbers.add(board[y][x+1])
  }
  if (board[y+1][x-1] != '.') {
    numberCount++
    numbers.add(board[y+1][x-1])
  }
  if (board[y+1][x-0] != '.') {
    numberCount++
    numbers.add(board[y+1][x-0])
  }
  if (board[y+1][x+1] != '.') {
    numberCount++
    numbers.add(board[y+1][x+1])
  }

//  println("board[y-1][x-1] : ${board[y-1][x-1]}")
//  println("board[y-1][x-0] : ${board[y-1][x-0]}")
//  println("board[y-1][x+1] : ${board[y-1][x+1]}")
//  println("board[y][x-1] : ${board[y][x-1]}")
//  println("board[y][x] : ${board[y][x]}")
//  println("board[y][x+1] : ${board[y][x+1]}")
//  println("board[y+1][x-1] : ${board[y+1][x-1]}")
//  println("board[y+1][x-0] : ${board[y+1][x-0]}")
//  println("board[y+1][x+1] : ${board[y+1][x+1]}")
//  println("numbers.size : ${numbers.size}")
//  println("numberCount : ${numberCount}")

  return numbers.size == numberCount
}

/*
가로, 세로 전체 확인 필요.


 */