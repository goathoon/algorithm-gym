import java.util.*;

class Solution {
    public int solution(int[] a) {
        int[] cnt = new int[a.length];
        for(int x : a) {
            cnt[x]++;
        }
        List<NumberCnt> numberCnts = new ArrayList<>();
        
        for(int i = 0; i < cnt.length; i++) {
            numberCnts.add(new NumberCnt(i,cnt[i]));
        }
        numberCnts.sort((nc1,nc2) -> {
            return nc2.cnt - nc1.cnt;
        });
            
        int ans = -1;
        
        for(NumberCnt nc : numberCnts) {
            int curNum = nc.number;
            int curCnt = nc.cnt;
            
            if (curCnt * 2 <= ans) continue;
            int total = 0;
            
            for(int i = 0; i < a.length-1; i++) {
                if(a[i] == a[i+1]) continue;
                if(!(a[i] == curNum || a[i+1] == curNum)) continue;
                total++;
                i++;
            }
            
            ans = Math.max(ans, total * 2);
        } 
        return ans;
        
    }
    
    class NumberCnt {
        int number;
        int cnt;
        
        NumberCnt(int number, int cnt) {
            this.number = number;
            this.cnt = cnt;
        }
    }
}