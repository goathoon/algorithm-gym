import java.util.*;
class Solution {
    public String solution(int[] numbers) {
        StringBuilder sb = new StringBuilder();
        List<String> list = new ArrayList<>();
        for(int n : numbers) {
            String s = String.valueOf(n);
            list.add(s);
        }
        Collections.sort(list, (s1,s2) -> (s2+s1).compareTo(s1+s2));
        
        if(list.get(0).equals("0")){
            return "0";
        }
        
        for(String s : list) {
            sb.append(s);
        }
        return sb.toString();
    }
}