class Solution {
    int answer = 0;
    int[] queenCol; // queenCol[row] = 해당 row에 놓인 퀸의 col

    public int solution(int n) {
        queenCol = new int[n];
        dfs(0, n);
        return answer;
    }

    private void dfs(int row, int n) {
        if (row == n) {
            answer++;
            return;
        }

        for (int col = 0; col < n; col++) {
            if (canPlace(row, col)) {
                queenCol[row] = col;
                dfs(row + 1, n);
            }
        }
    }

    private boolean canPlace(int row, int col) {
        for (int prevRow = 0; prevRow < row; prevRow++) {
            int prevCol = queenCol[prevRow];

            // 같은 열에 이미 퀸이 있는 경우
            if (prevCol == col) {
                return false;
            }

            // 대각선에 있는 경우
            if (Math.abs(row - prevRow) == Math.abs(col - prevCol)) {
                return false;
            }
        }
        return true;
    }
}