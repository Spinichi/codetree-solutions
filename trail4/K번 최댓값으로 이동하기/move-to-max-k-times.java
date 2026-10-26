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
        int r = sc.nextInt()-1;
        int c = sc.nextInt()-1;
        // Please write your code here.

        while(k-->0) {
            int target = grid[r][c];
            ArrayDeque<int[]> que = new ArrayDeque<>();
            int[] next = new int[2];
            int max = -1;
            boolean[][] visited = new boolean[n][n];
            que.offer(new int[] {r,c});
            visited[r][c] = true;
            while(!que.isEmpty()) {
                int[] arr = que.poll();
                int rr = arr[0];
                int cc = arr[1];
                for(int d=0;d<4;d++) {
                    int nr = rr + dr[d];
                    int nc = cc + dc[d];
                    if(nr>=0&&nr<n&&nc>=0&&nc<n&&target>grid[nr][nc]&&!visited[nr][nc]) {
                        que.offer(new int[] {nr,nc});
                        visited[nr][nc] = true;
                        if(grid[nr][nc]>max) {
                            max = grid[nr][nc];          
                            next[0] = nr;
                            next[1] = nc;
                        } else if (grid[nr][nc]==max) {
                            if(next[0]>nr) {
                                next[0] = nr;
                                next[1] = nc;
                            } else if(next[0]==nr && next[1]>nc) {
                                next[0] = nr;
                                next[1] = nc;
                            }
                        }
                    }
                }
            }

            
            if(max==-1) break;
            r = next[0];
            c = next[1];
        }
        System.out.println((r+1) + " "+ (c+1));
    }
}