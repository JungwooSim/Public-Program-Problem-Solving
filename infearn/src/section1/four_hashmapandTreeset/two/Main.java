package section1.four_hashmapandTreeset.two;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/*
2. 아나그램(해쉬)
- 설명
Anagram 이란 두 문자열이 알파벳의 나열 순서를 다르지만 그 구성이 일치하면 두 단어는 아나그램이라 한다.
예를 들면, AbaAece 와 baeeACA 는 알파벳을 나열 순서는 다르지만 그 구성을 살펴보면 A(2), a(1), b(1), C(1), e(2) 로 알파벳과 그 개수가 모두 일치하다.
즉 어느 한 단어를 재배열하면 상대편 단어가 될 수 있는 것을 아나그램이라 한다.
길이가 같은 두 개의 단어가 주어지면 두 단어가 아나그램인지 판별하는 프로그램을 작성해라.
아나그램 판별시 대소문자가 구분된다.

- 입력
첫 줄에 첫 번째 단어가 입력되고, 두 번째 줄에 두 번째 단어가 입력된다
단어의 길이는 100을 넘지 않는다.

- 출력
두 단어가 아나그램이면 "YES" 를 출력하고, 아니면 "NO"를 출력한다.

- 예시입력1
AbaAeCe
baeeACA

- 예시출력1
YES

- 예시입력2
abaCC
Caaab

- 예시출력2
NO

 */
public class Main {
    public static void main(String[] args) {
        Main main = new Main();

        Scanner in = new Scanner(System.in);
        String input1 = in.next();
        String input2 = in.next();

//        String input1 = "abaCC";
//        String input2 = "Caaab";

        System.out.println(main.solution(input1, input2));
    }

    private String solution(String input1, String input2) {
        HashMap<Character, Integer> map = new HashMap<>();

        for (char val : input1.toCharArray()) {
            map.put(val, map.getOrDefault(val, 0) + 1);
        }

        for (char val : input2.toCharArray()) {
            if (!map.containsKey(val) || map.get(val) == 0) return "NO";
            else {
                map.put(val, map.get(val) - 1);
            }
        }

        return "YES";
    }
}
