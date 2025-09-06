

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static boolean[][][] canGo = new boolean[101][101][101];
    static boolean[][] cowMove = new boolean[101][101];
    static int[] drow = {-1, 1, 0, 0};
    static int[] dcol = {0, 0, -1, 1};

    static class Point {
        int row;
        int col;

        Point(int row, int col) {
            this.row = row;
            this.col = col;
        }
    }


    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine(), " ");

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int R = Integer.parseInt(st.nextToken());

        for(int row = 0; row < canGo.length; row++) {
            for(int col = 0; col < canGo[row].length; col++) {
                for (int dir = 0; dir < 4; dir++) {
                    canGo[row][col][dir] = true;
                }
            }
        }

        for (int r = 0; r < R; r++) {
            st = new StringTokenizer(br.readLine(), " ");
            int row = Integer.parseInt(st.nextToken());
            int col = Integer.parseInt(st.nextToken());
            int toRow = Integer.parseInt(st.nextToken());
            int toCol = Integer.parseInt(st.nextToken());

            int dir = 0; // 상하좌우 0,1,2,3
            if(row == toRow) {
                if(toCol - col == 1) {
                    dir = 3;
                } else {
                    dir = 2;
                }
            } else {
                if(toRow - row == 1)
                    dir = 1;
            }

            canGo[row][col][dir] = false;
            int reverseDir = dir + 1;
            if(reverseDir == 2 || reverseDir == 4) {
                reverseDir -= 2;
            }
            canGo[toRow][toCol][reverseDir] = false;
        }

        List<Point> cows = new ArrayList<>();
        for (int k = 0; k < K; k++) {
            st = new StringTokenizer(br.readLine(), " ");
            int row = Integer.parseInt(st.nextToken());
            int col = Integer.parseInt(st.nextToken());
            cows.add(new Point(row,col));
        }

        int ans = 0;

        for (int cow = 0; cow < cows.size(); cow ++) {
            clearGrid();
            Point curCow = cows.get(cow);
            int curRow = curCow.row;
            int curCol = curCow.col;
            move(curRow, curCol, N);

            for (int checkCow = cow + 1; checkCow < cows.size(); checkCow ++) {
                Point nextCow = cows.get(checkCow);
                int nextRow = nextCow.row;
                int nextCol = nextCow.col;
                if(!cowMove[nextRow][nextCol]) ans++;
            }
        }
        System.out.println(ans);
    }

    static void clearGrid () {
        for(int row = 0; row < cowMove.length; row++) {
            for(int col = 0; col < cowMove[row].length; col++) {
                cowMove[row][col] = false;
            }
        }
    }

    static void move(int row, int col, int size) {
        Queue<Point> q = new LinkedList<>();
        q.add(new Point(row,col));
        cowMove[row][col] = true;


        while(!q.isEmpty()) {
            Point p = q.poll();
            int curRow = p.row;
            int curCol = p.col;

            for(int dir = 0; dir < 4; dir++) {
                if(canGo[curRow][curCol][dir]) {
                    int nextRow = curRow + drow[dir];
                    int nextCol = curCol + dcol[dir];
                    if(nextRow <= size && nextRow >= 1 && nextCol <= size && nextCol >= 1) {
                        if (!cowMove[nextRow][nextCol]) {
                            q.add(new Point(nextRow,nextCol));
                            cowMove[nextRow][nextCol] = true;
                        }
                    }
                }
            }
        }
    }
}