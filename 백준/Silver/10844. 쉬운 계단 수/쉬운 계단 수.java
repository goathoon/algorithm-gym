
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        long[][] dp = new long[101][10];

        for(int k = 1; k < 10; k++){
            dp[1][k] = 1;
            dp[2][k] = 2;
        }
        dp[2][9] = 1;
        dp[2][0] = 1;

        for(int n = 3; n <= N; n++) {
            dp[n-1][0] = dp[n-2][1];
            for(int k = 1; k < 10; k++) {
                if(k == 9) {
                    dp[n][k] = dp[n-1][k-1];
                } else {
                    dp[n][k] = dp[n - 1][k - 1] + dp[n - 1][k + 1];
                }
                dp[n][k] %= 1_000_000_000;
            }
        }
        long answer = 0;
        for(int k = 1; k < 10; k++){
            answer += dp[N][k];
        }
        System.out.println(answer % 1_000_000_000);
    }

}