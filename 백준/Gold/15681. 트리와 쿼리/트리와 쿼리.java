

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Main {

    static List<List<Integer>> graph = new ArrayList<>();
    static int[] size;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int N = Integer.parseInt(st.nextToken());
        int R = Integer.parseInt(st.nextToken());
        int Q = Integer.parseInt(st.nextToken());

        size = new int[N+1];
        for (int n = 0; n <= N; n++) {
            graph.add(new ArrayList<>());
        }

        for (int n = 0; n < N-1; n++) {
            st = new StringTokenizer(br.readLine(), " ");
            int n1 = Integer.parseInt(st.nextToken());
            int n2 = Integer.parseInt(st.nextToken());
            graph.get(n1).add(n2);
            graph.get(n2).add(n1);
        }

        tree(R, -1);

        for (int q = 0; q < Q; q++) {
            int k = Integer.parseInt(br.readLine());
            System.out.println(size[k]);
        }
    }

    public static int tree (int root, int parent) {
        size[root] = 1;
        for (int next : graph.get(root)) {
            if (next == parent) continue;
            size[root] += tree(next, root);
        }
        return size[root];
    }
}