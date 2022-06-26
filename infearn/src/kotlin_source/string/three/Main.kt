package kotlin_source.string.three

import java.lang.System.`in`
import java.util.*

/*
3. 문장 속 단어
설명
한 개의 문장이 주어지면 그 문장 속에서 가장 긴 단어를 출력하는 프로그램을 작성하세요.
문장속의 각 단어는 공백으로 구분됩니다.

입력
첫 줄에 길이가 100을 넘지 않는 한 개의 문장이 주어집니다. 문장은 영어 알파벳으로만 구성되어 있습니다.

출력
첫 줄에 가장 긴 단어를 출력한다. 가장 길이가 긴 단어가 여러개일 경우 문장속에서 가장 앞쪽에 위치한

Ex.
입력 : it is time to study
출력 : study
 */
fun main() {
    val scanner = Scanner(`in`)

//    val str: String = scanner.next()
    val str: String = "it is time to study"

    solution(str)
}

fun solution(str: String) {
    val strSplit: List<String> = str.split(" ")

    var longStr: String = ""
    var maxLength = Integer.MIN_VALUE
    strSplit.forEach{
        if (it.length > maxLength) {
            maxLength = it.length
            longStr = it
        }
    }

    println(longStr)
}