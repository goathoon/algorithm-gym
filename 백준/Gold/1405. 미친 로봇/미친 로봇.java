import java.io.*;
import java.util.*;

class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static int staticCount;
    static double[] dirArr = new double[5];
    static int[] dcol = {0,1,-1,0,0};
    static int[] drow = {0,0,0,1,-1};
    static boolean[][] visit;

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine(), " ");
        staticCount = Integer.parseInt(st.nextToken());
        dirArr[1] = Integer.parseInt(st.nextToken()) / (double) 100;
        dirArr[2] = Integer.parseInt(st.nextToken()) / (double) 100;
        dirArr[3] = Integer.parseInt(st.nextToken()) / (double) 100;
        dirArr[4] = Integer.parseInt(st.nextToken()) / (double) 100;

        visit = new boolean[2*staticCount + 1][2*staticCount + 1];

        System.out.println(dfs(0,0,staticCount,staticCount));
    }

    public static double dfs(int count, int dir, int row, int col) {
        if (count == staticCount) {
            return dirArr[dir];
        }
        visit[row][col] = true;

        double probability = 0f;
        // 초기 상태
        if(dir == 0) {
            for(int nextDir = 1; nextDir <= 4; nextDir++) {
                int nextRow = row + drow[nextDir];
                int nextCol = col + dcol[nextDir];
                if(dirArr[nextDir] != 0f && !visit[nextRow][nextCol]) {
                    probability += dfs(count+1, nextDir, nextRow, nextCol);
                }
            }
            return probability;
        }

        for(int nextDir = 1; nextDir <= 4; nextDir++) {
            int nextRow = row + drow[nextDir];
            int nextCol = col + dcol[nextDir];
            if(dirArr[nextDir] != 0f && !visit[nextRow][nextCol]) {
                probability += dirArr[dir] * dfs(count+1, nextDir, nextRow, nextCol);
            }
        }

        visit[row][col] = false;
        return probability;
    }
}

