import java.util.*;

class Solution {
    public String solution(String s) {
        String answer = "";
        StringTokenizer st = new StringTokenizer(s, " ");
        List<Long> list = new ArrayList<>();
        while(st.hasMoreTokens()) {
            String cur = st.nextToken();
            list.add(Long.parseLong(cur));
        }
        
        Collections.sort(list);
        answer = list.get(0) + " " + list.get(list.size()-1);
        return answer;
    }
}