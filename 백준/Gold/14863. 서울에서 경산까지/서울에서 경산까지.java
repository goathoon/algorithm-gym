import java.io.*;
import java.util.*;

class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static final long NEG = -1L; // 도달 불가를 -1로 표시

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int[][] road = new int[N+1][4];

        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            road[i][0] = Integer.parseInt(st.nextToken());
            road[i][1] = Integer.parseInt(st.nextToken());
            road[i][2] = Integer.parseInt(st.nextToken());
            road[i][3] = Integer.parseInt(st.nextToken());
        }

        long[][] dp = new long[N+1][K+1];
        for (int i = 0; i <= N; i++) Arrays.fill(dp[i], NEG);
        dp[0][0] = 0; // 출발점만 0원으로 도달 가능

        for (int i = 0; i < N; i++) {
            for (int t = 0; t <= K; t++) {
                if (dp[i][t] == NEG) continue; 

                int nt = t + road[i+1][0];
                if (nt <= K) {
                    dp[i+1][nt] = Math.max(dp[i+1][nt], dp[i][t] + road[i+1][1]);
                }

                nt = t + road[i+1][2];
                if (nt <= K) {
                    dp[i+1][nt] = Math.max(dp[i+1][nt], dp[i][t] + road[i+1][3]);
                }
            }
        }

        long ans = 0;
        for (int t = 0; t <= K; t++) {
            ans = Math.max(ans, dp[N][t]);
        }
        System.out.println(ans);
    }
}

