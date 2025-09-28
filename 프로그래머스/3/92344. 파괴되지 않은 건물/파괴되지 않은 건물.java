import java.util.*;

class Solution {
    static int[][] sum;
    static boolean[][] visited;
    static int answer = 0;
    public int solution(int[][] board, int[][] skill) {
        sum = new int[board.length+1][board[0].length+1];
        for(int[] s : skill) {
            int startRow = s[1];
            int startCol = s[2];
            int endRow = s[3];
            int endCol = s[4];
            int add = s[5];
            if (s[0] == 1) {
                sum[startRow][startCol] -= add;
                int outerRow = endRow + 1;
                int outerCol = endCol + 1;
                sum[outerRow][startCol] += add;
                sum[startRow][outerCol] += add;
                sum[outerRow][outerCol] -= add;
            }
            else if (s[0] == 2) {
                sum[startRow][startCol] += add;
                int outerRow = endRow + 1;
                int outerCol = endCol + 1;
                sum[outerRow][startCol] -= add;
                sum[startRow][outerCol] -= add;
                sum[outerRow][outerCol] += add;
            }
        }
        spreadSum();
        for(int r = 0; r < board.length; r++){
            for(int c = 0; c < board[0].length; c++){
                if(board[r][c] + sum[r][c] > 0) {
                    answer++;
                }
            }
        }
        return answer;
    }
    
    public void spreadSum() {
        for(int row = 0; row < sum.length; row++){
            for(int col = 1; col < sum[0].length; col++) {
                sum[row][col] += sum[row][col-1];
            }
        }
        for(int col = 0; col < sum[0].length; col++) {
            for(int row = 1; row < sum.length; row++) {
                sum[row][col] += sum[row-1][col];
            }
        }
    }
    

}