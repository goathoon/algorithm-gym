class Solution {
    public long solution(int n, int[] times) {
        long l = 1;
        long r = Long.MAX_VALUE-1;
        
        while(l < r) {
            long mid = (l+r) / 2;
            
            long total = 0;
            for(int time : times) {
                total += mid / time;
                if(total > n) {
                    break;
                } 
            }
            if(total >= n) {
                r = mid;
            } else {
                l = mid+1;
            }
            
        }
        return l;
    }
}