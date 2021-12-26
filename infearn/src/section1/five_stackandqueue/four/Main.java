package section1.five_stackandqueue.four;

import java.util.Scanner;
import java.util.Stack;

/*
4. 후위식 연산(postfix)
- 설명
후위연산식이 주어지면 연산한 결과를 출력하는 프로그램을 작성하세요.
만약 3*(5+2)-9 을 후위연산식으로 표현하면 352+*9- 로 표현되며 그 결과는 12입니다.

- 입력
첫 줄에 후위연산식이 주어집니다. 연산식의 길이는 50을 넘지 않습니다.
식은 1~9의 숫자와 +, -, *, / 연산자로만 이루어진다.

- 출력
연산한 결과를 출력합니다.

- 예시입력1
352+*9-

- 예시출력1
12
 */
public class Main {
    public static void main(String[] args) {
        Main main = new Main();
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
//        String str = "352+*9-";

        main.solution(str);
    }

    private void solution(String str) {
        char[] ch = str.toCharArray();
        Stack<Integer> stack = new Stack<>();

        for (char c : ch) {
            if (Character.isDigit(c)) {
                stack.push(c - 48);
            } else {
                int rt = stack.pop();
                int lt = stack.pop();

                if (c == '+') {
                    stack.push(lt + rt);
                }
                if (c == '-') {
                    stack.push(lt - rt);
                }

                if (c == '/') {
                    stack.push(lt / rt);
                }

                if (c == '*') {
                    stack.push(lt * rt);
                }
            }
        }

        System.out.println(stack.pop());
    }
}
