import java.util.*;
class Solution {
    
    Map<String,Integer> map = new HashMap<>();    

    public String[] solution(String[] orders, int[] course) {
        // orders 순회 + course순회 각 order에 대한 course숫자만큼 조합하여 map에 put(string,횟수)
        for(String o : orders) {
            char[] chars = o.toCharArray();
            Arrays.sort(chars);
            
            String newo = new String(chars);
            for(int cnt : course) {
                dfs(newo, cnt, 0, "");
            }
        }
        // 그 이후, map 순회하면서 각 string의 길이별로 최대 등장횟수 저장
        int[] cnt = new int[11];
        for(String s: map.keySet()) {
            cnt[s.length()] = Math.max(cnt[s.length()], map.get(s));
        }
        // 이후 다시 map순회하면서 result에 append
        List<String> answers = new ArrayList<>();
        for(String s : map.keySet()) {
            if(map.get(s) >= 2 && map.get(s).equals(cnt[s.length()])) {
                answers.add(s);
            }
        }
        Collections.sort(answers);
        return answers.toArray(new String[0]);
    }
    
    public void dfs(String s, int cnt, int curIdx, String temp) {
        
        if(temp.length() == cnt) {
            if(map.get(temp) == null) {
                map.put(temp,1);
            } else {
                map.put(temp, map.get(temp) + 1);
            }
            return;
        }
        
        if(curIdx >= s.length()) return;
        
        for(int idx = curIdx; idx < s.length(); idx++){
            dfs(s, cnt, idx+1, temp + s.charAt(idx));
            // dfs(s, cnt, idx+1, temp);
        }
    }
}