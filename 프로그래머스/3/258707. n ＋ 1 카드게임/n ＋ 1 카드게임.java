import java.util.*;

class Solution {
    public int solution(int coin, int[] cards) {
        Set<Integer> origin = new HashSet<>();
        Set<Integer> addition = new HashSet<>();
        
        for(int i = 0; i < cards.length / 3; i++) {
            origin.add(cards[i]);
        }
        
        int answer = 0;
        int target = cards.length + 1;
        
        int idx = cards.length / 3;
        while(true) {
            answer++;
            
            if(idx >= cards.length) break;
            
            boolean flag = false;
            
            addition.add(cards[idx]);
            addition.add(cards[idx+1]);
            
            idx += 2;
            
            // 기존 coin들로부터 탐색
            for(int o : origin) {
                if (origin.contains(target - o)) {
                    origin.remove(o);
                    origin.remove(target - o);
                    flag = true;
                    break;
                }
            }
            
            if (!flag) {
                if(coin <= 0) break;
                for(int a : addition) {
                    if(origin.contains(target - a)) {
                        origin.remove(target - a);
                        addition.remove(a);
                        flag = true;
                        coin--;
                        break;
                    }
                }
            }
            
            if (!flag) {
                if(coin < 2) break;
                for(int a : addition) {
                    if(addition.contains(target - a)) {
                        addition.remove(target - a);
                        addition.remove(a);
                        flag = true;
                        coin -= 2;
                        break;
                    }
                }
            }
            
            if(!flag) {
                break;
            }
        }
        
        return answer;
    }
}