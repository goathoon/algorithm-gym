

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Main {
    static List<List<Integer>> graph;
    static int[][] dist;
    static int[] select = new int[2];
    static int minCost = Integer.MAX_VALUE;
    static boolean[] visited;
    static int answer1 = 0;
    static int answer2 = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        graph = new ArrayList<>();
        visited = new boolean[N + 1];
        dist = new int[N + 1][N + 1];


        for(int n = 0; n <= N; n++) {
            graph.add(new ArrayList<>());
        }

        for (int m = 0; m < M; m++) {
            st = new StringTokenizer(br.readLine(), " ");
            int n1 = Integer.parseInt(st.nextToken());
            int n2 = Integer.parseInt(st.nextToken());
            graph.get(n1).add(n2);
            graph.get(n2).add(n1);
        }

        bfs(N);

        dfs(N, 1, 0);

        System.out.println(answer1 + " " + answer2 + " " + minCost);
    }

    public static void bfs(int n) {
        for(int i = 1; i <= n; i++) {
            Queue<Node> q = new LinkedList<>();
            visited[i] = true;
            q.add(new Node(i, 0));

            while(!q.isEmpty()) {
                Node cur = q.poll();
                int curNum = cur.number;
                int curCost = cur.cost;
                dist[i][curNum] = curCost;
                for (int next : graph.get(curNum)) {
                    if(!visited[next]) {
                        visited[next] = true;
                        q.add(new Node(next, curCost + 1));
                    }
                }
            }
            q.clear();
            for(int j = 0; j <= n; j++) {
                visited[j] = false;
            }
        }
    }

    public static void dfs(int n, int cur, int cnt) {
        if(cnt == 2) {
            int curCost = 0;
            int n1 = select[0];
            int n2 = select[1];
            for(int i = 1; i <= n; i++) {
                curCost += Math.min(dist[i][n1], dist[i][n2]) * 2;
            }
            if (curCost < minCost) {
                minCost = curCost;
                answer1 = n1;
                answer2 = n2;
            }
            return;
        }

        for (int i = cur; i <= n; i++) {
            select[cnt] = i;
            dfs(n, cur + 1, cnt + 1);
            select[cnt] = 0;
        }
    }

    static class Node {
        int number;
        int cost;

        public Node(int number, int cost) {
            this.number = number;
            this.cost = cost;
        }
    }
}