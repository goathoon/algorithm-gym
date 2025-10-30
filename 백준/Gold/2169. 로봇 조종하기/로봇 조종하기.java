

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine(), " ");
        int row = Integer.parseInt(st.nextToken());
        int col = Integer.parseInt(st.nextToken());

        int[][] grid = new int[row][col];
        int[][] dp = new int[row][col]; // 0이면 -> / 1이면 <-

        for (int r = 0; r < dp.length; r++) {
            for (int c = 0; c < dp[0].length; c++) {
                dp[r][c] = -99999999;
            }
        }

        for (int r = 0; r < row; r++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int c = 0; c < col; c++) {
                grid[r][c] = Integer.parseInt(st.nextToken());
            }
        }

        dp[0][0] = grid[0][0];

        for(int c = 1; c < grid[0].length; c++) {
            dp[0][c] = dp[0][c-1] + grid[0][c];
        }

        for (int r = 1; r < grid.length; r++) {
            int[] left = new int[grid[0].length];
            int[] right = new int[grid[0].length];

            // 위에서 내려온 값 초기화
            for (int c = 0; c < grid[0].length; c++) {
                left[c] = dp[r-1][c] + grid[r][c];
                right[c] = dp[r-1][c] + grid[r][c];
            }

            // 왼쪽 → 오른쪽 진행
            for (int c = 1; c < grid[0].length; c++) {
                left[c] = Math.max(left[c], left[c-1] + grid[r][c]);
            }

            // 오른쪽 → 왼쪽 진행
            for (int c = grid[0].length-2; c >= 0; c--) {
                right[c] = Math.max(right[c], right[c+1] + grid[r][c]);
            }

            // 둘 중 최대값을 다음 dp로 저장
            for (int c = 0; c < grid[0].length; c++) {
                dp[r][c] = Math.max(left[c], right[c]);
            }
        }

        System.out.println(dp[row-1][col-1]);
    }


}