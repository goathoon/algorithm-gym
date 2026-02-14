class Solution {
    int solution(int[][] land) {
        int[][] dp = new int[land.length][land[0].length];
        dp[0][0] = land[0][0];
        dp[0][1] = land[0][1];
        dp[0][2] = land[0][2];
        dp[0][3] = land[0][3];
        
        for(int r = 1; r < land.length; r++) {
            dp[r][0] = land[r][0] + Math.max(Math.max(dp[r-1][1], dp[r-1][2]), dp[r-1][3]);
            dp[r][1] = land[r][1] + Math.max(Math.max(dp[r-1][0], dp[r-1][2]), dp[r-1][3]);
            dp[r][2] = land[r][2] + Math.max(Math.max(dp[r-1][0], dp[r-1][1]), dp[r-1][3]);
            dp[r][3] = land[r][3] + Math.max(Math.max(dp[r-1][0], dp[r-1][1]), dp[r-1][2]);
            
        }
        
        int answer = 0;
        for(int c = 0; c < 4; c++) {
            answer = Math.max(answer, dp[land.length-1][c]);
        }
        return answer;
    }
}