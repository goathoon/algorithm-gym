

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine(), " ");
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[] arr = new int[n];

        st = new StringTokenizer(br.readLine(), " ");
        for(int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int i = arr.length-1; i >= 0; i--) {
            if(pq.size() < m) {
                pq.add(arr[i]);
            }
            else {
                int top = pq.poll();
                pq.add(top + arr[i]);
            }
        }
        int ans = 0;
        while(!pq.isEmpty()){
            ans = pq.poll();
        }
        System.out.println(ans);

    }
}