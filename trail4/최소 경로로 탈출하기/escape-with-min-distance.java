import java.util.Scanner;
import java.util.ArrayDeque;
public class Main {
    static int[] dr= {1,-1,0,0};
    static int[] dc= {0,0,1,-1};
    static int N,M;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        N = n;
        M = m;
        int[][] a = new int[n][m];
        for (int i = 0; i < n; i++)
            for (int j = 0; j < m; j++)
                a[i][j] = sc.nextInt();
        int answer = -1;
        boolean[][] visited= new boolean[n][m];
        ArrayDeque<int[]> que = new ArrayDeque<>();
        que.offer(new int[] {0,0});
        visited[0][0] =true;
        while(!que.isEmpty()) {
            int[] curPosi = que.poll();
            int r = curPosi[0];
            int c = curPosi[1];
            if(r==n-1&&c==m-1) {
                break;
            }
            for(int d=0;d<4;d++) {
                int nextR = r +dr[d];
                int nextC = c +dc[d];
                if(check(nextR,nextC) && a[nextR][nextC] !=0 && !visited[nextR][nextC]) {
                    que.offer(new int[] {nextR,nextC});
                    visited[nextR][nextC] =true;
                    a[nextR][nextC] = a[r][c] +1;
                }
            }
        }
        if(a[n-1][m-1]==1) System.out.println(-1);
        else System.out.println(a[n-1][m-1]-1);
    }

    public static boolean check(int r, int c) {
        return r>=0 && r<N && c>=0 && c<M;
    }
}