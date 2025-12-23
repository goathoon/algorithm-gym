class Solution {
    public int solution(int[] arr) {
        int ans = arr[0];
        for(int i = 1; i < arr.length; i++){
            ans = lcm(ans, arr[i]);
        }
        return ans;
    }
    
    public int gcd(int a, int b) {
        while(b != 0){
            int remain = a % b;
            a = b;
            b = remain;
        }
        return a;
    }
    
    public int lcm(int a, int b) {
        return a / gcd(a,b) * b;
    }
}