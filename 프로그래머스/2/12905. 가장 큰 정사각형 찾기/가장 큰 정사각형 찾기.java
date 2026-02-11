class Solution
{
    public int solution(int [][]board)
    {
        int[][] dp = new int[board.length+1][board[0].length+1];
        
        int answer = 0;
        
        for(int r = 1; r < dp.length; r++) {
            for(int c = 1; c < dp[0].length; c++) {
                int boardRow = r - 1;
                int boardCol = c - 1;
                
                if(board[boardRow][boardCol] == 1) {
                    if(dp[r-1][c-1] > 0) {
                        int length = dp[r-1][c-1];
                        boolean isFirst = false;

                        if(dp[r-1][c] >= length && dp[r][c-1] >= length) {
                            dp[r][c] = dp[r-1][c-1] + 1;
                        } else {
                            dp[r][c] = Math.min(dp[r-1][c] + 1, dp[r][c-1] + 1);
                        }
                    } else {
                        dp[r][c] = 1;
                    }
                    
                    answer = Math.max(answer, dp[r][c]);
                }
            }
        }
        return answer * answer;
    }
}