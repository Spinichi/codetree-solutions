import java.util.Scanner;
  
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[][] grid = new int[n][n];
        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++)
                grid[i][j] = sc.nextInt();
        
        int answer = 0;
       for(int i=0;i<n;i++) {
        int before = -1;
        int cnt = 1;
        for(int j=0;j<n;j++) {
            if(grid[i][j]==before){
                cnt++;
            } else {
                before = grid[i][j];
                cnt = 1;
            }
            if(cnt==m) {
                answer++;
                break;
            }
        }

        before = -1;
        cnt = 1;
        for(int j=0;j<n;j++) {
            if(grid[j][i]==before){
                cnt++;
            } else {
                before = grid[j][i];
                cnt = 1;
            }
            if(cnt==m) {
                answer++;
                break;
            }
        }
       }

       System.out.println(answer);
    }
}