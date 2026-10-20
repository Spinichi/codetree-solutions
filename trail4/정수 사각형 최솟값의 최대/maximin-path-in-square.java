import java.util.Scanner;
import java.util.*;
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
        int[][] min = new int[n][n];
        min[0][0] = matrix[0][0];
        if(n==1) {
            System.out.println(min[0][0]);
            return;
        }
        for(int i=1;i<n;i++) {
            min[0][i] = Math.min(matrix[0][i],min[0][i-1]);
        }
        for(int i=1;i<n;i++) {
            min[i][0] = Math.min(matrix[i][0],min[i-1][0]);
            for(int j=1;j<n;j++) {
                min[i][j] = Math.min(matrix[i][j],Math.max(min[i][j-1],min[i-1][j]));
                
            }
        }
        System.out.println(min[n-1][n-1]);
    }
}