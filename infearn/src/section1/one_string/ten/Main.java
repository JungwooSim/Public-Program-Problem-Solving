package section1.one_string.ten;

import java.util.Scanner;

/*
10. 가장 짧은 문자거리
- 설명
한 개의 문자열 s와 문자 t가 주어지면 문자열 s의 각 문자가 문자 t와 떨어진 최소거리를 출력하는 프로그램을 작성하세요.

- 입력
첫 번째 줄에 문자열 s와 문자 t가 주어진다. 문자열과 문자는 소문자로만 주어집니다.
문자열의 길이는 100을 넘지 않는다.

- 출력
첫 번째 줄에 각 문자열 s의 각 문자가 문자 t와 떨어진 거리를 순서대로 출력한다.

- 예시 입력
teachermode e

- 예시 출력
1 0 1 2 1 0 1 2 2 1 0

 */
public class Main {
    public static void main(String[] args) {
        Main main = new Main();

        Scanner scanner = new Scanner(System.in);

        String str = scanner.next();
        String findStr = scanner.next();

        main.solution(str, findStr);
    }

    private void solution(String str, String findStr) {
        int strSize = str.length();
        int[] leftAnswer = new int[strSize];
        int[] rightAnswer = new int[strSize];
        int p = 1000;
        char find = findStr.charAt(0);

        for (int i=0; i < strSize; i++) {
            if (str.charAt(i) == find) {
                p = 0;
            } else {
                p++;
                leftAnswer[i] = p;
            }
        }

        p = 1000;
        for (int i=strSize - 1; i >= 0; i--) {
            if (str.charAt(i) == find) {
                p = 0;
            } else {
                p++;
                rightAnswer[i] = p;
            }
        }

        for (int i=0; i < strSize; i++) {
            System.out.print(Math.min(leftAnswer[i], rightAnswer[i]) + " ");
        }
    }
}
