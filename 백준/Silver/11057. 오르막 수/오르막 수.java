import java.io.*;
import java.util.*;

class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(br.readLine());
        long[][] dp = new long[n+1][10];

        for(int i = 0; i < 10; i++){
            dp[1][i] = 1;
        }

        for(int num = 2; num <= n; num++){
            for(int next = 0; next < 10; next++){
                for(int before = next; before >= 0; before--){
                    dp[num][next] += dp[num-1][before] % 10007;
                }
            }
        }

        long ans = 0;
        for(int i = 0; i < 10; i++) {
            ans += dp[n][i];
        }

        System.out.println(ans%10007);
    }
}