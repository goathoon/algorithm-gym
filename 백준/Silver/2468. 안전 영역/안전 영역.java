import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int[][] grid;
    static boolean[][] visited;
    static int[] drow = {1,0,-1,0};
    static int[] dcol = {0,1,0,-1};

    public static void main(String[] args) throws IOException {
        int N = Integer.parseInt(br.readLine());
        grid = new int[N][N];
        visited = new boolean[N][N];

        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for(int j = 0; j < N; j++) {
                grid[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int ans = 0;

        for(int h = 0; h <= 100; h++) {
            int candAns = 0;
            for(int i = 0; i < N; i++) {
                for(int j = 0; j < N; j++) {
                    if(!visited[i][j]) {
                        if(grid[i][j] > h) {
                            dfs(i,j, h);
                            candAns++;
                        }
                        else visited[i][j] = true;
                    }
                }
            }
            clearVisited();
            ans = Math.max(ans, candAns);
        }

        System.out.println(ans);
    }

    public static void dfs(int row, int col, int h) {
        visited[row][col] = true;
        for(int i = 0; i < 4; i++) {
            int nextRow = row + drow[i];
            int nextCol = col + dcol[i];
            if(nextRow >= 0 && nextRow < grid.length && nextCol >= 0 && nextCol < grid[0].length) {
                if(!visited[nextRow][nextCol] && grid[nextRow][nextCol] > h) {
                    dfs(nextRow,nextCol, h);
                }
            }
        }
    }

    public static void clearVisited() {
        for(int i = 0; i < grid.length; i++) {
            for(int j = 0; j < grid[0].length; j++) {
                visited[i][j] = false;
            }
        }
    }
}