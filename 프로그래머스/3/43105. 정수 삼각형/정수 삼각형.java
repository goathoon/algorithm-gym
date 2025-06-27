import java.util.*;
class Solution {
    int[][] dp;
    
    public int solution(int[][] triangle) {
        dp = new int[triangle.length][triangle[triangle.length-1].length];
        dp[0][0] = triangle[0][0];
    
        for(int h = 1; h < triangle.length; h++){
            for(int j = 0; j < h+1; j++) {
                if(j == 0) {
                    dp[h][j] = dp[h-1][0] + triangle[h][0];
                    continue;
                }
                if(j == h) {
                    dp[h][j] = dp[h-1][h-1] + triangle[h][h];
                    continue;
                }
                dp[h][j] = Math.max(dp[h-1][j-1] + triangle[h][j], dp[h-1][j] + triangle[h][j]);
            }
        }
        
        int answer = 0;
        for(int c = 0; c < dp[dp.length-1].length; c++){
            answer = Math.max(answer, dp[dp.length-1][c]);
        }
        
        return answer;
    }
}