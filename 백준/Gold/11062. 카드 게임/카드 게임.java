

import java.io.*;
import java.util.*;

class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int[] arr;
    static int[][] dp;

    public static void main(String[] args) throws IOException {
        int tc = Integer.parseInt(br.readLine());
        for(int c = 0; c < tc; c++) {
            int n = Integer.parseInt(br.readLine());
            arr = new int[n];
            st = new StringTokenizer(br.readLine());
            for(int i = 0; i < n; i++){
                arr[i] = Integer.parseInt(st.nextToken());
            }
            dp = new int[n][n];
            System.out.println(solve(0,n-1,true));
            arr = null;
        }
    }

    public static int solve(int left, int right, boolean myturn) {
        if(left > right) return 0;

        if(dp[left][right] != 0) return dp[left][right];

        if(myturn) {
            dp[left][right] = Math.max(solve(left+1,right,false) + arr[left], solve(left,right-1,false) + arr[right]);
        } else {
            dp[left][right] = Math.min(solve(left+1,right,true) , solve(left,right-1,true));
        }
        return dp[left][right];
    }
}

