import java.util.*;
class Solution {
    String[] characters = {"A", "C", "F", "J", "M", "N", "R", "T"};
    boolean[] visited = new boolean[8];
    int answer = 0;
    
    public int solution(int n, String[] data) {
        answer = 0;
        dfs("", data);
        return answer;
    }
    
    public void dfs(String curString, String[] data ) {
        
        if(curString.length() == 8) {
            
            Map<Character, Integer> map = new HashMap<>();
            for(int i = 0; i < curString.length(); i++) {
                map.put(curString.charAt(i), i);
            }
            
            boolean isValid = true;
            
            for(String d : data) {
                char a = d.charAt(0);
                int aIdx = map.get(a);
                char b = d.charAt(2);
                int bIdx = map.get(b);
                
                int dist = d.charAt(4) - '0';
                char op = d.charAt(3);
                
                int distance = Math.abs(bIdx - aIdx);
                if(op == '=') {
                    if(distance == dist+1) {
                        continue;
                    } else {
                        isValid = false;
                    }
                } else if(op == '>') {
                    if(distance > dist+1) {
                        continue;
                    } else {
                        isValid = false;
                    }
                } else if(op == '<') {
                    if(distance < dist+1) {
                        continue;
                    } else {
                        isValid = false;
                    }
                }
                if(!isValid) break;
            }
            if(isValid) answer++;
            return;
        }

        for(int i = 0; i < characters.length; i++) {
            if(!visited[i]) {
                visited[i] = true;
                dfs(curString + characters[i], data);
                visited[i] = false;
            }
        }
        
        
    }
}