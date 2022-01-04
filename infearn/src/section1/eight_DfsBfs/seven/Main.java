package section1.eight_DfsBfs.seven;

import java.util.Scanner;

/*
7. 조합의 경우수(메모이제이션)
- 설명
하지만 여러분은 이 공식을 쓰지않고 다음 공식을 사용하여 재귀를 이용해 조합수를 구해주는 프로그램을 작성하세요.

- 입력
첫째 줄에 자연수 n(3<=n<=33)과 r(0<=r<=n)이 입력됩니다.

- 출력
첫째 줄에 조합수를 출력합니다.

- 예시입력1
5 3

- 예시출력1
10

- 예시입력2
33 19

- 예시출력2
818809200
 */
public class Main {
    static int[][] dy = new int[35][35];
    public static void main(String[] args) {
        Main main = new Main();

        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int r = scanner.nextInt();

        System.out.println(main.DFS(n, r));
    }

    private int DFS(int n, int r) {
        if (dy[n][r] > 0) return dy[n][r];
        if (n == r || r == 0) return 1;
        else {
            dy[n][r] = DFS(n - 1, r - 1) + DFS(n - 1, r);
            return dy[n][r];
        }
    }
}
