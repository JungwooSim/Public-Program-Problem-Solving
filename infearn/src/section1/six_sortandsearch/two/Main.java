package section1.six_sortandsearch.two;

import java.util.Scanner;

/*
2. 버블정렬
- 설명
N 개의 숫자가 입력되면 오름차순으로 정렬하여 출력하는 프로그램을 작성하세요.
정렬하는 방법은 버블정렬 입니다.

- 입력
첫 번째 줄에 자연수 N 이 주어진다.
두 번째 줄에 N 개의 자연수가 공백을 사이에 두고 입력하게 된다. 각 자연수는 정수형 범위 안에 있다.

- 출력
오름차순으로 정렬된 수열을 출력한다.

- 예시입력1
6
13 5 11 7 23 15

- 예시출력2
5 7 11 13 15 23
 */
public class Main {
    public static void main(String[] args) {
        Main main = new Main();

        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] arr = new int[n];

        for (int i=0 ;i < n; i++) {
            arr[i] = in.nextInt();
        }

        System.out.println(main.solution(n, arr));
    }

    private String solution(int n, int[] arr) {
        String answer = "";

        for (int j=0; j < n-1; j++) {
            for (int i=0; i < n-j-1; i++) {
                if (arr[i] > arr[i + 1]) {
                    int tmp = arr[i];
                    arr[i] = arr[i + 1];
                    arr[i + 1] = tmp;
                }
            }
        }

        for (int i=0; i<n; i++) {
            answer += arr[i] + " ";
        }

        return answer;
    }
}
