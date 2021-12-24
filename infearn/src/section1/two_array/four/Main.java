package section1.two_array.four;

import java.util.Scanner;

/*
4. 피보나치 수열
- 설명
1) 피보나키 수열을 출력한다. 피보나치 수열이란 앞의 2개의 수를 합하여 다음 숫자가 되는 수열이다.
2) 입력은 피보나치 수열의 총 항의 수 이다. 만약 7이 입력되면 1 1 2 3 5 8 13을 출력하면 된다.

- 입력
첫 줄에 총 항수 N(3<=N<=45)이 입력된다.

- 출력
첫 줄에 피보나치 수열을 출력합니다.

- 예시 입력1
10

- 예시 출력1
1 1 2 3 5 8 13 21 34 55
 */
public class Main {
    public static void main(String[] args) {
        Main main = new Main();

        Scanner in = new Scanner(System.in);
        int n = in.nextInt();

        main.solution(n);
        System.out.println();
        main.solution2(n);
    }

    private void solution(int n) {
        int[] arr = new int[n];
        arr[0] = 1;
        arr[1] = 1;

        for (int i=2; i < n; i++) {
            arr[i] = arr[i - 1] + arr[i - 2];
        }

        for (int i=0; i < n; i++) {
            System.out.print(arr[i] + " ");
        }
    }

    private void solution2(int n) {
        int a = 1, b = 1, c = 0;

        System.out.print(a + " " + b+ " ");

        for (int i=2; i < n; i++) {
            c = a + b;
            System.out.print(c + " ");
            b = a;
            a = c;
        }
    }
}
