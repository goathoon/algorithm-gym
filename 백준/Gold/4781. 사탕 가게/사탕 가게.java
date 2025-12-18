

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static Pair[] pairs;
    public static void main(String[] args) throws IOException {

        while(true) {
            st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            if (N == 0) break;
            pairs = new Pair[N+1];
            Float dd = Float.parseFloat(st.nextToken());
            int money = (int)(dd * 100 + 0.1);
            for(int n = 1; n <= N; n++) {
                st = new StringTokenizer(br.readLine());
                int c = Integer.parseInt(st.nextToken());
                Float d = Float.parseFloat(st.nextToken());
                int i = (int)(d * 100 + 0.1);
                pairs[n] = new Pair(c, i);
            }
            System.out.println(answer(N, money));
        }

    }

    static int answer(int cnt, int money) {
        int[] dp = new int[money+1];
        for(int m = 1; m <= money; m++) {
            for(int c = 1; c <= cnt; c++){
                if(m - pairs[c].money >= 0) {
                    dp[m] = Math.max(dp[m], pairs[c].calory + dp[m-pairs[c].money]);
                }
            }
        }
        return dp[money];
    }

    static class Pair {
        int calory;
        int money;
        Pair(int calory, int money) {
            this.calory = calory;
            this.money = money;
        }

    }

}