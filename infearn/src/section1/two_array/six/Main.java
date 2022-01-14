package section1.two_array.six;

import java.util.Scanner;

/*
6. 뒤집은 소수
- 설명
N개의 자연수가 입력되면 각 자연수를 뒤집은 후 그 뒤집은 수가 소수이면 그 소수를 출력하는 프로그램을 작성하세요.
예를 들어 32를 뒤집으면 23이고, 23은 소수이다. 그러면 23을 출력한다. 단 910를 뒤집으면 19로 숫자화 해야 한다.
첫 자리부터의 연속된 0은 무시한다.

- 입력
첫 줄에 자연수의 개수 N(3<=N<=100)이 주어지고, 그 다음 줄에 N개의 자연수가 주어진다.
각 자연수의 크기는 100,000를 넘지 않는다.

- 출력
첫 줄에 뒤집은 소수를 출력합니다. 출력순서는 입력된 순서대로 출력합니다.

- 예시 입력1
9
32 55 62 20 250 370 200 30 100

- 예시 출력1
23 2 73 2 3
 */
public class Main {
    public static void main(String[] args) {
        Main main = new Main();
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();

        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }

        for (int i = 0; i < arr.length; i++) {
            main.solution(arr[i]);
        }
    }

    private void solution(int n) {
        String str = String.valueOf(n);
        char[] chs = str.toCharArray();

        int x = 0;
        for (int i = 0; i < chs.length; i++) {
            x += Character.getNumericValue(chs[i]) * Math.pow(10, i);
        }

        boolean check = true;
        if (x == 1) check = false;
        for (int i = 2; i < x; i++) {
            if (x % i == 0) {
                check = false;
            }
        }

        if (check) System.out.print(x + " ");
    }
}
