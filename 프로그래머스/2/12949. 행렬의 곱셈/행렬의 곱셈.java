class Solution {
    public int[][] solution(int[][] arr1, int[][] arr2) {
        int[][] answer = new int[arr1.length][arr2[0].length];
        for(int r = 0; r < arr1.length; r++) {
            for(int c = 0; c < arr2[0].length; c++) {
                for(int r2 = 0; r2 < arr2.length; r2++) {
                    answer[r][c] += arr1[r][r2] * arr2[r2][c];
                }
            }
        }
        return answer;
    }
}