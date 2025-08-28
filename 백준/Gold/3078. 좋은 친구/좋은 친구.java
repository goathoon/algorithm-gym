
import java.io.*;
import java.util.*;

class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        String[] arr = new String[N+1];

        for(int i = 1; i <= N; i++) {
            arr[i] = br.readLine();
        }

        Map<Integer, Integer> lengthCountMap = new HashMap<>();
        for(int len = 2; len <= 20; len++){
            lengthCountMap.put(len, 0);
        }

        int start = 1;
        int end = 1;
        for( ; end - start <= K && end <= N; end++) {
            int length = arr[end].length();
            lengthCountMap.put(length, lengthCountMap.get(length) + 1);
        }

        end--;
        long ans = 0;

        while(true) {
            if(start == N) break;
            String startString = arr[start];
            ans += lengthCountMap.get(startString.length()) - 1;

            start++;
            lengthCountMap.put(startString.length(),lengthCountMap.get(startString.length())-1);

            end++;
            if (end > N) continue;
            lengthCountMap.put(arr[end].length(), lengthCountMap.get(arr[end].length()) + 1);
        }
        System.out.println(ans);
    }
}

