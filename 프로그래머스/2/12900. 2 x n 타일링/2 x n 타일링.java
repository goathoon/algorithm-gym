import java.util.*;
class Solution {
    public int solution(int n) {
        if(n == 1) {
            return 1;
        }
        if(n == 2) {
            return 2;
        }
        if(n == 3) {
            return 3;
        }
        int[] tile = new int[n+1];
        tile[1] = 1;
        tile[2] = 2;
        tile[3] = 3;
        
        for(int i = 4; i <= n; i++) {
            tile[i] += tile[i-1];
            tile[i] += tile[i-2];
            tile[i] %= 1000000007;
        }
        return tile[n];
    }
}