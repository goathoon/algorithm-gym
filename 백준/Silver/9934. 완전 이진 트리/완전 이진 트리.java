

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int[][] answer;
    static int[] arr;
    static Map<Integer, String> map;

    public static void main(String[] args) throws IOException {
        int K = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine(), " ");

        arr = new int[(int) Math.pow(2,K) - 1];

        map = new HashMap<>();
        for(int i = 0; i < K; i++) {
            map.put(i, "");
        }

        for(int i = 0; i < arr.length; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        dfs(0, 0, arr.length-1, arr.length);

        for(int i = 0; i < K; i++) {
            System.out.println(map.get(i));
        }
    }

    public static void dfs(int depth, int start, int end, int max) {
        if (start > end || end < 0 || start >= max ) return;

        int midIdx = start + (end - start) / 2;
        int cur = arr[midIdx];

        if(map.get(depth).equals("")) {
            StringBuilder sb = new StringBuilder();
            sb.append(cur);
            map.put(depth, sb.toString());
        } else {
            map.put(depth, map.get(depth) + " " + cur);
        }

        dfs(depth + 1, start, midIdx-1, max);
        dfs(depth + 1, midIdx + 1, end, max);
    }

}