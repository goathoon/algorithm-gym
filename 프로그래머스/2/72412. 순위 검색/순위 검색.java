import java.util.*;

class Solution {
    
    static Map<String, List<Integer>> map = new HashMap<>();
    
    public int[] solution(String[] info, String[] query) {
        int[] answer = new int[query.length];
        for (String i : info) {
            String[] s = i.split(" ");
            makeSentence(s, "", 0);
        }
        
        for(String k : map.keySet()) {
            Collections.sort(map.get(k), Comparator.reverseOrder());
        }
        
        int idx = 0;
        for (String i : query) {
            String ii = i.replaceAll(" and ", "");
            String[] q = ii.split(" ");
            
            List<Integer> list = map.get(q[0]);
            
            if(list == null) {
                answer[idx++] = 0;
                continue;
            };
            answer[idx++] = getIndex(list, Integer.parseInt(q[1]));
            
        }
        return answer;
    }
    
    public void makeSentence(String[] original, String cur, int i) {
        if(i == 4) {
            List<Integer> priorList = map.getOrDefault(cur, new ArrayList<Integer>());
            Integer x = Integer.parseInt(original[i]);
            priorList.add(x);
            map.put(cur, priorList);
            return;
        }
        
        makeSentence(original, cur + original[i], i+1);
        makeSentence(original, cur + "-", i+1);
    }
    
    public int getIndex(List<Integer> list, int target) {
        int l = 0;
        int r = list.size();
        
        while(l < r) {
            int mid = (l+r) / 2;
            if(list.get(mid) >= target) {
                l = mid+1;
            } else {
                r = mid;
            }
        }
        return l;
    }
}