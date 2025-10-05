import java.util.*;

class Solution {
    public int[] solution(int[][] edges) {
        Map<Integer,int[]> map = new HashMap<>();
        
        for(int[] e : edges) {
            int start = e[0];
            int end = e[1];
            
            if(map.get(start) == null) {
                map.put(start, new int[]{0,1});
            } else {
                map.get(start)[1]++;
            }
            
            if(map.get(end) == null) {
                map.put(end, new int[]{1,0});
            } else {
                map.get(end)[0]++;
            }
        }
        
        int makdae = 0;
        int eight = 0;
        int midNode = -1;
        for(int k : map.keySet()) {
            int[] inout = map.get(k);
            if(inout[1] == 0) {
                makdae++;
            } else if(inout[0] >= 2 && inout[1] == 2) {
                eight++;
            } else if(inout[0] == 0 && inout[1] >= 2) {
                midNode = k;
            }
        }
        int doghnut = map.get(midNode)[1] - makdae - eight;
        return new int[]{midNode, doghnut, makdae, eight};   
    }
}