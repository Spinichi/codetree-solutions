import java.util.Scanner;
import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        
        ArrayDeque<Integer> que = new ArrayDeque<>();
        int[] dp = new int[n+2];
        dp[1] = 0;
        dp[2] = 1;
        if(n==1) {
            System.out.println(0);
            return;
        }
        dp[3] = 1;
        int ans = Integer.MAX_VALUE;
        for(int i=4; i<=n; i++) {
            ans = dp[i-1]+1;
            if(i%2==0) ans = Math.min(ans, dp[i/2]+1);
            if(i%3==0) ans = Math.min(ans, dp[i/3]+1);
            if((i+1)%2==0) ans = Math.min(ans, dp[(i+1)/2]+2);
            if((i+1)%3==0) ans = Math.min(ans, dp[(i+2)/3]+2);
            dp[i] = ans;
        }

        System.out.println(dp[n]);

    }
}