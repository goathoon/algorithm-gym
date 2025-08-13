

import java.io.*;
import java.util.*;

class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static Set<Long> addSet = new HashSet<>();
    static Set<Long> minusSet = new HashSet<>();

    public static void main(String[] args) throws IOException {
        int N = Integer.parseInt(br.readLine());
        long[] arr = new long[N];
        List<Long> addList = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            arr[i] =  Long.parseLong(br.readLine());
        }
        Arrays.sort(arr);

        for(int i = 0; i < N; i++) {
            for(int j = 0; j < N; j++) {
                addSet.add(arr[i] + arr[j]);
            }
        }

        for(long x : addSet) {
            addList.add(x);
        }
        Collections.sort(addList);

        long answer = -1;
        for(int i = arr.length-1; i >= 0; i--) {
            for(int j = 0; j < i; j++) {
                long target = arr[i] - arr[j];

                int l = 0;
                int r = addList.size();

                while (l < r) {
                    int mid = (l + r) / 2;
                    long cur = addList.get(mid);
                    if(cur > target) {
                        r = mid;
                    }
                    else if (cur < target) {
                        l = mid + 1;
                    }
                    else {
                        answer = Math.max(answer, arr[i]);
                        break;
                    }
                }
            }

        }
        System.out.println(answer);
    }
}

