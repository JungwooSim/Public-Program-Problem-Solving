package section1.eight_DfsBfs.nine;

import java.util.Scanner;

/*
9. 조합 구하기
- 설명
1부터 N 까지 번호가 적힌 구슬이 있다.
이 중 M 개를 뽑는 방법의 수를 출락하는 프로그램을 작성하라

- 입력설명
첫 번째 줄에 자연수 N 과 M 을 입력받는다.

- 출력설명
첫 번째 줄에 결과를 출력
출력순서는 사전순으로 오름차순

- 예시입력1
4 2

- 예시출력2
1 2
1 3
1 4
2 3
2 4
3 4

 */
public class Main {
    static int n, m;
    static int[] combi;
    public static void main(String[] args) {
        Main main = new Main();

        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        m = scanner.nextInt();
        combi = new int[m];

        main.DFS(0, 1);
    }

    private void DFS(int L, int s) {
        if (L == m) {
            for (int i=0; i < m; i++) {
                System.out.print(combi[i] + " ");
            }
            System.out.println();
        } else {
            for (int i = s; i <= n; i++) {
                combi[L] = i;
                DFS(L+1, i + 1);
            }
        }
    }
}
