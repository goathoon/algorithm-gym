import java.util.*;

class Solution {
    public int solution(int[] citations) {
        int answer = 0;
        Arrays.sort(citations);
        for(int h = 1000; h >= 0; h--) {
            int cnt = 0;
            for(int x = citations.length-1; x >= 0; x--) {
                if(citations[x] >= h){
                    cnt++;
                    continue;
                }
                break;
            }
            if(cnt >= h) {
                answer = h;
                break;
            }
        }
        return answer;
    }
}