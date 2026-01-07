
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static boolean[][] check;
    static int answer;
    static int N;
    static int M;

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        check = new boolean[N][M];

        dfs(0);
        System.out.println(answer);
    }

    public static void dfs(int x) {
        if(x == N * M) {
            answer++;
            return;
        }

        int r = x / M;
        int c = x % M;

        // 선택 안함

        dfs(x+1);

        check[r][c] = true;
        if (isNemo(r,c)) {
            check[r][c] = false;
            return;
        } 
        dfs(x+1);
        check[r][c] = false;
    }

    public static boolean isNemo(int r, int c) {
        if(r >= 1 && c >= 1) {
            if(check[r][c] && check[r-1][c] && check[r][c-1] && check[r-1][c-1]) return true;
        }
        return false;
    }

}