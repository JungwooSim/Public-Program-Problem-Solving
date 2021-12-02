import java.util.Arrays;

public class Matrix {
    public static void main(String[] args) {
        solution();
    }

    public static void solution() {
        int a[][] = {{2, 4}, {1, 3}};
        int b[][] = {{3, 1}, {2, 1}};
        int result[][] = new int[a.length][b.length];

        for(int  i = 0; i < a.length; i++){
            for(int j = 0; j < a[0].length; j++){
                for(int k = 0; k < b[0].length; k++){
                    result[i][k] += a[i][j] * b[j][k];
                }
            }
        }
        for (int i = 0; i < result.length; i++) {
            System.out.println(Arrays.toString(result[i]));
        }
    }
}
