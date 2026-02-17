class Solution {
    public long[] solution(long begin, long end) {
        long[] answer = new long[(int) (end-begin+1)];
        for(int i = 0; i < answer.length; i++) {
            long start = i + begin;
            if(start == 1) {
                answer[i] = 0;
            } else if(start < 4) {
                answer[i] = 1;
            } else {
                answer[i] = div(start);
            }
        }
        return answer;
    }
    
    public long div(long x) {
        long ans = 0;
        for(int i = 2; i <= Math.sqrt(x); i++) {
            if(x % i == 0) {
                if(x / i > 10_000_000) {
                    ans = i;
                    continue;
                } else {
                    return x / i;
                }
            }
        }
        return Math.max(ans, 1);
    }
}