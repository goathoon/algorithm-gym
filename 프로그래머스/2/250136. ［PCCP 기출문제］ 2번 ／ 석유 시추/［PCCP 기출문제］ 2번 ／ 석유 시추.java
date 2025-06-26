import java.util.*;
class Solution {
    int[][] clustered;
    
    public int solution(int[][] land) {
        clustered = new int[land.length][land[0].length];
        for(int i = 0; i < clustered.length; i++){
            for(int j = 0; j <clustered[0].length; j++){
                clustered[i][j] = -1;
            }
        }
        Map<Integer, Integer> clusterMap = new HashMap<>();
        
        int clusterId = 1;
        
        for(int r = 0; r < land.length; r++){
            for(int c = 0; c < land[0].length; c++){
                if(land[r][c] == 1 && clustered[r][c] == -1) {
                    int size = 0;
                    size = bfs(land, r, c, clusterId);
                    clusterMap.put(clusterId++, size);
                }
            }
        }
        
        int answer = 0;
        Set<Integer> clusterSet = new HashSet<>();
        
        for(int c = 0; c < land[0].length; c++){
            int total = 0;
            clusterSet.clear();
            for(int r = 0; r < land.length; r++) {
                if(land[r][c] == 1 && !clusterSet.contains(clustered[r][c])){
                    clusterSet.add(clustered[r][c]);
                    total += clusterMap.get(clustered[r][c]);
                }
            }
            answer = Math.max(answer,total);
        }
        return answer;
    }
    
    public int bfs(int[][] land, int row, int col, int id) {
        
        int[] drow = {1,0,-1,0};
        int[] dcol = {0,1,0,-1};
        
        int size = 0;
        Queue<Point> q = new LinkedList<>();
        q.add(new Point(row,col));
        clustered[row][col] = id;
        
        while(!q.isEmpty()){
            Point curPoint = q.poll();
            size++;
            int curRow = curPoint.row;
            int curCol = curPoint.col;
            for(int i = 0 ; i < 4; i++){
                int nextRow = curRow + drow[i];
                int nextCol = curCol + dcol[i];
                if (nextRow < 0 || nextRow >= land.length || nextCol < 0 || nextCol >= land[0].length) continue;
                if (clustered[nextRow][nextCol] != -1 || land[nextRow][nextCol] == 0) continue;
                q.add(new Point(nextRow,nextCol));
                clustered[nextRow][nextCol] = id;
            }
        }
        return size;
    }
    
    public class Point {
        int row;
        int col;
        Point(int row, int col) {
            this.row = row;
            this.col = col;
        }
    }

}