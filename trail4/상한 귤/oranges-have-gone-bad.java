import java.util.Scanner;
import java.util.*;

public class Main {
    static int[] dr= {1,-1,0,0};
    static int[] dc = {0,0,1,-1};
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int[][] grid = new int[n][n];
        ArrayDeque<int[]> currentGo = new ArrayDeque<>();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                grid[i][j] = sc.nextInt();
                if(grid[i][j]==2) currentGo.offer(new int[] {i,j,0});
            }
        }   

        int[][] answer = new int[n][n];     

        while(!currentGo.isEmpty()) {
            int[] gul = currentGo.poll();
            int r= gul[0];
            int c= gul[1];
            int time = gul[2];
            for(int d=0;d<4;d++) {
                int nextR = r+dr[d];
                int nextC = c+dc[d];
                if(nextR>=0 && nextR<n && nextC >=0 && nextC<n && grid[nextR][nextC]==1 && answer[nextR][nextC]==0) {
                    currentGo.offer(new int[] {nextR,nextC,time+1});
                    grid[nextR][nextC] = 2;
                    answer[nextR][nextC] = time+1;
                }
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if(grid[i][j]==0) answer[i][j]=-1;
                else if(grid[i][j]==1) answer[i][j]=-2;
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n-1; j++) {
                sb.append(answer[i][j]).append(" ");
            }
            sb.append(answer[i][n-1]).append("\n");
        } 
        System.out.print(sb);
    }
}