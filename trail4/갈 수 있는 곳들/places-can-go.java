import java.util.*;
public class Main {
    static int[] dr = {1,-1,0,0};
    static int[] dc = {0,0,1,-1};
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int[][] grid = new int[n][n];
        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++)
                grid[i][j] = sc.nextInt();
        int[][] starts = new int[k][2];
        for (int i = 0; i < k; i++) {
            starts[i][0] = sc.nextInt()-1;
            starts[i][1] = sc.nextInt()-1;
        }
        // Please write your code here.
        int answer = 0;
        ArrayDeque<int[]> que = new ArrayDeque<>();
        for(int[] arr : starts) {
            que.offer(new int[] {arr[0],arr[1]});
            answer++;
            grid[arr[0]][arr[1]] = -1;
        }
        while(!que.isEmpty()) {
            int[] a = que.poll();
            int r = a[0];
            int c = a[1];
            for(int d=0; d<4; d++) {
                int nr = r +dr[d];
                int nc = c +dc[d];
                if(nr>=0&&nr<n&&nc>=0&&nc<n&&grid[nr][nc]==0) {
                    que.offer(new int[] {nr,nc});
                    answer++;
                    grid[nr][nc]=-1;
                }
            }
        }
        System.out.println(answer);
        
    }
}