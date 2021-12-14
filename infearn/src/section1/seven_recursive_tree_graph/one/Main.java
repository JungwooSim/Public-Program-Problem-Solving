package section1.seven_recursive_tree_graph.one;

/*
재귀함수
자연수 N이 입력되면 재귀함수를 이용하여 1부터 N까지를 출력하는 프로그램을 작성

입력
첫 번째 줄은 정수 N 이 입력된다

출력
첫째 줄에 출력

입력예제1
3

출력예제
1 2 3
 */
public class Main {
    public static void main(String[] args) {
        Main main = new Main();

        int n = 3;

        main.solution(n);
    }

    private void solution(int n) {
        if (n >= 1) {
            solution(n - 1);
            System.out.print(n + " ");
        }
    }
}
