import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Main {

    static int[] parent;
    static List<List<Integer>> graph;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int cnt =0;
        while(true) {
            cnt++;
            StringTokenizer st = new StringTokenizer(br.readLine());
            int node = Integer.parseInt(st.nextToken());
            int edge = Integer.parseInt(st.nextToken());

            if(node == 0 && edge == 0){
                return;
            }

            parent = new int[node+1];
            for(int i = 0; i < parent.length; i++) {
                parent[i] = i;
            }

            for(int e = 0; e < edge; e++) {
                st = new StringTokenizer(br.readLine());
                int n1 = Integer.parseInt(st.nextToken());
                int n2 = Integer.parseInt(st.nextToken());
                union(n1,n2);
            }

            Set<Integer> set = new HashSet<>();
            for (int n = 1; n < parent.length; n++) {
                if (parent(n) != 0) {
                    set.add(parent[n]);
                }
            }

            int trees = set.size();
            if(trees > 1) {
                System.out.printf("Case %d: A forest of %d trees.\n", cnt, trees);
            } else if (trees == 1) {
                System.out.printf("Case %d: There is one tree.\n", cnt);
            } else {
                System.out.printf("Case %d: No trees.\n", cnt);
            }
        }
    }

    public static void union (int n1, int n2) {
        int p1 = parent(n1);
        int p2 = parent(n2);
        if (p1 == p2) {
            parent[p2] = 0;
            parent[p1] = 0;
        }
        else {
            if (p1 < p2) {
                parent[p2] = p1;
            } else {
                parent[p1] = p2;
            }
        }
    }

    public static int parent(int n) {
        if( n == 0) return 0;
        if (parent[n] == n){
            return n;
        } return parent[n] = parent(parent[n]);
    }
}