import java.util.*;

class Solution {
    public int solution(int n, int k) {
        int answer = 0;
        
        StringBuilder sb = new StringBuilder();
        
        while(n != 0) {
            sb.append(n % k);
            n = n / k;
        }
        
        String s = sb.toString();
        String origin = "";
        for(int i = s.length() - 1; i >= 0; i--) {
            origin += s.charAt(i);
        }
        String cur = "";
        for(int i = 0; i < origin.length(); i++) {
            if(origin.charAt(i) == '0') {
                if(cur.isBlank()) continue;
                if(isPrime(Integer.parseInt(cur))) {
                    answer++;
                }
                cur = "";
            } else {
                cur += origin.charAt(i);
            }
            
        }
        if(!cur.isBlank() && isPrime(Long.parseLong(cur))) {
            answer++;
        }
        
        return answer;
    }
    
    public boolean isPrime(long n) {
        if(n == 1) return false;
        for(int i = 2; i <= Math.sqrt(n); i++) {
            if(n % i == 0) {
                return false;
            }
        }
        return true;
    }
}