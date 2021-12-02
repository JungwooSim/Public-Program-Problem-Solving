public class Gugudan {
    public static void main(String[] args) {
        solution(); // 1안
    }

    public static void solution() {
        int startDan = 2;
        int lineCount = 3;
        int endDan = 9;
        for (int n=0; n < lineCount; n++) {
            for (int i=1; i <= 9; i++) {
                for (int j = startDan; j < startDan + lineCount; j++) {
                    if (endDan < j) break;
                    System.out.printf("%d * %d = %d | ", j, i, i * j);
                }
                System.out.println();
            }
            startDan = startDan + lineCount;
        }
    }

}
