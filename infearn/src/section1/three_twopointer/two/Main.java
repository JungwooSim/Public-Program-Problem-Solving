package section1.three_twopointer.two;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

/*
2. 공통원소 구하기
- 설명
A, B 두 개의 집합이 주어지면 두 집합의 공통 원소를 추출하여 오름차순으로 출력하는 프로그램을 작성

- 입력설명
첫 번째 줄에 집합 A 의 크기 N 이 주어진다
두 번째 줄에 N 개의 원소가 주어진다. (원소가 중복되어 주어지지 않는다.)
세 번째 줄에 집합 B 의 크기 M 이 주어진다.
네 번째 줄에 M 개의 원소가 주어진다. (원소가 중복되어 주어지지 않는다.)
각 집합의 원소는 1,000,000,000 이하의 자연수이다.

- 출력설명
두 집합의 공통원소를 오름차순 정렬하여 출력

- 입력예제1
5
1 3 9 5 2
5
3 2 5 7 8

- 출력예제1
2 3 5

 */
public class Main {
    public static void main(String[] args) {
        Main main = new Main();

        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] arr1 = new int[n];

        for (int i=0; i < n; i++) {
            arr1[i] = in.nextInt();
        }

        int m = in.nextInt();
        int[] arr2 = new int[m];

        for (int i=0; i < m; i++) {
            arr2[i] = in.nextInt();
        }


        main.solution(n, m, arr1, arr2);
    }

    private void solution(int n, int m, int[] a, int[] b) {
        ArrayList<Integer> result = new ArrayList<>();
        int p1 = 0, p2 = 0;
        Arrays.sort(a);
        Arrays.sort(b);

        while (p1 < n && p2 < m) {
            if (a[p1] == b[p2]) {
                result.add(a[p1]);
                p1++;
                p2++;
            } else if(a[p1] < b[p2]) {
                p1++;
            } else {
                p2++;
            }
        }

        for (Integer val : result) {
            System.out.print(val + " ");
        }
    }
}
