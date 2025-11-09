import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

class Main {

    static boolean[] visit;
    static List<List<Integer>> graph;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int cnt =0;
        while(true) {
            cnt++;
            StringTokenizer st = new StringTokenizer(br.readLine());
            int node = Integer.parseInt(st.nextToken());
            int edge = Integer.parseInt(st.nextToken());

            visit = new boolean[node+1];
            if (node == 0) {
                return;
            }
            graph = new ArrayList<>();
            for (int n = 0; n <= node; n++) {
                graph.add(new ArrayList<>());
            }
            for(int e = 0; e < edge; e++) {
                st = new StringTokenizer(br.readLine());
                int n1 = Integer.parseInt(st.nextToken());
                int n2 = Integer.parseInt(st.nextToken());
                graph.get(n1).add(n2);
                graph.get(n2).add(n1);
            }

            int trees = 0;
            for(int n = 1; n <= node; n++) {
                if (visit[n]) {
                    continue;
                }
                if(isCycle(n,0)) {
                    continue;
                }
                trees++;
            }
            if(trees > 1) {
                System.out.printf("Case %d: A forest of %d trees.\n", cnt, trees);
            } else if (trees == 1) {
                System.out.printf("Case %d: There is one tree.\n", cnt);
            } else {
                System.out.printf("Case %d: No trees.\n", cnt);
            }
        }
    }

    public static boolean isCycle(int curNode, int beforeNode) {
        visit[curNode] = true;
        for (int next : graph.get(curNode)) {
            if (next == beforeNode) continue;
            if (visit[next]) return true;
            if(isCycle(next, curNode)) {
                return true;
            }
        }
        return false;
    }
}