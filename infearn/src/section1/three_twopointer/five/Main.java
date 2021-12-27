package section1.three_twopointer.five;

import java.util.Scanner;

/*
5. 연속된 자연수의 합
- 설명
N입력으로 양의 정수 N이 입력되면 2개 이상의 연속된 자연수의 합으로 정수 N을 표현하는 방법의 가짓수를 출력하는 프로그램을 작성하세요.
만약 N=15이면
7+8=15
4+5+6=15
1+2+3+4+5=15
와 같이 총 3가지의 경우가 존재한다.

- 입력
첫 번째 줄에 양의 정수 N(7<=N<1000)이 주어집니다.

- 출력
첫 줄에 총 경우수를 출력합니다.

- 예시입력1
15

- 예시출력1
3
 */
public class Main {
    public static void main(String[] args) {
        Main main = new Main();

        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();

        main.solution(n);
    }

    private void solution(int n) {
        int answer = 0;
        int sum = 0, lt = 0;
        int loopSize = n / 2 + 1;
        int[] arr = new int[loopSize];

        for (int i = 0; i < loopSize; i++) {
            arr[i] = i+1;
        }

        for (int rt = 0; rt < loopSize; rt++) {
            sum += arr[rt];
            if (sum == n) answer++;

            while (sum > n) {
                sum -= arr[lt];
                lt++;
                if (sum == n) answer++;
            }
        }

        System.out.println(answer);
    }
}
