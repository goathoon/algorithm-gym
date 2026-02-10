class Solution {
    public long solution(int n) {
        int answer = 0;
        long[] dp = new long[n+1];
        if(n % 2 == 1) {
            return 0;
        }
        if(n == 2){
            return 3;
        }
        if(n == 4) {
            return 11;
        }
        
        dp[2] = 3;
        
        for(int i = 4; i <= n; i+=2) {
            dp[i] += dp[i-2] * 3;
            for(int j = 4; j <= i; j+= 2) {
                dp[i] += (dp[i-j] * 2) ;
            }
            dp[i] += 2;
            dp[i] %= 1_000_000_007;
        }
        return dp[n];
    }
}