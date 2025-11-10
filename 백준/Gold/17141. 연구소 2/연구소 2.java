

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static List<Cell> viruses;
    static int[][] grid;
    static int[][] copyGrid;
    static boolean[][] visit;
    static int[] drow = {1,0,-1,0};
    static int[] dcol = {0,1,0,-1};
    static int ans = Integer.MAX_VALUE;
    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        grid = new int[N][N];
        copyGrid = new int[N][N];

        viruses = new ArrayList<>();
        visit = new boolean[N][N];

        for (int n = 0; n < N; n++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int c = 0; c < N; c++) {
                int x = Integer.parseInt(st.nextToken());
                if (x == 2) {
                    viruses.add(new Cell(n,c,0));
                }
                grid[n][c] = x;
                copyGrid[n][c] = Integer.MAX_VALUE;
            }
        }

        dfs(new ArrayList<>(), 0, 0, M);
        if (ans == Integer.MAX_VALUE) {
            System.out.println(-1);
        } else {
            System.out.println(ans);
        }
    }

    static void dfs (List<Cell> chosen, int curIdx, int choose, int max) {
        if (choose == max) {
            for (Cell c : chosen) {
                copyGrid[c.row][c.col] = 0;
                bfs(c);
                for (int i = 0; i < visit.length; i++) {
                    for (int j = 0; j < visit[0].length; j++) {
                        visit[i][j] = false;
                    }
                }
            }

            int curMax = 0;
            boolean cant = false;
            for (int i = 0; i < visit.length; i++) {
                for (int j = 0; j < visit[0].length; j++) {
                    if(grid[i][j] == 0 || grid[i][j] == 2) {
                        if (copyGrid[i][j] == Integer.MAX_VALUE) {
                            cant = true;
                        } else {
                            curMax = Math.max(curMax, copyGrid[i][j]);
                        }
                    }
                    visit[i][j] = false;
                    copyGrid[i][j] = Integer.MAX_VALUE;
                }
            }
            if (!cant) {
                ans = Math.min(ans, curMax);
            }
            return;
        }

        for(int i = curIdx; i < viruses.size(); i++) {
            chosen.add(viruses.get(i));
            dfs(chosen, i+1, choose+1, max);
            chosen.remove(chosen.size() - 1);
        }
    }

    static void bfs (Cell cell) {
        Queue<Cell> q = new LinkedList<>();
        q.add(cell);
        visit[cell.row][cell.col] = true;
        while(!q.isEmpty()) {
            Cell curCell = q.poll();
            int curRow = curCell.row;
            int curCol = curCell.col;
            int curCost = curCell.cost;

            copyGrid[curRow][curCol] = Math.min(curCost, copyGrid[curRow][curCol]);

            for(int i = 0; i < 4; i++) {
                int nextRow = drow[i] + curRow;
                int nextCol = dcol[i] + curCol;

                if (nextRow < grid.length && nextRow >= 0 && nextCol < grid[0].length && nextCol >= 0 && !(grid[nextRow][nextCol] == 1)) {
                    if(!visit[nextRow][nextCol]) {
                        visit[nextRow][nextCol] = true;
                        q.add(new Cell(nextRow, nextCol, curCost + 1));
                    }
                }
            }
        }
    }

    static class Cell {
        int row;
        int col;
        int cost;
        Cell(int row, int col, int cost) {
            this.row = row;
            this.col = col;
            this.cost = cost;
        }
    }

}