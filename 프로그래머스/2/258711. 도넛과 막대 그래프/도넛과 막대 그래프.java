import java.util.*;

// 나가는게 2개있는게 있는 개수가 8자 그래프의 개수
// 나가는게 하나도 없는 게있으면 그게 막대
// 나머지가 도넛
class Solution {
    public int[] solution(int[][] edges) {
        Map<Integer, Integer> indegree = new HashMap<>();
        Map<Integer, Integer> outdegree = new HashMap<>();
        int start = 0;
        int max = 0;
        // 정점 찾기
        for(int[] edge : edges) {
            int s = edge[0];
            int e = edge[1];
            indegree.put(s, indegree.getOrDefault(s, 0));
            outdegree.put(s, outdegree.getOrDefault(s,0)+1);
            indegree.put(e, indegree.getOrDefault(e,0)+1);
            outdegree.put(e,outdegree.getOrDefault(e,0));
        }
        
        for(int key : indegree.keySet()) {
            if(indegree.get(key) == 0 && outdegree.get(key) >= 2) {
                start = key;
            }
        }
        System.out.println(start);
        
        int eight = 0;
        int makdae = 0;
        for(int key : outdegree.keySet()) {
            if(key == start) continue;
            if(outdegree.get(key) == 2 ) {
                eight++;
            } else if (outdegree.get(key) == 0) {
                makdae++;
            }
        }
        int remain = outdegree.get(start) - eight - makdae;
        // 정점에서 그래프 가리키는 정점들에 대해서 특징 찾기
        int[] answer = {start, remain, makdae, eight};
        return answer;
    }
}