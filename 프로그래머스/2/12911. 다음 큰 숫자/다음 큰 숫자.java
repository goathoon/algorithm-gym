class Solution {
    public int solution(int n) {
        int cnt = binCount(n);

        int cur = n + 1;
        while(true) {
            int nextCnt = binCount(cur);
            
            if(nextCnt == cnt) {
                return cur;
            }
            cur++;
        }
    }
    
    public int binCount(int n) {
        int val = 0;
        
        while(n > 1) {
            if(n % 2 == 1) {
                val++;
            }
            n /= 2;
        }
        return val + 1;
    }
    
    
}