package section1.seven_recursive_tree_graph.thirteen;

import java.util.ArrayList;
import java.util.Scanner;

/*
경로 탐색(인접리스트, ArrayList)
- 설명
방향그래프가 주어지면 1번 정점에서 N번 정점으로 가는 모든 경로의 가지 수를 출력하는 프로그램을 작성
아래 그래프에서 1번 정점에서 5번 정점으로 가는 가지수는
1 2 3 4 5
1 2 5
1 3 4 2 5
1 4 2 5
1 4 5

총 6가지

- 입력설명
첫째 줄에는 정점의 수(N) 와 간선의 수 M 이 주어진다.
그 다음부터 M 줄에 걸쳐 연결정보가 주어진다.

- 출력설명
총 가지수를 출력

- 입력예제 1
5 9
1 2
1 3
1 4
2 1
2 3
2 5
3 4
4 2
4 5

- 출력예제1
6
 */
public class Main {
    static int n, m, answer = 0;
    static ArrayList<ArrayList<Integer>> graph;
    static int[] ch;

    public static void main(String[] args) {
        Main main = new Main();

        Scanner kb = new Scanner(System.in);
        n = kb.nextInt();
        m = kb.nextInt();
        ch = new int[n + 1];

        graph = new ArrayList<>();
        for (int i=0; i < n; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i=0; i < m; i++) {
            int a = kb.nextInt();
            int b = kb.nextInt();
            graph.get(a).add(b);
        }

        ch[1] = 1;

        main.DFS(1);
        System.out.println(answer);
    }

    private void DFS(int v) {
        if (v == n) answer++;
        else {
            for (int nv : graph.get(v)) {
                if (ch[nv] == 0) {
                    ch[nv] = 1;
                    DFS(nv);
                    ch[nv] = 0;
                }
            }
        }
    }
}
