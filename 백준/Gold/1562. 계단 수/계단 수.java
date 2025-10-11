

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        long[][][] dp = new long[101][10][1024];

        for(int k = 0; k < 10; k++){
            dp[1][k][1<<k] = 1;
        }

        for(int n = 2; n <= N; n++) {
            for(int k = 0; k < 10; k++) {
                for(int bit = 0; bit <= 1023; bit++) {
                    if(k >= 1 && dp[n-1][k-1][bit] != 0) {
                        dp[n][k][1<<k | bit] += dp[n-1][k-1][bit];
                        dp[n][k][1<<k | bit] %= 1_000_000_000;
                    }
                    if(k+1 <= 9 && dp[n-1][k+1][bit] != 0) {
                        dp[n][k][1<<k | bit] += dp[n-1][k+1][bit];
                        dp[n][k][1<<k | bit] %= 1_000_000_000;
                    }
                }
            }
        }
        long answer = 0;
        for(int k = 1; k < 10; k++) {
            answer += dp[N][k][1023];
            answer %= 1_000_000_000;
        }
        System.out.println(answer);
    }

}