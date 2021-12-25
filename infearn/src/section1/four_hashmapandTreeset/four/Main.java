package section1.four_hashmapandTreeset.four;

import java.util.HashMap;
import java.util.Scanner;

/*
4. 모든 아나그램 찾기
- 설명
S문자열에서 T문자열과 아나그램이 되는 S의 부분문자열의 개수를 구하는 프로그램을 작성하세요.
아나그램 판별시 대소문자가 구분됩니다. 부분문자열은 연속된 문자열이어야 합니다.

- 입력
첫 줄에 첫 번째 S문자열이 입력되고, 두 번째 줄에 T문자열이 입력됩니다.
S문자열의 길이는 10,000을 넘지 않으며, T문자열은 S문자열보다 길이가 작거나 같습니다.

- 출력
S단어에 T문자열과 아나그램이 되는 부분문자열의 개수를 출력합니다.

- 예시입력1
bacaAacba
abc

- 예시출력1
3
 */
public class Main {
    public static void main(String[] args) {
        Main main = new Main();

        Scanner scanner = new Scanner(System.in);
        String str1 = scanner.next();
        String str2 = scanner.next();

        main.solution(str1, str2);
    }

    private void solution(String A, String B) {
        int answer = 0;
        int L = B.length()-1;
        int lt = 0;
        HashMap<Character, Integer> am = new HashMap<>();
        HashMap<Character, Integer> bm = new HashMap<>();

        for (int i = 0; i < B.length(); i++) {
            bm.put(B.charAt(i), bm.getOrDefault(B.charAt(i), 0) + 1);
        }

        for (int i = 0; i < L; i++) {
            am.put(A.charAt(i), am.getOrDefault(A.charAt(i), 0) + 1);
        }

        for (int i=L; i < A.length(); i++) {
            am.put(A.charAt(i), am.getOrDefault(A.charAt(i), 0) + 1);

            if (am.equals(bm)) answer++;

            if (am.get(A.charAt(lt)) > 1) {
                am.put(A.charAt(lt), am.get(A.charAt(lt)) - 1);
            } else {
                am.remove(A.charAt(lt));
            }

            lt++;
        }

        System.out.println(answer);
    }
}
