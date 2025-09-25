import java.util.*;

class Solution {
    static int[] answer = new int[11];
    static int[] cand = new int[11];
    static int diff = 0;
    public int[] solution(int n, int[] info) {
        // info 각 index에서 result[index]가 0이거나 info[index]+1
        dfs(0,n,info);
        if (diff > 0) {
            return answer;
        }else {
            return new int[]{-1};
        }
    }
    
    public void dfs(int idx, int left, int[] info) {
        if(left == 0) {
            calDiffAndUpdateAns(info);
            return;
        }
        if(idx == 11) {
            cand[10] += left;
            calDiffAndUpdateAns(info);
            return;
        }
        
        if(info[idx] + 1 <= left) {
            cand[idx] = info[idx] + 1;
            dfs(idx+1, left - (info[idx]+1), info);
            cand[idx] = 0;
        }
        dfs(idx+1, left, info);
        cand[idx] = 0;
        
    }
    
    public void calDiffAndUpdateAns(int[] info) {
        int apeach = 0;
        int lion = 0;
        for(int i = 0; i <= 10; i++) {
            if(info[i] > 0 && info[i] >= cand[i]) {
                apeach += 10-i;
            } else if(cand[i] > info[i]) {
                lion += 10-i;
            }
        }
        if (diff < lion - apeach) {
            diff = lion - apeach;
            for(int i = 0; i <= 10; i++){
                answer[i] = cand[i];
            }
        } else if (diff > 0 && diff == lion - apeach) {
            for(int i = 10; i >= 0; i--) {
                if(answer[i] > cand[i]) break;
                if(cand[i] > answer[i]) {
                    for(int j = 0; j <= 10; j++){
                        answer[j] = cand[j];
                    }
                    break;
                }
            }
        }
    }
}