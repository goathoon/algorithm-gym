import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        Road[] roads = new Road[N];
        for (int n = 0; n < N; n++) {
            st = new StringTokenizer(br.readLine(), " ");
            int x = Integer.parseInt(st.nextToken());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            roads[n] = new Road(start, end);
        }
        Arrays.sort(roads, (r1,r2) -> r1.start - r2.start);

        PriorityQueue<Road> pq = new PriorityQueue<>((r1,r2) -> r1.end - r2.end);
        int max = 0;
        for(Road r : roads){
            while(pq.size() > 0 && pq.peek().end <= r.start) {
                pq.poll();
            }
            pq.add(r);
            max = Math.max(max, pq.size());
        }
        System.out.println(max);
    }

    static class Road {
        int start;
        int end;
        Road (int start, int end) {
            this.start = start;
            this.end = end;
        }
    }

}