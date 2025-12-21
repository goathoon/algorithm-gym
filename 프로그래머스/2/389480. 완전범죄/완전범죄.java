import java.util.*;

class Solution {
    public int solution(int[][] info, int n, int m) {
        int[][] dp = new int[info.length][m];
        for(int i = 0; i < dp.length; i++) {
            for(int j = 0; j < m; j++) {
                dp[i][j] = 130;
            }
        }
        
        dp[0][0] = info[0][0];
        if(info[0][1] < dp[0].length) {
            dp[0][info[0][1]] = 0;
        }
        
        for (int i = 1; i < dp.length; i++) {
            for(int j = 0; j < dp[0].length; j++) {
                // A 선택
                dp[i][j] = Math.min(dp[i][j], dp[i-1][j] + info[i][0]);
                // B 선택
                if(j + info[i][1] < dp[0].length) {
                    dp[i][j+info[i][1]] = Math.min(dp[i][j+info[i][1]], dp[i-1][j]);
                }
            }
        }
        
        int answer = Integer.MAX_VALUE;
        
        for(int j = 0; j < dp[0].length; j++) {
            if (dp[info.length-1][j] < n) {
                answer = Math.min(dp[info.length-1][j], answer);
            }
        }
        
        if(answer == Integer.MAX_VALUE) {
            return -1;
        }
        return answer;
        
    }
}