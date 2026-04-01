class Solution {
    public String solution(String s) {
        StringBuilder sb = new StringBuilder();
        
        boolean start = true;
        for(char a : s.toCharArray()) {
            if(a == ' ') {
                start = true;
                sb.append(a);
                continue;
            }
            
            String aa = Character.toString(a);
            if(start) {
                sb.append(aa.toUpperCase());
                start = false;
            } else {
                sb.append(aa.toLowerCase());
            }
        }
        
        return sb.toString();
    }
}