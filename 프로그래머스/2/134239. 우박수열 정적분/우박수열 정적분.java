import java.util.*;

class Solution {
    public double[] solution(int k, int[][] ranges) {
        List<Double> sum = new ArrayList<>();
        sum.add(0d);
        
        while(true) {
            int before = k;
            
            if (k % 2 == 0) {
                k /= 2;
            } else {
                k *= 3;
                k += 1;
            }
            
            if (k >= 1) {
                sum.add(((double) (before + k) / 2) + sum.get(sum.size()-1));
            } 
            
            if (k == 1) {
                break;
            }
        }
        
        
        double[] answer = new double[ranges.length];
        
        for(int i = 0; i < ranges.length; i++) {
            int[] r = ranges[i];
            int start = r[0];
            int end = sum.size() -1 + r[1];
            System.out.println(end);
            
            if(start > end) {
                answer[i] = -1.0;
            } else {
                answer[i] = sum.get(end) - sum.get(start);
            }
            
        }
        
        return answer;
    }
}