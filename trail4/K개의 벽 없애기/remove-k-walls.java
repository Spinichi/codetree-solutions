import java.util.Scanner;
import java.util.*;
public class Main {
    static int[][] map;
    static int N;
    static int K;
    static int wallCnt;
    static boolean[][] visited;
    static boolean[] selectedWalls;
    static int[] dr = {1,-1,0,0};
    static int[] dc = {0,0,1,-1};
    static ArrayList<Integer> walls;
    static int answer;
    static int r1,c1,r2,c2,n;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        int k = sc.nextInt();
        N = n;
        K = k;
        int[][] grid = new int[n][n];
        walls = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                grid[i][j] = sc.nextInt();
                if(grid[i][j]==1) {
                    walls.add(i*n+j);
                }
            }
        }
        wallCnt = walls.size();
        r1 = sc.nextInt();
        c1 = sc.nextInt();
        r2 = sc.nextInt();
        c2 = sc.nextInt();

        map = new int[n][n];
        for(int i=0;i<n;i++) {
            map[i] = Arrays.copyOf(grid[i],n);
        }
        answer = Integer.MAX_VALUE/10;
        r1--;
        c1--;
        r2--;
        c2--;
        selectedWalls = new boolean[wallCnt];
        selectWalls(0,0);

        
        
        if(answer==Integer.MAX_VALUE/10) answer = -1;
        System.out.println(answer);
    }

    public static void selectWalls(int idx, int depth) {
        if(depth==K) {
            for (int i =0;i<wallCnt;i++) {
                if(selectedWalls[i]) {
                    int a = walls.get(i);
                    map[a/n][a%n] = 0;
                }
            }
            BFS();
            for (int i =0;i<wallCnt;i++) {
                if(selectedWalls[i]) {
                    int a = walls.get(i);
                    map[a/n][a%n] = 1;
                }
            }

            return;
        }
        for(int i =idx;i<wallCnt;i++) {
            if(selectedWalls[i]) continue;
            selectedWalls[i] = true;
            selectWalls(i+1,depth+1);
            selectedWalls[i] = false;
        }
    }

    public static boolean check(int r, int c) {
        return r>=0 && r<N && c>=0 && c<N;
    }

    public static void BFS() {
        visited = new boolean[n][n];
        ArrayDeque<int[]> que = new ArrayDeque<>();
        visited[r1][c1] = true;
        que.offer(new int[] {r1,c1,0});
        
        // 클래스 만들기 귀찮아서 int 배열로 해결하는 습관.
        // 맵 만들고 새기기 귀찮아서 그냥 배열에 들고다니는 습관.
        while(!que.isEmpty()) {
            int[] arr = que.poll();
            int r = arr[0];
            int c = arr[1];
            int curTime = arr[2];
            if(r==r2&&c==c2){
                answer = Math.min(answer,curTime);
                break;
            }
            for(int d=0;d<4;d++) {
                int nextR = r +dr[d];
                int nextC = c +dc[d];
                if(check(nextR,nextC) && map[nextR][nextC]==0) {
                    if(!visited[nextR][nextC]) {
                        visited[nextR][nextC] = true;
                        que.offer(new int[] {nextR,nextC,curTime+1});
                    }
                }
            }
        }
    }

}
