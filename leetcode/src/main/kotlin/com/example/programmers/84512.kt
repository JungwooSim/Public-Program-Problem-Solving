package programmers.aa

fun main() {
  println(solution("AAAAE"))
  println(solution("AAAE"))
  println(solution("I"))
  println(solution("EIO"))
}

fun solution(findWord: String): Int {
  val chars = "AEIOU".toCharArray()
  val words = mutableListOf<String>()

  generate("", words, chars)

  return words.indexOf(findWord)
}

fun generate(word: String, words: MutableList<String>, chars: CharArray) {
  words.add(word)
  if (word.length == 5) return

  chars.forEach {
    generate(word + it, words, chars)
  }
}