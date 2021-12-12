package section1.string.findstring;

import java.util.Scanner;
import java.util.function.Predicate;

/*
1. 문자 찾기
설명
한 개의 문자열을 입력받고, 특정 문자를 입력받아 해당 특정문자가 입력받은 문자열에 몇 개 존재하는지 알아내는 프로그램을 작성하세요.
대소문자를 구분하지 않습니다.문자열의 길이는 100을 넘지 않습니다.

입력
첫 줄에 문자열이 주어지고, 두 번째 줄에 문자가 주어진다.
문자열은 영어 알파벳으로만 구성되어 있습니다.

출력
첫 줄에 해당 문자의 개수를 출력한다.
 */
public class Main {
    public static void main(String[] args){
        Main me = new Main();
        Scanner in = new Scanner(System.in);
//        String input1 = in.next();
//        char input2 = in.next().charAt(0);
        String input1 = "Computercooler";
        char input2 = 'c';

        System.out.println(me.solution(input1, input2));
        System.out.println(me.solution2(input1, input2));
        System.out.println(me.solution3(input1, input2));
    }

    //내가 푼것
    public long solution(String input, char findChar) {
        Predicate<Integer> predicate = (value) -> value == findChar;
        return input.toLowerCase().chars().filter(predicate::test).count();
    }

    //정답
    public static int solution2(String input, char findChar) {
        int answer = 0;
        input = input.toUpperCase();
        findChar = Character.toUpperCase(findChar);

        for (int i=0; i < input.length(); i++) {
            if (input.charAt(i) == findChar) answer++;
        }

        return answer;
    }

    //정답
    public static int solution3(String input, char findChar) {
        int answer = 0;
        input = input.toUpperCase();
        findChar = Character.toUpperCase(findChar);

        for (char x : input.toCharArray()) {
            if (x == findChar) answer++;
        }

        return answer;
    }
}

