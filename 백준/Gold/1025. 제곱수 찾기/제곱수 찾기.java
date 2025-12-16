

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[][] arr = new int[N][M];
        for(int n = 0; n < N; n++) {
            String s = br.readLine();
            for(int m = 0; m < M; m++) {
                arr[n][m] = s.charAt(m) - '0';
            }
        }

        int ans = -1;

        for(int r = 0; r < N; r++) {
            for (int rr = -N; rr < N; rr++) {
                for(int c = 0; c < M; c++){
                    for (int cc = -M; cc < M; cc++) {

                        if(rr == 0 && cc == 0) continue;

                        int num = 0;
                        int sr = r;
                        int sc = c;

                        while(sr >= 0 && sr < N && sc >= 0 && sc < M) {
                            num = num * 10 + arr[sr][sc];
                            if(isSquare(num)){
                                ans = Math.max(ans, num);
                            }
                            sr += rr;
                            sc += cc;
                        }
                    }
                }
            }
        }
        System.out.println(ans);
    }

    public static boolean isSquare(int x) {
        int y = (int) Math.sqrt(x);
        if (y*y == x) {
            return true;
        }
        return false;
    }

}