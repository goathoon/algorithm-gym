import java.util.*;

class Solution {
    public int[] solution(String s) {
        String substr = s.substring(1,s.length()-1);
        Set<Integer> set = new HashSet<>();        
        List<String> sets = new ArrayList<>();
        
        String added = "";
        for(int i = 1 ; i < s.length()-1;i++) {
            if(s.charAt(i) == ',' && s.charAt(i+1) == '{') {
                sets.add(added);
                added = "";
                i++;
            } 
            added += s.charAt(i);
        }
        sets.add(added);
        
        
        Collections.sort(sets,(s1,s2) -> s1.length() - s2.length());

        int size = sets.size();
        int[] answer = new int[size];
        
        int curIdx = 0;
        for(String ss : sets) {
            StringTokenizer st = new StringTokenizer(ss.substring(1,ss.length()-1), ",");
            while(st.hasMoreTokens()) {
                String curString = st.nextToken();
                Integer curInteger = Integer.parseInt(curString);
                if(set.contains(curInteger)) {
                    continue;
                }
                set.add(curInteger);
                answer[curIdx++] = (int) curInteger;
            }
        }
        
        
        return answer;
    }
}