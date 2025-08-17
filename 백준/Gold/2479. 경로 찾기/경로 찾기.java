

import java.io.*;
import java.util.*;

class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static Queue<BitString> q = new LinkedList<>();

    static class BitString {
        String string;
        int idx;
        List<Integer> stringIdxes = new ArrayList<>();

        BitString(String s, int idx) {
            this.string = s;
            this.idx = idx;
        }
        BitString(String s, int idx, int addIdx) {
            this.string = s;
            this.idx = idx;
            stringIdxes.add(addIdx);
        }
    }

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        String[] arr = new String[n+1];
        boolean[] visited = new boolean[n+1];
        boolean[][] isHamming = new boolean[n+1][n+1];

        for(int i = 1; i <= n; i++) {
            arr[i] = br.readLine();
        }

        for(int i = 1; i <= n; i++) {
            for(int j = i+1; j <= n; j++) {
                if(isHamming(arr[i], arr[j])) {
                    isHamming[i][j] = true;
                    isHamming[j][i] = true;
                }
            }
        }

        st = new StringTokenizer(br.readLine(), " ");
        int start = Integer.parseInt(st.nextToken());
        int end = Integer.parseInt(st.nextToken());

        q.add(new BitString(arr[start], start));
        visited[start] = true;
        while(!q.isEmpty()){
            BitString bs = q.poll();
            String cur = bs.string;
            int idx = bs.idx;
            if(idx == end) {
                System.out.print(start + " ");
                for(int ii: bs.stringIdxes) {
                    System.out.print(ii + " ");
                }
                System.exit(0);
            }
            for(int i = 1; i <= n; i++) {
                if(i == idx) continue;
                if(visited[i]) continue;
                if(isHamming(cur, arr[i])) {
                    BitString bitString = new BitString(arr[i], i);
                    bitString.stringIdxes.addAll(bs.stringIdxes);
                    bitString.stringIdxes.add(i);
                    q.add(bitString);
                    visited[i] = true;
                }
            }
        }
        System.out.println(-1);
    }

    public static boolean isHamming(String a, String b) {
        int diffCnt = 0;
        for(int i = 0; i < a.length(); i++){
            if(a.charAt(i) != b.charAt(i)) {
                diffCnt++;
                if(diffCnt > 1) {
                    return false;
                }
            }
        }
        return true;
    }
}