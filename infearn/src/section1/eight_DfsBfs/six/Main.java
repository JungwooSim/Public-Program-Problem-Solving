package section1.eight_DfsBfs.six;

import java.util.Scanner;

/*
6. 순열 구하기
- 설명
10 이하의 N개의 자연수가 주어지면 이 중 M개를 뽑아 일렬로 나열하는 방법을 모두 출력한다.

- 입력설명
첫 번째 줄에 자연수 N과 M이 주어진다
두 번째 줄에 N개의 자연수가 오름차순으로 주어진다.

- 출력설명
첫 번째 줄에 결과를 출력
출력순서는 사전순으로 오름차순으로 출력

- 예시입력1
3 2
3 6 9

- 예시출력2
3 6
3 9
6 3
6 9
9 3
9 6
 */
public class Main {
    static int n, m;
    static int[] pm, ch, arr;
    public static void main(String[] args) {
        Main main = new Main();

        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        m = scanner.nextInt();
        arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }

        ch = new int[n];
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
            for (int i=0; i < n; i++) {
                if (ch[i] == 0) {
                    ch[i] = 1;
                    pm[L] = arr[i];
                    DFS(L+1);
                    ch[i] = 0;
                }
            }
        }
    }
}
