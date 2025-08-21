

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int[][] dp;
    // row : 돌의 위치 col : 해당 돌의 위치를 도달할때 뛰었던 점프거리
    // 값 : dp[3][2] -> 3의 돌 위치에 왔을때 2칸 점프 뛰어서 온 최소 점프 횟수
    // 이 때, dp[x][0] 의 열이 0번째인 위치의 값은 도달할 수 있는지 여부를 포함한다.

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        dp = new int[N+1][201];
        for(int m = 0; m < M; m++) {
            dp[Integer.parseInt(br.readLine())][0] = -1;
        }
        for(int i = 1; i <= N; i++) {
            for(int j = 1; j < dp[0].length; j++) {
                dp[i][j] = 1000000;
            }
        }

        dp[1][0] = 0;
        if(dp[2][0] == -1) {
            System.out.println(-1);
            System.exit(0);
        }
        dp[2][1] = 1;

        // i번째 돌에 도달할때 j만큼 점프 뛰었을때의 점프 횟수의 최소값 저장
        for(int i = 3; i <= N; i++) {
            for(int j = 1; j < dp[i].length; j++) {
                if(i-j >= 1 && dp[i-j][0] == -1) continue;

                if(j == 1) { // 한칸밖에 안뛰었을 경우, 이전에는 두칸 or 한칸 뜀
                    dp[i][j] = Math.min(dp[i - j][j + 1] + 1, dp[i - j][j] + 1);
                } else {
                    if(i-j >= 1) {
                        dp[i][j] = Math.min(dp[i - j][j - 1] + 1, dp[i - j][j] + 1);
                        if(j+1 < dp[i].length) {
                            dp[i][j] = Math.min(dp[i][j],  dp[i - j][j + 1] + 1);
                        }
                    }
                }
            }
        }
        int ans = Integer.MAX_VALUE;
        for(int i = 1; i < dp[0].length; i++) {
            ans = Math.min(dp[N][i], ans);
        }
        System.out.println(ans);

    }


}