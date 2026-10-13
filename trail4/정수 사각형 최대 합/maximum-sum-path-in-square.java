import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] matrix = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                matrix[i][j] = sc.nextInt();
            }
        }
        for(int j=1;j<n;j++) {
            matrix[0][j] += matrix[0][j-1];
        }
        for(int i=1;i<n;i++) {
            matrix[i][0] += matrix[i-1][0];
            for(int j=1;j<n;j++) {
                matrix[i][j] += Math.max(matrix[i-1][j],matrix[i][j-1]);
            }
        }
        System.out.println(matrix[n-1][n-1]);
    }
}