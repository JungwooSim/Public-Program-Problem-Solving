package section1.stackandqueue.one;

import java.util.Scanner;
import java.util.Stack;

/*
1. 올바른 괄호
설명
괄호가 입력되면 올바른 괄호이면 “YES", 올바르지 않으면 ”NO"를 출력합니다.
(())() 이것은 괄호의 쌍이 올바르게 위치하는 거지만, (()()))은 올바른 괄호가 아니다.

입력
첫 번째 줄에 괄호 문자열이 입력됩니다. 문자열의 최대 길이는 30이다.

출력
첫 번째 줄에 YES, NO를 출력한다.
 */
public class Main {
    public static void main(String[] args) {
        Main main = new Main();

//        Scanner in = new Scanner(System.in);
//        String str = in.next();

        String str = "(()(()))(()";
        main.solution(str);
        main.solution2(str);
    }

    // 내가 푼 코드
    private void solution(String str) {
        boolean isCheck = true;
        Stack<Character> stack = new Stack<>();
        char[] ch = str.toCharArray();

        for (char c : ch) {
            if (c == '(') {
                stack.push('(');
            } else {
                if (stack.isEmpty() || stack.pop() != '(') {
                    isCheck = false;
                }
            }
        }

        String result = !stack.isEmpty() || !isCheck ? "NO" : "YES";
        System.out.println(result);
    }

    // 정답
    private void solution2(String str) {
        boolean isCheck = true;
        Stack<Character> stack = new Stack<>();
        char[] ch = str.toCharArray();

        for (char c : ch) {
            if (c == '(') {
                stack.push('(');
            } else {
                if (stack.isEmpty()) {
                    isCheck = false;
                }
                stack.pop();
            }
        }

        String result = !stack.isEmpty() || !isCheck ? "NO" : "YES";
        System.out.println(result);
    }
}
