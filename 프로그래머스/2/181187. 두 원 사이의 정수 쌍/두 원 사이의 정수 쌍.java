class Solution {
    public long solution(int r1, int r2) {
        long answer = 0;
        for(int i = 0; i < r2; i++) {
            
            if(Math.pow(r1,2) > Math.pow(i,2)) {
                answer += (Math.floor(Math.sqrt(Math.pow(r2,2) - Math.pow(i,2)))  - (Math.ceil(Math.sqrt(Math.pow(r1,2) - Math.pow(i,2)))) + 1) * 4;
            } else {
                answer +=  Math.floor(Math.sqrt(Math.pow(r2,2) - Math.pow(i,2))) * 4;
            }
        }
        return answer;
    }
}