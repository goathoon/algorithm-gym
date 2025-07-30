import java.io.*;
import java.util.*;

class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static Map<Integer, List<int[]>> blocks = new HashMap<>(){{
        put(1, List.of(new int[] {1},  new int[] {1,1,1,1}));
        put(2, List.of(new int[] {1,1}));
        put(3, List.of(new int[] {1,1,2}, new int[] {2,1}));
        put(4, List.of(new int[] {2,1,1}, new int[] {1,2}));
        put(5, List.of(new int[] {1,1,1}, new int[] {1,2},new int[] {2,1,2}, new int[] {2,1}));
        put(6, List.of(new int[] {1,1,1}, new int[] {1,1}, new int[] {1,2,2}, new int[] {3,1}));
        put(7, List.of(new int[] {1,1,1}, new int[] {1,3}, new int[] {2,2,1}, new int[] {1,1}));
    }};

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine(), " ");
        int C = Integer.parseInt(st.nextToken());
        int P = Integer.parseInt(st.nextToken());

        int[] arr = new int[C];
        st = new StringTokenizer(br.readLine(), " ");
        for(int c = 0; c < C; c++) {
            arr[c] = Integer.parseInt(st.nextToken());
        }
        int ans = 0;

        List<int[]> block = blocks.get(P);
        for(int[] shape : block) {
            for(int c = 0; c <= C-shape.length; c++) {
                int addLen = shape.length - 1;
                if(addLen == 0) {
                    ans++;
                }
                else if (addLen == 1) {
                    int first = shape[0];
                    int second = shape[1];
                    if(arr[c] - arr[c+1] == first - second){
                        ans++;
                    }
                }
                else if (addLen == 2) {
                    int first = shape[0];
                    int second = shape[1];
                    int third = shape[2];
                    if(arr[c] - arr[c+1] == first - second && arr[c+1] - arr[c+2] == second - third){
                        ans++;
                    }
                }
                else if (addLen == 3) {
                    if(arr[c] == arr[c+1] && arr[c+1] == arr[c+2] && arr[c+2] == arr[c+3]) {
                        ans++;
                    }
                }
            }
        }
        System.out.println(ans);
    }
}
