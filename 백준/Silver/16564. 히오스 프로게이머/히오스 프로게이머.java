

import java.io.*;
import java.util.*;

class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine(), " ");
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        long[] arr = new long[n];

        for(int i = 0; i < n; i++) {
            arr[i] = Long.parseLong(br.readLine());
        }

        Arrays.sort(arr);

        long start = 0;
        long end = arr[n-1] + k;
        long result = 0;

        while (start <= end) {
            long mid = (start + end) / 2;
            long sum = 0;

            for (int i = 0; i < n; i++) {
                if(arr[i] <= mid) {
                    sum += mid - arr[i];
                }
            }

            if(sum <= k){
                start = mid + 1;
                result = mid;
            }
            else {
                end = mid - 1;
            }
        }
        System.out.println(result);

    }
}

