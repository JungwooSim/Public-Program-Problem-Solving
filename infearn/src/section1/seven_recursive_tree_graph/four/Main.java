package section1.seven_recursive_tree_graph.four;

/*
피보나치 수열
1) 피보나치 수열을 출력한다. (피보나치 수열이란 앞의 2개의 수를 합하여 다음 숫자가 되는 수열이다
2) 입력은 피보나치 수열의 총 항의 수 이다. (만약 7이 입력되면 1 1 2 3 5 8 13 을 출력하면 된다)

입력설명
첫 줄에 총 항수 N이 입력된다.

출력설명
첫 줄에 피보나치 수열을 출력한다

입력예제1
10

출력예제2
1 1 2 3 5 8 13 21 34 55
 */
public class Main {
    static int[] fibo;
    static int[] fibo2;
    public static void main(String[] args) {
        Main main = new Main();

        int n = 10;
        fibo = new int[n + 1];
        fibo2 = new int[n + 1];

        // 무작정 재귀
        for (int i=1; i <= n; i++) {
            System.out.print(main.DFS(i) + " ");
        }
        System.out.println(); // 단순 줄바꿈

        // 수행한 재귀는 저장 후 보여줌
        main.DFS2(n);
        for (int i=1; i <= n; i++) {
            System.out.print(fibo[i] + " ");
        }

        System.out.println(); // 단순 줄바꿈

        // memoization
        main.DFS3(n);
        for (int i=1; i <= n; i++) {
            System.out.print(fibo2[i] + " ");
        }

        System.out.println(); // 단순 줄바꿈

        // for
        int[] x = new int[n+1];
        for (int i=1; i <= n; i++) {
            if (i == 1) x[i] = 1;
            else if (i == 2) x[i] = 1;
            else {
                x[i] = x[i-2] + x[i-1];
            }
            System.out.print(x[i] + " ");
        }
    }

    // 무작정 재귀
    private int DFS(int n) {
        if (n==1) return 1;
        else if(n==2) return 1;
        else {
            return DFS(n-2) + DFS(n-1);
        }
    }

    // 수행했던 재귀는 저장 (부분 memoization)
    private int DFS2(int n) {
        if (n==1) return fibo[n] = 1;
        else if(n==2) return fibo[n] = 1;
        else {
            return fibo[n] = DFS2(n-2) + DFS2(n-1);
        }
    }

    // memoization (완전 memoization)
    private int DFS3(int n) {
        if (fibo2[n] > 0) {
            return fibo2[n];
        }

        if (n==1) return fibo2[n] = 1;
        else if(n==2) return fibo2[n] = 1;
        else {
            return fibo2[n] = DFS3(n-2) + DFS3(n-1);
        }
    }
}
