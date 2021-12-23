package section1.one_string.seven;

import java.util.Scanner;

/*
7. 회문 문자열
- 설명
앞에서 읽을 때나 뒤에서 읽을 때나 같은 문자열을 회문 문자열이라고 합니다.
문자열이 입력되면 해당 문자열이 회문 문자열이면 "YES", 회문 문자열이 아니면 “NO"를 출력하는 프로그램을 작성하세요.
단 회문을 검사할 때 대소문자를 구분하지 않습니다.

- 입력
첫 줄에 길이 100을 넘지 않는 공백이 없는 문자열이 주어집니다.

- 출력
첫 번째 줄에 회문 문자열인지의 결과를 YES 또는 NO로 출력합니다.

- 예시입력1
gooG

- 예시출력1
YES

 */
public class Main {
    public static void main(String[] args) {
        Main main = new Main();
        Scanner in = new Scanner(System.in);
        String input = in.next();

        System.out.println(main.solution(input));
        System.out.println(main.solution2(input));
    }

    private String solution(String input) {
        String answer = "YES";

        char[] ch = input.toUpperCase().toCharArray();

        for (int i=0; i < ch.length / 2; i++) {
            if (ch[i] != ch[ch.length - 1 - i]) {
                answer = "NO";
            }
        }

        return answer;
    }

    private String solution2(String input) {
        String answer = "YES";

        String str = new StringBuilder(input.toUpperCase()).reverse().toString();

        if (!input.toUpperCase().equals(str)) answer = "NO";

        return answer;
    }
}
