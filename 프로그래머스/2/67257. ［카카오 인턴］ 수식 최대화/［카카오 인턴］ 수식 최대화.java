import java.util.*;

class Solution {
    public long solution(String expression) {
        StringTokenizer st = new StringTokenizer(expression, "-*+");
        while(st.hasMoreTokens()){
            System.out.println(st.nextToken());
        }
        return 1L;
        
        String[] orders = {"*+-", "*-+", "+*-", "+-*", "-*+", "-+*"};
        
    }
}