class Solution {
    public String solution(int n) {
        StringBuilder sb = new StringBuilder();

        while (true) {
            int remain = n % 3;

            if (remain == 0) {
                if (n == 0) break;
                
                sb.append("4"); 
                n /= 3;
                n -= 1;
            } else {
                sb.append(remain);
                n /= 3;
            }
        }

        return sb.reverse().toString();
    }
}
