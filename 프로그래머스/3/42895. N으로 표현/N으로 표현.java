import java.util.*;

class Solution {
    public int solution(int N, int number) {
        List<Set<Integer>> dp = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        
        for(int i = 0; i <= 8; i++){
            dp.add(new HashSet<>());
        }
        
        dp.get(1).add(N);
        sb.append(N);
        for(int j = 2; j <= 8; j++) {
            sb.append(N);
            dp.get(j).add(Integer.parseInt(sb.toString()));
            for(int a = 1; a <= j-a; a++){
                int b = j - a;
                for(int x : dp.get(a)){
                    for(int y : dp.get(b)){
                        dp.get(j).add(x+y);
                        dp.get(j).add(x*y);
                        dp.get(j).add(x-y);
                        dp.get(j).add(y-x);
                        if(y != 0) dp.get(j).add(x/y);
                        if(x != 0) dp.get(j).add(y/x);
                    }
                }
            }
        }
        for(int i = 1; i <= 8; i++){
            if(dp.get(i).contains(number)) return i;
        }
        return -1;
    }
}