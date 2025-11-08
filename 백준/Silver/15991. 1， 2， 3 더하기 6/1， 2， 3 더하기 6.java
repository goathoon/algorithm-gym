
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[] dp = new int[100001];

        dp[0] = 0;
        dp[1] = 1; // 1
        dp[2] = 2; // 11, 2
        dp[3] = 2; // 111, 3
        dp[4] = 3; // 1111, 22, 121
        dp[5] = 3; // 11111, 131, 212
        dp[6] = 6; // 111111, 1221, 11211,2112,222, 33

        for(int i = 7; i< dp.length; i++) {
            int add = dp[i-2]; // 양 옆 1로 대칭되는 경우
            // 양 옆 2로 대칭되는 경우
            add += dp[i-4];
            add %= 1_000_000_009;
            // 양 옆 3으로 대칭되는 경우
            add += dp[i-6];
            add %= 1_000_000_009;

            dp[i] = add;
        }

        for(int i = 0; i < N; i++) {
            int n = Integer.parseInt(br.readLine());
            System.out.println(dp[n]);
        }
    }
}