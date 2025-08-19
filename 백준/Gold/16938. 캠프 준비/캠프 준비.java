

import java.io.*;
import java.util.*;

class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int[] arr;
    static int L;
    static int R;
    static int X;
    static int answer = 0;

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());
        X = Integer.parseInt(st.nextToken());

        arr = new int[N];

        st = new StringTokenizer(br.readLine(), " ");
        for(int i = 0; i < N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);

        dfs(0,0, 0, 0, 0);
        System.out.println(answer);
    }

    public static void dfs(int startIdx, int cnt, int curSum, int firstNum, int lastNum) {
        if(cnt >= 2) {
            if(curSum >= L && curSum <= R && (lastNum - firstNum) >= X) answer++;
        }

        if(startIdx == arr.length) {
            return;
        }

        for(int i = startIdx; i < arr.length; i++) {
            if(firstNum == 0) {
                dfs(i + 1, cnt + 1, curSum + arr[i], arr[i], 0);
            }
            else {
                dfs(i + 1, cnt + 1, curSum + arr[i], firstNum, arr[i]);
            }
        }
    }

}