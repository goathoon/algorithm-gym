import java.io.*;
import java.util.*;

class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static List<List<Integer>> graph = new ArrayList<>();
    static Integer mins = null;
    static int[][] memo = new int[9][100001];

    public static void main(String[] args) throws IOException {
        for(int i = 0 ; i <= 8; i++) {
            graph.add(new ArrayList<>());
        }
        graph.get(1).add(2); graph.get(1).add(3); // 정보
        graph.get(2).add(1); graph.get(2).add(3); graph.get(2).add(4); // 전산관
        graph.get(3).add(1); graph.get(3).add(2); graph.get(3).add(4); graph.get(3).add(5); // 미래
        graph.get(4).add(2); graph.get(4).add(3); graph.get(4).add(5); graph.get(4).add(6); // 신앙관
        graph.get(5).add(3); graph.get(5).add(4); graph.get(5).add(6); graph.get(5).add(7); // 한경직기념관
        graph.get(6).add(4); graph.get(6).add(5); graph.get(6).add(8); // 진리관
        graph.get(7).add(5); graph.get(7).add(8); // 형남공학관
        graph.get(8).add(6); graph.get(8).add(7); // 학생회관

        mins = Integer.parseInt(br.readLine());

        dfs(1, mins);
        System.out.println(memo[1][mins]);
    }

    public static int dfs(int curNode, int min) {
        if(memo[curNode][min] != 0) return memo[curNode][min];

        if(min == 0) {
            if (curNode == 1) {
                return 1;
            }
            return 0;
        }

        for(int nextNode: graph.get(curNode)) {
            memo[curNode][min] += dfs(nextNode, min-1);
            memo[curNode][min] %= 1000000007;
        }
        return memo[curNode][min];
    }
}