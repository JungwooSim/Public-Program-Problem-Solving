package section1.seven_recursive_tree_graph.three;

/*
팩토리얼
자연수 N이 입력되면 N!를 구하는 프로그램을 작성
예를 들어 5! = 5 * 4 * 3 * 2 * 1 = 120

입력 설명
첫 번째 줄에 자연수 N

출력설명
첫 번째 줄에 N팩토리얼 값 출력

입력예제1
5

출력예제
120
 */
public class Main {
    public static void main(String[] args) {
        Main main = new Main();

        int n = 5;

        System.out.println(main.solution(n));
    }

    private int solution(int n) {
        if (n==1) return 1;
        else {
            return n * solution(n - 1);
        }
    }
}
