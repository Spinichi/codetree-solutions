import java.util.*;
public class Main {
    static int[] dr={1,-1,0,0};
    static int[] dc={0,0,1,-1};
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[][] grid = new int[n][m];
        for (int i = 0; i < n; i++)
            for (int j = 0; j < m; j++)
                grid[i][j] = sc.nextInt();
        ArrayDeque<int[]> que = new ArrayDeque<>();
        que.offer(new int[] {0,0});
        grid[0][0] = -1;
        while(!que.isEmpty()) {
            int[] arr = que.poll();
            int r = arr[0];
            int c = arr[1];
            for(int d=0;d<4;d++) {
                int nr = r +dr[d];
                int nc = c +dc[d];
                if(nr>=0&&nr<n&&nc>=0&&nc<m&&grid[nr][nc]==1) {
                    que.offer(new int[] {nr,nc});
                    grid[nr][nc] = -1;
                }
            }
        }
        if(grid[n-1][m-1]==-1) System.out.println(1);
        else System.out.println(0);
    }
}