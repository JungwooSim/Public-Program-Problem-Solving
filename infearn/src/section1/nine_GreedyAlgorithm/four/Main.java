package section1.nine_GreedyAlgorithm.four;

import java.util.ArrayList;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Scanner;

/*
4. 최대 수입 스케쥴(PriorityQueue 응용문제)
- 설명
현수는 유명한 강연자이다. N개의 기업에서 강연 요청을 해왔다. 각 기업은 D일 안에 와서 강연을 해 주면 M만큼의 강연료를 주기로 했다.
각 기업이 요청한 D와 M를 바탕으로 가장 많을 돈을 벌 수 있도록 강연 스케쥴을 짜야 한다.
단 강연의 특성상 현수는 하루에 하나의 기업에서만 강연을 할 수 있다.

- 입력
첫 번째 줄에 자연수 N(1<=N<=10,000)이 주어지고, 다음 N개의 줄에 M(1<=M<=10,000)과 D(1<=D<=10,000)가 차례로 주어진다.

- 출력
첫 번째 줄에 최대로 벌 수 있는 수입을 출력한다.

- 예시 입력1
6
50 2
20 1
40 2
60 3
30 3
30 1

- 예시 출력1
150

 */
class Job implements Comparable<Job> {
    int d; // 기한
    int m; // 강연료

    public Job(int m, int d) {
        this.m = m;
        this.d = d;
    }

    @Override
    public int compareTo(Job o) {
        if (this.d == o.d) return o.m - this.m;
        return o.d - this.d;
    }
}

public class Main {
    static int maxD = Integer.MIN_VALUE;
    public static void main(String[] args) {
        Main main = new Main();

        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();


        ArrayList<Job> jobList = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            int m = scanner.nextInt();
            int d = scanner.nextInt();
            jobList.add(
                    new Job(m, d)
            );

            if (maxD < d) maxD = d;
        }
        Collections.sort(jobList);

        main.solution(jobList);
    }

    private void solution(ArrayList<Job> jobList) {
        int answer = 0;
        PriorityQueue<Integer> pQ = new PriorityQueue<>(Collections.reverseOrder());

        int j = 0;
        for (int i = maxD; i >= 1; i--) {
            for (; j < jobList.size() ; j++) {
                if (jobList.get(j).d < i) break;
                pQ.add(jobList.get(j).m);
            }
            if (!pQ.isEmpty()) answer += pQ.poll();
        }

        System.out.println(answer);
    }
}
