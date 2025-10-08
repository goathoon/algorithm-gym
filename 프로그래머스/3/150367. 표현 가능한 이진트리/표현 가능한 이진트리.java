import java.util.*;

class Solution {
    static String originString; 
    public int[] solution(long[] numbers) {
        int[] answer = new int[numbers.length];
        for(int i = 0; i < numbers.length; i++) {
            String s = parse(numbers[i]);
            
            if(s.charAt(s.length() / 2) == '0') {
                answer[i] = 0;
                continue;
            }
            
            answer[i] = isTree(s) ? 1 : 0;
        }
        return answer;
    }
    
    public boolean isTree(String s) {
        if(s.length() == 1) {
            return true;
        }
        
        if(s.charAt(s.length() / 2) == '0') {
            for(int i = 0; i < s.length(); i++){
                if(s.charAt(i) == '1') {
                    return false;
                }
            }
            return true;
        }
        
        String left = s.substring(0, s.length() / 2);
        String right = s.substring(s.length() / 2 + 1);

        if(isTree(left) && isTree(right)) {
            return true;
        }
        return false;
        
    }
    
    public String parse(long number) {
        long originNum = number;
        
        StringBuilder sb = new StringBuilder();
        
        List<Long> chars = new ArrayList<>();
        while(number >= 2) {
            chars.add(number % 2);
            number /= 2;
        }
        chars.add(number);
        
        double val = Math.log(chars.size()) / Math.log(2);
        int height = (int) Math.ceil(val);
        
        if(val % 1 == 0) {
            height += 1;
        }

        while(chars.size() < Math.pow(2, height) - 1) {
            chars.add(0L);
        }
        
        for(int i = chars.size() - 1; i >= 0; i--){
            sb.append(chars.get(i));
        }
        return sb.toString();
    }
}