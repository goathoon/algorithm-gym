

import java.io.*;
import java.util.*;

class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[] arr = new int[N];

        st = new StringTokenizer(br.readLine(), " ");
        for(int i = 0; i < N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int l = 0;
        int r = 10000;

        while (l < r) {
            int mid = (l+r)/2;

            int div = 1;
            int min = arr[0];
            int max = arr[0];
            int curIdx = 0;
            boolean fail = false;
            while (curIdx < N) {

                if(mid >= Math.abs(arr[curIdx] - min) && mid >= Math.abs(arr[curIdx] - max)){
                    min = Math.min(arr[curIdx], min);
                    max = Math.max(arr[curIdx], max);
                    curIdx++;
                }

                else {
                    div++;
                    min = arr[curIdx];
                    max = arr[curIdx];
                }
                if(div > M) {
                    fail = true;
                    break;
                }
            }

            if(fail) {
                l = mid+1;
            }
            else {
                r = mid;
            }
        }
        System.out.println(l);
    }
}

