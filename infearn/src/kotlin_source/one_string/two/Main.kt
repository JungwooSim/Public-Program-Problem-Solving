package kotlin_source.one_string.two

import java.lang.System.`in`
import java.util.*


/*
2. 대소문자 변환
설명
대문자와 소문자가 같이 존재하는 문자열을 입력받아 대문자는 소문자로 소문자는 대문자로 변환하여 출력하는 프로그램을 작성하세요.

입력
첫 줄에 문자열이 입력된다. 문자열의 길이는 100을 넘지 않습니다.
문자열은 영어 알파벳으로만 구성되어 있습니다.

출력
첫 줄에 대문자는 소문자로, 소문자는 대문자로 변환된 문자열을 출력합니다.
 */
fun main() {
    val scanner = Scanner(`in`)

//    val str: String = scanner.next()
    val str: String = "AdCdfD"

    solution1(str)
}

fun solution1(str: String): Unit {
    str.toByteArray().forEach {
        when(it) {
            in 97 .. 122 -> print((it-32).toChar())
            in 65 .. 90 -> print((it+32).toChar())
        }
    }
}
