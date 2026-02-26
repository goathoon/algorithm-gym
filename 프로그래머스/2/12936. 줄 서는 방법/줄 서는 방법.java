import java.util.*;

class Solution {
    public int[] solution(int n, long k) {
        int[] result = new int[n];
        
        List<Integer> list = new ArrayList<>();
        
        long s = 1;
        for(int i = 1; i <= n; i++) {
            list.add(i);
            s *= i;
        }
        
        k--;
        
        for(int i = 0; i < result.length; i++) {
            long cnt = s / n; // 하나 정해지면 개수
            result[i] = list.get((int)(k / cnt));
            list.remove((int)(k/cnt));
            k %= cnt;
            s /= n;
            n--;
        }

        return result;
    }
}