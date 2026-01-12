import java.util.*;

class Solution {
    public int solution(int[] citations) {
        Arrays.sort(citations);
        int cnt = 0;
        int ans = 0;
        for(int i = citations.length-1; i >= 0; i--) {
            if(citations[i] >= cnt + 1) {
                if(i >= 1 && citations[i-1] <= cnt + 1) {
                    ans = cnt+1;
                }
                if(i == 0 && citations[i] >= cnt + 1) {
                    return cnt+1;
                }
            }
            cnt++;
        }
        return ans;
    }
}