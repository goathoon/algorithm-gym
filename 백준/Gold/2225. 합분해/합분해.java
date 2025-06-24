

import java.io.*;
import java.util.*;

class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine(), " ");
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        long[][] dp = new long[k+1][n+1];

        long div = 1_000_000_000;
        for(int num = 0; num <= n; num++){
            dp[1][num] = 1;
        }

        for(int cnt = 1; cnt <= k; cnt++ ){
            for(int num = 0 ; num <= n; num++) {
                if(num == 0) {
                    dp[cnt][num] = 1;
                    continue;
                }
                for(int x = 0; x <= num; x++){
                    dp[cnt][num] += dp[cnt-1][x];
                    dp[cnt][num] %= div;
                }
            }
        }
        System.out.println(dp[k][n] % div);
    }
}

