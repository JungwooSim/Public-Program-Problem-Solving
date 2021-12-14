package section1.one_string.findlongword;

public class Main {
    public static void main(String[] args) {
        Main main = new Main();
//        Scanner in = new Scanner(System.in);
//        String input = in.nextLine();
        String input = "it is time to study";

//        System.out.println(main.solution(input));
        System.out.println(main.solution2(input));
    }

    //내가 푼 코드
    public String solution(String str) {
        int maxCount = 0;
        int maxStart = 0;

        String[] strSplit = str.split(" ");
        for (int i=0; i < strSplit.length; i++) {
            if (maxCount < strSplit[i].length()) {
                maxCount = strSplit[i].length();
                maxStart = i;
            }
        }

        return strSplit[maxStart];
    }

    //정답
    public String solution2(String str) {
        String answer = "";
        int m = Integer.MIN_VALUE;

        String[] strSplit = str.split(" ");
        for (String x : strSplit) {
            if (m < x.length()) {
                m = x.length();
                answer = x;
            }
        }

        return answer;
    }
}
