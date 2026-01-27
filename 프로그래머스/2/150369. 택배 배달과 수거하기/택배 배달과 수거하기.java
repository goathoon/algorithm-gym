class Solution {
    public long solution(int cap, int n, int[] deliveries, int[] pickups) {
        int endD = -1;
        int endP = -1;
        long answer = 0;
        
        for(int i = 0; i < n; i++) {
            if(deliveries[i] > 0) {
                endD = i;
            } if (pickups[i] > 0) {
                endP = i;
            }
        }
        
        
        while(!(endD == -1 && endP == -1)) {
            answer += (Math.max(endD, endP) + 1) * 2;
            
            int deliver = cap;
            int pickup = cap;
            
            for(int i = endD; i >= 0; i--) {
                if(deliveries[i] > deliver) {
                    deliveries[i] -= deliver;
                    deliver = 0;
                    break;
                }
                else {
                    deliver -= deliveries[i];
                    deliveries[i] = 0;
                    endD--;
                }
            }
            for(int i = endP; i >= 0; i--) {
                if(pickups[i] > pickup) {
                    pickups[i] -= pickup;
                    pickup = 0;
                    break;
                }
                else {
                    pickup -= pickups[i];
                    pickups[i] = 0;
                    endP--;
                }
            }
            
        }
        return answer;
    }
}