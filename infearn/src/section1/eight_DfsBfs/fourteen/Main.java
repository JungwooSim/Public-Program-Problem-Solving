package section1.eight_DfsBfs.fourteen;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/*
13. 섬나라 아일랜드
- 설명
N*N의 섬나라 아일랜드의 지도가 격자판의 정보로 주어집니다.
각 섬은 1로 표시되어 상하좌우와 대각선으로 연결되어 있으며, 0은 바다입니다.
섬나라 아일랜드에 몇 개의 섬이 있는지 구하는 프로그램을 작성하세요.
만약 위와 같다면 섬의 개수는 5개입니다.

- 입력
첫 번째 줄에 자연수 N(3<=N<=20)이 주어집니다.
두 번째 줄부터 격자판 정보가 주어진다.

- 출력
첫 번째 줄에 섬의 개수를 출력한다.

- 예시 입력1
7
1 1 0 0 0 1 0
0 1 1 0 1 1 0
0 1 0 0 0 0 0
0 0 0 1 0 1 1
1 1 0 1 1 0 0
1 0 0 0 1 0 0
1 0 1 0 1 0 0

- 예시 출력1
5
 */
class Point {
    int x, y;

    Point(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

public class Main {
    static int[][] board;
    static int answer, n = 0;
    static int[] dx = {-1, -1, 0, 1, 1, 1, 0, -1};
    static int[] dy = {0, 1, 1, 1, 0, -1, -1, -1};
    Queue<Point> queue = new LinkedList<>();

    public static void main(String[] args) {
        Main main = new Main();

        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();

        board = new int[n+1][n+1];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                board[i][j] = scanner.nextInt();
            }
        }

        main.solution();

        System.out.println(answer);
    }

    private void solution() {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == 1) {
                    board[i][j] = 0;
                    BFS(i, j);
                    answer++;
                }
            }
        }
    }

    private void BFS(int x, int y) {
        queue.add(new Point(x, y));

        while (!queue.isEmpty()) {
            Point pos = queue.poll();
            for (int i = 0; i < 8; i++) {
                for (int j = 0; j < 8; j++) {
                    int nx = pos.x + dx[i];
                    int ny = pos.y + dy[i];

                    if (nx >= 0 && nx < n && ny >= 0 && ny < n && board[nx][ny] == 1) {
                        board[nx][ny] = 0;
                        queue.add(new Point(nx, ny));
                    }

                }
            }
        }
    }

}
