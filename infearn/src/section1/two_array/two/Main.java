package section1.two_array.two;

import java.util.Scanner;

/*
- 설명
선생님이 N명의 학생을 일렬로 세웠다
일렬로 서 있는 학생의 키가 앞에서부터 순서대로 주어질 때, 맨 앞에 서 있는 선생님이 볼 수 있는 학생의 수를 구하는 프로그램을 작성해라
(어떤 학생이 자기 앞에 서 있는 학생들보다 크면 그 학생은 보이고, 작거나 같으면 보이지 않는다)

- 입력설명
첫 줄에 N 이 입력된다.
그 다음줄에 N 명의 학생의 키가 앞에서부터 순서대로 주어진다.

- 출력설명
선생님이 볼 수 있는 최대학생 수를 출력

- 입력예제1
8
130 135 148 140 145 150 150 153

- 출력예제1
5

 */
public class Main {
    public static void main(String[] args) {
        Main main = new Main();

        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] arr = new int[n];

        for (int i=0; i < n; i++) {
            arr[i] = in.nextInt();
        }

        main.solution(arr);
    }

    private void solution(int[] arr) {
        int result = 1;
        int minValue = arr[0];

        for (int i=1; i < arr.length; i++) {
            if (minValue < arr[i]) {
                minValue = arr[i];
                result++;
            }
        }

        System.out.println(result);
    }
}
