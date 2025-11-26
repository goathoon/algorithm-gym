
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int[] parent;
    static List<List<Edge>> graph;
    static int[] distance;
    static class Edge {
        int a;
        int b;
        int cost;

        Edge(int a, int b, int cost) {
            this.a = a;
            this.b = b;
            this.cost = cost;
        }

        Edge(int b, int cost) {
            this.b = b;
            this.cost = cost;
        }
    }

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        parent = new int [N+1];
        distance = new int[N+1];
        for(int n = 1; n <= N; n++) {
            parent[n] = n;
            distance[n] = Integer.MAX_VALUE;
        }
        graph = new ArrayList<>();
        for(int n = 0; n <= N; n++) {
            graph.add(new ArrayList<>());
        }
        List<Edge> edges = new ArrayList<>();

        for(int m = 0; m < M; m++) {
            st = new StringTokenizer(br.readLine(), " ");
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());
            edges.add(new Edge(a,b,cost));
        }

        st = new StringTokenizer(br.readLine(), " ");
        int x = Integer.parseInt(st.nextToken());
        int y = Integer.parseInt(st.nextToken());

        for(Edge e: edges) {
            int start = e.a;
            int end = e.b;
            int cost = e.cost;

            graph.get(start).add(new Edge(end, cost));
            graph.get(end).add(new Edge(start, cost));
        }
        System.out.println(dijkstra(x,y));
    }

    static int dijkstra(int start, int end) {
        distance[start] = 0;
        PriorityQueue<Edge> pq = new PriorityQueue<>((e1,e2) -> e1.cost - e2.cost);
        pq.add(new Edge(start,0));

        while(!pq.isEmpty()) {
            Edge curEdge = pq.poll();
            for(Edge e : graph.get(curEdge.b)) {
                if(distance[e.b] > e.cost + curEdge.cost) {
                    distance[e.b] = e.cost + curEdge.cost;
                    pq.add(new Edge(e.b, e.cost + curEdge.cost));
                }
            }
        }
        return distance[end];
    }

}