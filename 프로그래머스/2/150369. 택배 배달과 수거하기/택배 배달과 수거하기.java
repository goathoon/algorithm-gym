import java.util.*;

class Solution {
    public long solution(int cap, int n, int[] deliveries, int[] pickups) {
        int allD = 0;
        int lastIdxD = -1;
        int allP = 0;
        int lastIdxP = -1;
        
        for(int i = 0; i < deliveries.length; i++) {
            if(deliveries[i] != 0) {
                lastIdxD = i;
                allD += deliveries[i];
            }
        }
        
        for(int i = 0; i < pickups.length; i++) {
            if(pickups[i] != 0) {
                lastIdxP = i;
                allP += pickups[i];
            }
        }
        
        long answer = 0;
        
        while(true) {
            if(allD == 0 && allP == 0) {
                break;
            }
            
            if(lastIdxD >= lastIdxP) {
                answer += 2 * (lastIdxD+1);
                
                int sumD = 0;
                int sumP = 0;
                for(int s = lastIdxD; s >= 0; s--) {
                    if(deliveries[s] + sumD > cap) {
                        deliveries[s] -= (cap - sumD);
                        allD -= (cap - sumD);
                        break;
                    } else {
                        allD -= deliveries[s];
                        sumD += deliveries[s];
                        deliveries[s] = 0;    
                        lastIdxD--;
                    }
                }
                for(int s = lastIdxP; s >= 0; s--) {
                   if(pickups[s] + sumP > cap) {
                        pickups[s] -= (cap - sumP);
                        allP -= (cap - sumP);
                        break;
                    } else {
                        allP -= pickups[s];
                        sumP += pickups[s];
                        pickups[s] = 0;
                        lastIdxP--;
                    } 
                }
                    
            
            } else {
                answer += 2 * (lastIdxP+1);
                
               int sumD = 0;
                int sumP = 0;
                for(int s = lastIdxD; s >= 0; s--) {
                    if(deliveries[s] + sumD > cap) {
                        deliveries[s] -= (cap - sumD);
                        allD -= (cap - sumD);
                        break;
                    } else {
                        allD -= deliveries[s];
                        sumD += deliveries[s];
                        deliveries[s] = 0;
                        lastIdxD--;
                    }
                }
                for(int s = lastIdxP; s >= 0; s--) {
                   if(pickups[s] + sumP > cap) {
                        pickups[s] -= (cap - sumP);
                        allP -= (cap - sumP);
                        break;
                    } else {
                        allP -= pickups[s];
                        sumP += pickups[s];
                        pickups[s] = 0;
                        lastIdxP--;
                    } 
                }
            }
           
        }
        return answer;
    }
}