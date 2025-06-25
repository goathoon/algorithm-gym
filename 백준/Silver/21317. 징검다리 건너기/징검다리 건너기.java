
import java.io.*;
import java.util.*;

class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int[][] rock;
    static int ans = Integer.MAX_VALUE;
    static int big;

    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(br.readLine());
        rock = new int[n][2];
        for(int i = 1; i < n; i++){
            st = new StringTokenizer(br.readLine(), " ");
            rock[i][0] = Integer.parseInt(st.nextToken());
            rock[i][1] = Integer.parseInt(st.nextToken());
        }
        big = Integer.parseInt(br.readLine());
        dfs(1, n, 0, false);
        System.out.println(ans);
    }

    public static void dfs(int cur, int end, int energy, boolean used) {
        if(cur == end) {
            ans = Math.min(energy,ans);
            return;
        }
        if(cur > end) {
            return;
        }

        if(cur < end) {
            int first = rock[cur][0];
            int second = rock[cur][1];
            dfs(cur + 1, end, energy + first, used);
            dfs(cur + 2, end, energy + second, used);
            if(!used) {
                dfs(cur + 3, end, energy + big, true);
            }
        }
       
    }
}

