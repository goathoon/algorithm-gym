import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static List<List<Integer>> out;
    static List<List<Integer>> in;
    static int N;

    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int X = Integer.parseInt(st.nextToken());

        out = new ArrayList<>();
        in = new ArrayList<>();

        for(int i = 0; i <= N; i++) {
            out.add(new ArrayList<>());
            in.add(new ArrayList<>());
        }

        for(int m = 0; m < M; m++) {
            st = new StringTokenizer(br.readLine(), " ");
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            out.get(start).add(end);
            in.get(end).add(start);
        }

        int out = bfsOfOut(X);
        int in =  bfsOfIn(X);

        System.out.printf("%d %d", in + 1, N - out);
    }

    static int bfsOfOut(int x) {
        boolean[] visited = new boolean[N+1];
        int cnt = -1;
        Queue<Integer> q = new LinkedList<>();
        q.add(x);
        visited[x] = true;
        while(!q.isEmpty()) {
            int cur = q.poll();
            cnt++;
            for (int next: out.get(cur)) {
                if(!visited[next]) {
                    q.add(next);
                    visited[next] = true;
                }
            }
        }
        return cnt;
    }

    static int bfsOfIn(int x) {
        boolean[] visited = new boolean[N+1];
        int cnt = -1;
        Queue<Integer> q = new LinkedList<>();
        q.add(x);
        visited[x] = true;
        while(!q.isEmpty()) {
            int cur = q.poll();
            cnt++;
            for (int next: in.get(cur)) {
                if(!visited[next]) {
                    q.add(next);
                    visited[next] = true;
                }
            }
        }
        return cnt;
    }
}