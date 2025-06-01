import java.io.*;
import java.util.*;

class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static List<List<Integer>> graph = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        int node = Integer.parseInt(br.readLine());
        for(int n = 0; n <= node; n++) {
            graph.add(new ArrayList<>());
        }

        for (int n = 1 ; n < node ; n++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            graph.get(a).add(b);
            graph.get(b).add(a);
        }

        int query = Integer.parseInt(br.readLine());
        for (int n = 0 ; n < query ; n++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            if(a == 1) {
                if(graph.get(b).size() == 1) {
                    System.out.println("no");
                }
                else System.out.println("yes");
                continue;
            }
            if(a == 2) {
                System.out.println("yes");
            }

        }
    }
}