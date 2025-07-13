
import java.io.*;
import java.util.*;

class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int[] drow = {-2,-2,0,0,2,2};
    static int[] dcol = {-1,1,-2,2,-1,1};

    public static void main(String[] args) throws IOException {
        int N = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine(), " ");
        int[][] visited = new int[N][N];

        for(int i = 0; i < N; i++){
            for(int j = 0; j < N; j++){
                visited[i][j] = -1;
            }
        }

        int r1 = Integer.parseInt(st.nextToken());
        int c1 = Integer.parseInt(st.nextToken());
        int r2 = Integer.parseInt(st.nextToken());
        int c2 = Integer.parseInt(st.nextToken());

        Queue<Position> q = new LinkedList<>();
        q.add(new Position(r1,c1));
        visited[r1][c1] = 0;

        while(!q.isEmpty()){
            Position curPos = q.poll();
            if(curPos.row == r2 && curPos.col == c2) {
                break;
            }
            for(int i = 0; i < drow.length; i++){
                int nextRow = curPos.row + drow[i];
                int nextCol = curPos.col + dcol[i];
                if(nextRow < visited.length && nextRow >= 0 && nextCol < visited[0].length && nextCol >= 0){
                    if(visited[nextRow][nextCol] == -1){
                        q.add(new Position(nextRow, nextCol));
                        visited[nextRow][nextCol] = visited[curPos.row][curPos.col] + 1;
                    }
                }
            }
        }
        System.out.println(visited[r2][c2]);
    }

    static class Position {
        int row;
        int col;

        Position (int row, int col){
            this.row = row;
            this.col = col;
        }
    }
}

