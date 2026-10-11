import java.util.Scanner;
import java.util.ArrayDeque;
import java.util.*;
public class Main {
    static int[] dr = {-1,-2,-2,-1,1,2,2,1};
    static int[] dc = {-2,-1,1,2,2,1,-1,-2};
    static int N;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int r1 = sc.nextInt();
        int c1 = sc.nextInt();
        int r2 = sc.nextInt();
        int c2 = sc.nextInt();
        int[][] map = new int[n][n];
        N = n;
        boolean[][] visited = new boolean[n][n];
        r1--;
        c1--;
        r2--;
        c2--;

        if(r1==r2 && c1==c2) {
            System.out.println(0);
            return;
        }
        ArrayDeque<int[]> que = new ArrayDeque<>();
        que.offer(new int[] {r1,c1});
        visited[r1][r1] = true;
        while(!que.isEmpty()) {
            int[] cur = que.poll();
            int r = cur[0];
            int c = cur[1];
            if(r==r2&&c==c2) break;
            for(int d =0; d<8; d++) {
                int nextR = r+dr[d];
                int nextC = c+dc[d];
                if(check(nextR,nextC) && !visited[nextR][nextC]) {
                    que.offer(new int[] {nextR,nextC});
                    visited[nextR][nextC] = true;
                    map[nextR][nextC] = map[r][c]+1;
                }
            }
        }
        if(map[r2][c2]==0) System.out.println(-1);
        else System.out.println(map[r2][c2]);
    }
    public static boolean check(int r,int c) {
        return r>=0 && r<N && c>=0 && c<N;
    }
}