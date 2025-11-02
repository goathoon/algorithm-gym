import java.util.*;

class Solution {
    public int solution(int[][] scores) {
        // [4,4],[3,2],[3,3],[3,4],[2,1],[2,2],[2,5],[1,1]
        int[] x = scores[0];
        Arrays.sort(scores, (int[] a, int[] b) -> {
            if (a[0] == b[0]) {
                return a[1] - b[1];
            } return b[0] - a[0];
        });
        
        int maxPeer = scores[0][1];
        
        int ans = 1;
        
        for (int i = 0; i < scores.length; i++) {
            maxPeer = Math.max(maxPeer, scores[i][1]);
            if (maxPeer > scores[i][1]){
                if(scores[i][0] == x[0] && scores[i][1] == x[1]) {
                    return -1;
                } 
                continue;
            }
            else {
                if (scores[i][0] + scores[i][1] > x[0] + x[1]) {
                    ans++;
                }
            }
            
        }
        return ans;
    }
}