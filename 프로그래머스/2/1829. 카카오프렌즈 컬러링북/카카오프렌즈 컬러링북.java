class Solution {

    boolean[][] visit;
    int[] drow = {1,0,-1,0};
    int[] dcol = {0,1,0,-1};
    
    public int[] solution(int m, int n, int[][] picture) {
        int numberOfArea = 0;
        int maxSizeOfOneArea = 0;

        visit = new boolean[picture.length][picture[0].length];
        
        for(int r = 0; r < picture.length; r++) {
            for(int c = 0; c < picture[0].length; c++) {
                if(picture[r][c] != 0 && !visit[r][c]) {
                    numberOfArea++;
                    maxSizeOfOneArea = Math.max(maxSizeOfOneArea, dfs(picture, picture[r][c], r, c));
                }
            }
        }
        
        int[] answer = new int[2];
        answer[0] = numberOfArea;
        answer[1] = maxSizeOfOneArea;
        return answer;
    }
    
    int dfs(int[][] picture, int cur, int row, int col) {
        int ans = 1;
        visit[row][col] = true;
        
        for(int i = 0 ; i < 4; i++) {
            int nextR = row + drow[i];
            int nextC = col + dcol[i];
            
            if(nextR >= visit.length || nextC >= visit[0].length || nextR < 0 || nextC < 0) continue;
            if(visit[nextR][nextC]) continue;
            if(picture[nextR][nextC] != cur) continue;
            
            
            ans += dfs(picture, cur, nextR, nextC);
        }
        return ans;
    }
}