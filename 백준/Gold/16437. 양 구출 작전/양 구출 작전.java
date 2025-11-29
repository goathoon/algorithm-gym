

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static List<List<Node>> graph = new ArrayList<>();

    static class Node {
        int number;
        int cnt;

        Node(int number, int cnt) {
            this.number = number;
            this.cnt = cnt;
        }
    }

    public static void main(String[] args) throws IOException {
        int N = Integer.parseInt(br.readLine());
        for(int i = 0; i <= N; i++) {
            graph.add(new ArrayList<>());
        }

        for(int n = 2; n <= N; n++) {
            st = new StringTokenizer(br.readLine());
            String type = st.nextToken();
            int cnt = Integer.parseInt(st.nextToken());
            if(type.equals("W")) {
                cnt *= -1;
            }
            int next = Integer.parseInt(st.nextToken());

            graph.get(n).add(new Node(next, cnt));
            graph.get(next).add(new Node(n, cnt));
        }

        System.out.println(dfs(1, 0, 0));
    }

    public static long dfs(int curNum, int beforeNum, long curCnt) {
        long val = curCnt;
        for(Node nextNode : graph.get(curNum)) {
            int nextNum = nextNode.number;
            int nextCnt = nextNode.cnt;
            if(nextNum == beforeNum) continue;

            val += dfs(nextNum, curNum, nextCnt);
        }
        if (val > 0) {
            return val;
        }
        return 0;
    }
}