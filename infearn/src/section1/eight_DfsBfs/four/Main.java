package section1.eight_DfsBfs.four;

import java.util.Scanner;

/*
4. 중복순열 구하기
- 설명
1부터 N 까지 번호가 적힌 구슬이 있다.
이 중복을 허락하여 M 번을 뽑아 일렬로 나열하는 방법을 모두 출력하라

- 입력
첫 번째 줄에 자연수 N 이 주어진다

- 출력
첫 번째 줄에 결과 출력
결과는 사전순으로 오름차순으로 출력

- 예시입력1
3 2

- 예시출력1
1 1
1 2
1 3
2 1
2 2
2 3
3 1
3 2
3 3
 */
public class Main {
    static int n, m;
    static int[] pm;
    public static void main(String[] args) {
        Main main = new Main();
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        m = scanner.nextInt();
        pm = new int[m];

        main.DFS(0);
    }

    private void DFS(int L) {
        if (L == m) {
            for (int x : pm) {
                System.out.print(x + " ");
            }
            System.out.println();
        } else {
            for (int i = 1; i <= n; i++) {
                pm[L] = i;
                DFS(L + 1);
            }
        }
    }
}
