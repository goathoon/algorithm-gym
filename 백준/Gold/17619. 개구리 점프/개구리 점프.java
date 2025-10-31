

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Main {
    static int[] tree;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());
        int Q = Integer.parseInt(st.nextToken());
        List<Tree> trees = new ArrayList<>();

        tree = new int[N+1];
        for (int i = 1; i <= N; i++) {
            tree[i] = i;
        }

        for (int n = 0; n < N; n++) {
            st = new StringTokenizer(br.readLine(), " ");
            int x1 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            trees.add(new Tree(x1,x2,n+1));
        }

        Collections.sort(trees, (t1,t2) -> t1.x1 - t2.x1);

        int initX2 = -1;
        int curSet = 0;
        for (Tree t : trees) {
            if (t.x1 > initX2) {
                initX2 = t.x2;
                curSet = t.num;
            } else {
                if(initX2 < t.x2) {
                    initX2 = t.x2;
                }
                union(t.num, curSet);
            }
        }

        for (int q = 0; q < Q; q++) {
            st = new StringTokenizer(br.readLine(), " ");
            int x1 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());
            if (find(x1) == find(x2)) {
                System.out.println(1);
            } else {
                System.out.println(0);
            }
        }
    }

    public static void union(int a, int b) {
        int pA = find(a);
        int pB = find(b);

        if (pA == pB) return;
        if (pA > pB) {
            tree[pA] = pB;
        } else {
            tree[pB] = pA;
        }
    }

    public static int find(int x) {
        if(tree[x] == x) {
            return x;
        }
        return tree[x] = find(tree[x]);
    }

    static class Tree {
        int x1;
        int x2;
        int num;

        Tree(int x1, int x2, int num) {
            this.x1 = x1;
            this.x2 = x2;
            this.num = num;
        }
    }
}