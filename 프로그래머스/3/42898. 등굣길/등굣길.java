class Solution {
    int[][] grid;
    int[][] dp;
    
    public int solution(int m, int n, int[][] puddles) {
        grid = new int[n+1][m+1];
        dp = new int[n+1][m+1];
        
        for(int[] p : puddles) {
            grid[p[1]][p[0]] = -1;
        }
        
        dp[1][1] = 1;
        
        for(int r = 1; r <= n; r++) {
            for(int c = 1; c <= m; c++) {
                if(r == 1 && c == 1) continue;
                if(grid[r][c] == -1) continue;
                dp[r][c] = (dp[r-1][c] + dp[r][c-1]) % 1000000007;
            }
        }
        
        return dp[n][m];
    }
    
}