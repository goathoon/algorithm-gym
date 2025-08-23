import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        String str = "";
        while((str = br.readLine()) != null) {
            int[] arr = new int[Integer.parseInt(str.trim())];
            st = new StringTokenizer(br.readLine().trim());
            for (int i = 0; i < arr.length; i++)
                arr[i] = Integer.parseInt(st.nextToken());

            List<Integer> list = new ArrayList<>();
            list.add(arr[0]);

            for(int i = 1; i < arr.length; i++) {
                int next = arr[i];
                if (next > list.get(list.size()-1)) {
                    list.add(next);
                }
                else if (next < list.get(list.size() - 1)){
                    int l = 0;
                    int r = list.size();
                    while(l < r) {
                        int mid = (l+r) / 2;
                        // 1 2 4 <-3
                        if(list.get(mid) >= next) {
                            r = mid;
                        }
                        else {
                            l = mid + 1;
                        }
                    }
                    list.set(l, next);
                }
            }
            System.out.println(list.size());

        }
    }
}