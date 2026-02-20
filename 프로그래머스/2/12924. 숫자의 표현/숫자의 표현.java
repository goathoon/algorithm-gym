class Solution {
    public int solution(int n) {
        int answer = 0;
        
        int[] sum = new int[10001];
        for(int i = 1; i < sum.length; i++) {
            sum[i] = sum[i-1] + i;
        }
        int start = 0;
        int end = 0;
        
        while(end < sum.length) {
            if(sum[end] - sum[start] < n) {
                end++;
            } else if (sum[end] - sum[start] > n){
                start++;
            } else if (sum[end] - sum[start] == n) {
                answer++;
                start++;
            }
        }
        return answer;
    }
}