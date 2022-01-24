package section1.one_string.eleven;

import java.util.Scanner;

/*
11. 문자열 압축
- 설명
알파벳 대문자로 이루어진 문자열을 입력받아 같은 문자가 연속으로 반복되는 경우 반복되는
문자 바로 오른쪽에 반복 횟수를 표기하는 방법으로 문자열을 압축하는 프로그램을 작성하시오.
단 반복횟수가 1인 경우 생략합니다.

- 입력
첫 줄에 문자열이 주어진다. 문자열의 길이는 100을 넘지 않는다.

- 출력
첫 줄에 압축된 문자열을 출력한다.

- 예시입력1
KKHSSSSSSSE

- 예시출력1
K2HS7E

- 예시입력2
KSTTTSEEKFKKKDJJGG

- 예시출력2
KST3SE2KFK3DJ2G2
 */
public class Main {
    public static void main(String[] args) {
        Main main = new Main();

        Scanner scanner = new Scanner(System.in);
        String str = scanner.next();

        main.solution(str);
    }

    private void solution(String str) {
        String answer = "";
        str = str + " ";
        int count = 1;
        char[] chars = str.toCharArray();

        for (int i = 0; i < chars.length-1; i++) {
            if (chars[i] == chars[i+1]) {
                count++;
            } else {
                answer += chars[i];
                if (count > 1) {
                    answer += String.valueOf(count);
                }
                count = 1;
            }
        }

        System.out.println(answer);
    }
}
