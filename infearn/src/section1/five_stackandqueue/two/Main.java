package section1.five_stackandqueue.two;

import java.util.Scanner;
import java.util.Stack;

/*
2. 괄호문자제거
- 설명
입력된 문자열에서 소괄호 () 사이에 존재하는 모든 문자를 제거하고 남은 문자만 출력하는 프로그램을 작성하라.

- 입력설명
첫 줄에 문자열이 주어진다. 문자열의 길이는 100을 넘지 않는다.

- 출력설명
남은 문자만 출력한다.

- 입력예제1
(A(BC)D)EF(G(H)(IJ)K)LM(N)

- 출력예제1
EFLM
 */
public class Main {
    public static void main(String[] args) {
        Main main = new Main();

        Scanner in = new Scanner(System.in);
        String input = in.next();

//        String input = "(A(BC)D)EF(G(H)(IJ)K)LM(N)";

        System.out.println(main.solution(input));
    }

    private String solution(String input) {
        String answer = "";
        Stack<Character> stack = new Stack<>();

        for (char ch : input.toCharArray()) {
            if (ch == ')') {
                while (stack.pop() != '(');
            } else {
                stack.push(ch);
            }
        }

        for (int i=0 ;i < stack.size(); i++) {
            answer += stack.get(i);
        }

        return answer;
    }
}
