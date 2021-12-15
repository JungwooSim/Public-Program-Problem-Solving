package section1.seven_recursive_tree_graph.six;

/*
부분집합 구하기 (DFS)
자연수 N 이 주어지면 1부터 N까지의 원소를 갖는 집합의 부분집합을 모두 출력하는 프로그램

입력설명
첫 번째 줄에 자연수 N 이 주어진다

출력설명
첫 번째 줄부터 각 줄에 하나씩 부분집합을 아래와 출력예제와 같은 순서로 출력
단 공집합은 출력하지 않음

입력예제1
3

출력예제1
1 2 3
1 2
1 3
1
2 3
2
3

 */
public class Main {

    static int n;
    static int[] ch;

    public static void main(String[] args) {
        Main main = new Main();

        n = 3;
        ch = new int[n+1];

        main.DFS(1);
    }

    private void DFS(int L) {
        if (L == n+1) {
            String tmp = "";
            for (int i=1; i <= n; i++) {
                if (ch[i] == 1) {
                    tmp += (i + " ");
                }
            }

            if (tmp.length() > 0) System.out.println(tmp);
        } else {
            ch[L] = 1;
            DFS(L + 1);

            ch[L] = 0;
            DFS(L + 1);
        }
    }
}
