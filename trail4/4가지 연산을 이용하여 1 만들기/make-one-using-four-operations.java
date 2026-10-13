import java.util.Scanner;
import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        
        ArrayDeque<int[]> que = new ArrayDeque<>();
        boolean[] visited = new boolean[n+3];
        que.offer(new int[] {n,0});
        visited[n] = true;
        int answer = -1;
        while(!que.isEmpty()) {
            int[] arr = que.poll();
            int curNum = arr[0];
            int cnt = arr[1];
            if(curNum==1) {
                answer = cnt;
                break;
            }
            if(!visited[curNum-1]) {
                que.offer(new int[] {curNum-1,cnt+1});
                visited[curNum-1] = true;
            }
            if(curNum+1 < n+3 && !visited[curNum+1]) {
                que.offer(new int[] {curNum+1,cnt+1});
                visited[curNum+1] = true;
            }
            if(curNum%2==0 && !visited[curNum/2]) {
                que.offer(new int[] {curNum/2,cnt+1});
                visited[curNum/2] = true;
            }
            if(curNum%3==0 && !visited[curNum/3]) {
                que.offer(new int[] {curNum/3,cnt+1});
                visited[curNum/3] = true;
            }
        }
     System.out.println(answer);

    }
}