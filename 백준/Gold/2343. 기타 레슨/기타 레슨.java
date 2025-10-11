

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[] arr = new int[N];
        st = new StringTokenizer(br.readLine());
        long lo = 0, hi = 0;
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            lo = Math.max(lo, arr[i]);
            hi += arr[i];
        }

        long l = lo, r = hi;

        while(l < r) {
            long mid = (l + r) / 2;
            int cnt = 1;
            long cur = 0L;

            for(int i = 0; i < N; i++) {
                if(cur + arr[i] > mid) {
                    cnt++;
                    if(cnt > M) {
                        break;
                    }
                    cur = (long) arr[i];
                } else {
                    cur += (long) arr[i];
                }
            }
            if(cnt <= M) {
                r = mid;
            } else {
                l = mid + 1;
            }
        }
        System.out.println(l);
    }

}