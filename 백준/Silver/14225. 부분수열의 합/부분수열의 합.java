

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static boolean[] check = new boolean[2_000_002];
    static int[] arr;

    public static void main(String[] args) throws IOException {
        int N = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine(), " ");
        arr = new int[N];

        for(int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            check[arr[i]] = true;
        }

        for(int max = 2; max <= N; max++) {
            dfs(0, max, 0, 0);
        }

        for(int i = 1; i < check.length; i++) {
            if (!check[i]) {
                System.out.println(i);
                return;
            }
        }
    }

    public static void dfs(int curIdx, int max, int cnt, int temp) {
        if(max == cnt) {
            check[temp] = true;
            return;
        }

        for(int i = curIdx; i < arr.length; i++) {
            dfs(i+1, max, cnt+1, temp + arr[i]);
        }
    }


}