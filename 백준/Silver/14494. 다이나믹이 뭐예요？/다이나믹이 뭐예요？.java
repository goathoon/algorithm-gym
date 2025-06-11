import java.io.*;
import java.util.*;

class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine(), " ");
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        long[][] grid = new long[n+1][m+1];
        grid[1][1] = 1;

        for(int col = 1; col < grid[0].length; col++) {
            for(int row = 1; row < grid.length; row++) {
                grid[row][col] += (grid[row-1][col] + grid[row-1][col-1] + grid[row][col-1]) % 1_000_000_007;
            }
        }
        System.out.println(grid[n][m] % 1_000_000_007);
    }
}

