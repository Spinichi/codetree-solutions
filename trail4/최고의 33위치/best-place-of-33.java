import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] grid = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                grid[i][j] = sc.nextInt();
            }
        }
        int answer = 0;
        for(int i=0;i<n;i++) {
            for(int j=0;j<n;j++) {
                if(i+2<n&&j+2<n) {
                    int sum =0;
                    for(int x=i;x<=i+2;x++) {
                        for(int y=j;y<=j+2;y++) {
                            sum += grid[x][y];
                        }
                    }
                    answer = Math.max(sum,answer);
                }
            }
        }
        System.out.println(answer);
    }
}