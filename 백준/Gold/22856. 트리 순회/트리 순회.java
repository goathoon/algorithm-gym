import java.io.*;
import java.util.*;

class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static Node[] nodes;
    static int answer = -1;
    static int lastNode = 0;
    static boolean finished = false;

    public static void main(String[] args) throws IOException {
        int N = Integer.parseInt(br.readLine());
        nodes = new Node[N+1];
        for(int i = 1; i <= N; i++) {
            nodes[i] = new Node(i);
        }
        for(int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine()," ");
            int cur = Integer.parseInt(st.nextToken());
            int l = Integer.parseInt(st.nextToken());
            int r = Integer.parseInt(st.nextToken());

            if(l != -1) {
                nodes[cur].left = nodes[l];
                nodes[l].parent = nodes[cur];
            }
            if(r != -1) {
                nodes[cur].right = nodes[r];
                nodes[r].parent = nodes[cur];
            }
        }

        traverse(1);
        for(int i = 1; i <= N; i++) {
            nodes[i].visit = false;
        }
        dfs(1);

    }

    static void dfs(int num) {
        if(finished) return;
        answer++;
        Node curNode = nodes[num];
        curNode.visit = true;
        if(curNode.left != null && !curNode.left.visit) {
            dfs(curNode.left.cur);
        } else if (curNode.right != null && !curNode.right.visit) {
            dfs(curNode.right.cur);
        } else if (curNode.cur == lastNode) {
            System.out.println(answer);
            finished = true;
        } else if (curNode.parent != null) {
            dfs(curNode.parent.cur);
        }
    }

    static void traverse(int num) {
        Node curNode = nodes[num];

        if(curNode.left != null) traverse(curNode.left.cur);
        curNode.visit = true;
        lastNode = num;
        if(curNode.right != null) traverse(curNode.right.cur);
    }

    static class Node {
        int cur;
        Node left;
        Node right;
        Node parent;
        boolean visit = false;

        Node (int cur) {
            this.cur = cur;
        }
    }

}