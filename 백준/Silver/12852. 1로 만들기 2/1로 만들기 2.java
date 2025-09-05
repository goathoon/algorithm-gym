

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(br.readLine());
        int[] dp = new int[n+1];

        for(int i = 0; i <= n; i++){
            dp[i] = 1000000;
        }

        dp[n] = 0;
        Queue<Integer> q = new LinkedList<>();
        q.add(n);

        while(!q.isEmpty()){
            Integer cur = q.poll();
            if(cur == 1) {
                System.out.println(dp[1]);
                printUpper(dp);
                break;
            }
            if(cur % 3 == 0) {
                if (dp[cur/3] > dp[cur] + 1) {
                    q.add(cur / 3);
                    dp[cur/3] = dp[cur] + 1;
                }
            }
            if(cur % 2 == 0) {
                if(dp[cur/2] > dp[cur] + 1) {
                    q.add(cur / 2);
                    dp[cur/2] = dp[cur] + 1;
                }
            }
            if(dp[cur-1] > dp[cur] + 1) {
                q.add(cur - 1);
                dp[cur-1] = dp[cur] + 1;
            }
        }
    }

    static void printUpper(int[] dp) {
        List<Integer> list = new ArrayList<>();
        int cur = 1;
        list.add(cur);

        while(cur < dp.length) {
            if (cur * 3 < dp.length && dp[cur * 3] == dp[cur] - 1) {
                list.add(cur * 3);
                cur = cur * 3;
            } else if (cur * 2 < dp.length && dp[cur * 2] == dp[cur] - 1) {
                list.add(cur * 2);
                cur = cur * 2;
            } else {
                if(cur + 1 < dp.length)
                    list.add(cur + 1);
                cur = cur + 1;
            }
        }

        StringBuilder sb = new StringBuilder();
        for(int i = list.size()-1; i >= 0; i--) {
            sb.append(list.get(i) + " ");
        }
        System.out.println(sb);
    }

}