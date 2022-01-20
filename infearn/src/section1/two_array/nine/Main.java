package section1.two_array.nine;

import java.util.ArrayList;
import java.util.Scanner;

/*
9. 격자판 최대합
- 설명
5*5 격자판에 아래롸 같이 숫자가 적혀있습니다.
Image1.jpg
N*N의 격자판이 주어지면 각 행의 합, 각 열의 합, 두 대각선의 합 중 가 장 큰 합을 출력합니다.

- 입력
첫 줄에 자연수 N이 주어진다.(2<=N<=50)
두 번째 줄부터 N줄에 걸쳐 각 줄에 N개의 자연수가 주어진다. 각 자연수는 100을 넘지 않는다.

- 출력
최대합을 출력합니다.

- 예시입력1
5
10 13 10 12 15
12 39 30 23 11
11 25 50 53 15
19 27 29 37 27
19 13 30 13 19

- 예시출력1
155

 */
public class Main {
    public static void main(String[] args) {
        Main main = new Main();

        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[][] arr = new int[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                arr[i][j] = scanner.nextInt();
            }
        }

        main.solution(n, arr);

        // 출력
//        for (int i = 0; i < n; i++) {
//            for (int j = 0; j < n; j++) {
//                System.out.print(arr[i][j] + " ");
//            }
//            System.out.println();
//        }
    }

    private void solution(int n, int[][] arr) {
//        ArrayList<Integer> answer = new ArrayList<>();
        int answer = Integer.MIN_VALUE;

        int xSum = 0;
        int ySum = 0;
        int cross1 = 0;
        int cross2 = 0;

        // 가로, 세로
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                xSum += arr[i][j];
                ySum += arr[j][i];
            }
            cross1 += arr[i][i];
            cross2 += arr[i][n-1-i];

            if (answer < xSum) answer = xSum;
            if (answer < ySum) answer = ySum;
            xSum = 0;
            ySum = 0;
        }

        if (answer < cross1) answer = cross1;
        if (answer < cross2) answer = cross2;

        System.out.println(answer);
    }
}
