import java.io.*;
import java.util.*;

class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine(), " ");
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine(), " ");

        List<Integer> plus = new ArrayList<>();
        List<Integer> minus = new ArrayList<>();

        for(int i = 0; i < n; i++) {
            int cur = Integer.parseInt(st.nextToken());
            if(cur >= 0) plus.add(cur);
            else minus.add(-cur);
        }

        plus.sort(Collections.reverseOrder());
        minus.sort(Collections.reverseOrder());

        int last = 0;
        if(plus.isEmpty()) {
            last = minus.get(0);
        } else if(minus.isEmpty()) {
            last = plus.get(0);
        } else {
            last = Math.max(minus.get(0), plus.get(0));
        }

        int plusIdx = 0;
        int minusIdx = 0;
        int ans = 0;

        while(plusIdx < plus.size()) {
            ans += plus.get(plusIdx) * 2;
            for(int have = 0; have < m; have++) {
                plusIdx++;
            }
        }

        while(minusIdx  < minus.size()) {
            ans += minus.get(minusIdx) * 2;
            for(int have = 0; have < m; have++) {
                minusIdx++;
            }
        }

        ans -= last;
        System.out.println(ans);
    }
}