import java.util.*;

class Solution {
    public int solution(String s) {
        int len = s.length();
        int answer = 0;
        for(int l = 0; l < len; l++) {
            if(l > 0) {
                String newString = s.substring(1, s.length());
                newString += s.charAt(0);
                s = newString;
            }

            if(isTrue(s)) {
                answer++;
            }
        }
        
        return answer;
    }
    
    public boolean isTrue(String s) {
        Deque<Character> stack = new ArrayDeque<>();
        
        for(char c : s.toCharArray()) {
            if(c == '[' || c == '(' || c == '{') {
                stack.push(c);
            } else {
                if(!stack.isEmpty()) {
                    if(c == ']') {
                        if(stack.pop() != '[') return false;
                    }
                    else if (c == ')') {
                        if(stack.pop() != '(') return false;
                    }
                    else if (c == '}'){
                        if(stack.pop() != '{') return false;
                    }
                    else return false;
                   
                } else {
                    return false;
                }
            }
        }
        if(!stack.isEmpty()) return false;
        return true;
    }
}