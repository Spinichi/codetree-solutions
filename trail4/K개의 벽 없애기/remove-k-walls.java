import java.util.Scanner;
import java.util.*;
public class Main {
    static int[][] map;
    static int N;
    static int K;
    static int wallCnt;
    static boolean[][][] visited;
    static boolean[] selectedWalls;
    static int[] dr = {1,-1,0,0};
    static int[] dc = {0,0,1,-1};
    static ArrayList<Integer> walls;
    static int answer;
    static int r1,c1,r2,c2,n,k;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        k = sc.nextInt();
        N = n;
        K = k;
        int[][] grid = new int[n][n];
        walls = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                grid[i][j] = sc.nextInt();
            }
        }
        r1 = sc.nextInt();
        c1 = sc.nextInt();
        r2 = sc.nextInt();
        c2 = sc.nextInt();

        map = new int[n][n];
        for(int i=0;i<n;i++) {
            map[i] = Arrays.copyOf(grid[i],n);
        }
        answer = -1;
        r1--;
        c1--;
        r2--;
        c2--;
        

        visited = new boolean[n][n][k+1];
        ArrayDeque<int[]> que = new ArrayDeque<>();
        visited[r1][c1][0] = true;
        que.offer(new int[] {r1,c1,0,0});
        
        // 클래스 만들기 귀찮아서 int 배열로 해결하는 습관.
        // 맵 만들고 새기기 귀찮아서 그냥 배열에 들고다니는 습관.
        while(!que.isEmpty()) {
            int[] arr = que.poll();
            int r = arr[0];
            int c = arr[1];
            int curTime = arr[2];
            int cnt = arr[3];
            if(r==r2&&c==c2&&cnt<=k){
                answer = curTime;
                break;
            }
            for(int d=0;d<4;d++) {
                int nextR = r +dr[d];
                int nextC = c +dc[d];
                if(check(nextR,nextC)) {
                    if(map[nextR][nextC]==0) {
                        if(!visited[nextR][nextC][cnt]) {
                            visited[nextR][nextC][cnt] = true;
                            que.offer(new int[] {nextR,nextC,curTime+1,cnt});
                        }
                    } else {
                        if(cnt<k && !visited[nextR][nextC][cnt+1]) {
                            visited[nextR][nextC][cnt+1] = true;
                            que.offer(new int[] {nextR,nextC,curTime+1,cnt+1});
                        }
                    }
                }
            }
        }

        
        
        if(answer==Integer.MAX_VALUE/10) answer = -1;
        System.out.println(answer);
    }

    public static boolean check(int r, int c) {
        return r>=0 && r<N && c>=0 && c<N;
    }
}
