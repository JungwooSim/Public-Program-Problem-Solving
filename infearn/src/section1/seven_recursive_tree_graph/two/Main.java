package section1.seven_recursive_tree_graph.two;

/*
재귀함수를 이용한 이진수 출력
10진수 N이 입력되면 2진수로 변환하여 출력하는 프로그램 작성 (단 재귀함수 사용)

입력설명
첫 번째 줄에 10진수

출력 설명
첫 번째 줄에 이진수 출력

입력예제1
11

출력예제1
1011
 */
public class Main {
    public static void main(String[] args) {
        Main main = new Main();

        int n = 11;
        main.solution(n);
    }

    private void solution(int n) {
        if (n == 0) return;
        else {
            solution(n / 2);
            System.out.print(n % 2);
        }
    }
}
