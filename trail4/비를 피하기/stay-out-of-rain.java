import java.util.Scanner;
import java.util.*;

public class Main {
    /*
    0 -> 이동가능 칸
    1 -> 벽이 있어 이동 불가
    2 -> 사람
    3 -> 비를 피하는 공간
    2 -> 0을 밟아 3으로 BFS 그 숫자 넣기
    첫줄 -> N(격자크기), H(사람의 수), M(비 피하는 칸 갯수)
    */
    static int[] dr = {1,-1,0,0};
    static int[] dc = {0,0,1,-1};
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int h = sc.nextInt();
        int m = sc.nextInt();
        int[][] a = new int[n][n];
        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++)
                a[i][j] = sc.nextInt();
        boolean[][] visited = new boolean[1][1];
        int[][] map = new int[n][n];
        for (int i=0; i<n;i++) {
            for(int j=0;j<n;j++) {
                if(a[i][j]==2) {
                    visited = new boolean[n][n];
                    ArrayDeque<int[]> que = new ArrayDeque<>();
                    que.offer(new int[] {i,j,0});
                    visited[i][j] = true;
                    while(!que.isEmpty()) {
                        int[] cur = que.poll();
                        int r = cur[0];
                        int c = cur[1];
                        int cnt = cur[2];
                        if (a[r][c]==3) {
                            map[i][j] = cnt;
                            break;
                        }
                        for(int d=0;d<4;d++) {
                            int nextR = r+dr[d];
                            int nextC = c+dc[d];
                            if(nextR>=0&&nextR<n&&nextC>=0&&nextC<n&& a[nextR][nextC] !=1 && !visited[nextR][nextC]){
                                que.offer(new int[] {nextR,nextC,cnt+1});
                                visited[nextR][nextC] = true;
                            }
                        }

                    }
                    if(map[i][j]==0) map[i][j]=-1;
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<n;i++) {
            for(int j=0;j<n-1;j++) {
                sb.append(map[i][j]).append(" ");
            }
            sb.append(map[i][n-1]).append("\n");
        }
        System.out.print(sb);
    }
}