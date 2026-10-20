import java.util.Scanner;
import java.util.*;

public class Main {
    static int[] dr={-1,1,0,0};
    static int[] dc={0,0,1,-1};
    static int n;
    static int[][] dp;
    static int[][] grid;
    static boolean[][] check;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        grid = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                grid[i][j] = sc.nextInt();
            }
        }
        // Please write your code here.
        dp = new int[n][n];
        for(int[] i : dp) {
            Arrays.fill(i,1);
        }

        check = new boolean[n][n];
        
        for(int i=0;i<n;i++) {
            for(int j=0;j<n;j++) {
                if(check[i][j]) continue;
                check[i][j] = true;
                dp[i][j] = DFS(i,j);
            }
        }

        int max = -1;


         for(int i=0;i<n;i++) {
            for(int j=0;j<n;j++) {
                max = Math.max(max,dp[i][j]);
            }
        }
        System.out.println(max);
    }

    public static int DFS(int r,int c) {
        for(int d=0;d<4;d++) {
            int nextR = r + dr[d];
            int nextC = c + dc[d];
            if(nextR>=0 && nextR<n && nextC>=0 && nextC<n && grid[r][c]<grid[nextR][nextC]) {
                if(check[nextR][nextC]) {
                    dp[r][c] = Math.max(dp[r][c],dp[nextR][nextC]+1);
                } else {
                    check[nextR][nextC] = true;
                    dp[r][c] = Math.max(DFS(nextR,nextC)+1,dp[r][c]);
                }
            }
        }
        return dp[r][c];
    }
}