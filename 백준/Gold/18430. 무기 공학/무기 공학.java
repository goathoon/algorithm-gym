

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int[][] arr;
    static boolean[][] visit;
    static int answer = 0;

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        arr = new int[N][M];
        visit = new boolean[N][M];
        for(int n = 0; n <  N; n++) {
            st = new StringTokenizer(br.readLine(), " ");
            for(int m = 0; m < M; m++) {
                arr[n][m] = Integer.parseInt(st.nextToken());
            }
        }

        dfs(0,0, 0);
        System.out.println(answer);
    }

    public static void dfs(int row, int col, int value) {
        if(row >= visit.length) {
            answer = Math.max(answer, value);
            return;
        }

        if (col >= visit[0].length) {
            dfs(row+1,0, value);
            return;
        }

        if (!visit[row][col]) {
            if(row >= 1 && col < visit[0].length-1) {
                if(!(visit[row-1][col] || visit[row][col+1])) {
                    visit[row][col] = true;
                    visit[row-1][col] = true;
                    visit[row][col+1] = true;
                    dfs(row, col+1, value + arr[row][col]*2 + arr[row][col+1] + arr[row-1][col]);
                    visit[row][col] = false;
                    visit[row-1][col] = false;
                    visit[row][col+1] = false;
                }
            }
            if(row < visit.length-1 && col < visit[0].length-1) {

                if(!(visit[row+1][col] || visit[row][col+1])) {
                    visit[row][col] = true;
                    visit[row+1][col] = true;
                    visit[row][col+1] = true;
                    dfs(row, col+1, value + arr[row][col]*2 + arr[row+1][col] + arr[row][col+1]);
                    visit[row][col] = false;
                    visit[row+1][col] = false;
                    visit[row][col+1] = false;
                }
            }
            if(row < visit.length-1 && col >= 1) {

                if(!(visit[row+1][col] || visit[row][col-1])) {
                    visit[row][col] = true;
                    visit[row+1][col] = true;
                    visit[row][col-1] = true;
                    dfs(row, col+1, value + arr[row][col]*2 + arr[row+1][col] + arr[row][col-1]);
                    visit[row][col] = false;
                    visit[row+1][col] = false;
                    visit[row][col-1] = false;
                }
            }
            if(row >= 1 && col >= 1) {

                if(!(visit[row-1][col] || visit[row][col-1])) {
                    visit[row][col] = true;
                    visit[row-1][col] = true;
                    visit[row][col-1] = true;
                    dfs(row, col+1, value + arr[row][col]*2 + arr[row-1][col] + arr[row][col-1]);
                    visit[row][col] = false;
                    visit[row-1][col] = false;
                    visit[row][col-1] = false;
                }
            }
        }
        dfs(row, col+1, value);

    }

}