
import java.io.*;
import java.util.*;

class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static class Virus {
        int num;
        int row;
        int col;
        int sec;

        Virus(int num, int row, int col, int sec) {
            this.num = num;
            this.row = row;
            this.col = col;
            this.sec = sec;
        }
    }

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine(), " ");
        int size = Integer.parseInt(st.nextToken());
        int cnt = Integer.parseInt(st.nextToken());
        List<Virus> sortedViruses = new ArrayList<>();
        List<Virus> viruses = new LinkedList<>();
        int[][] virusGrid = new int[size][size];

        for (int r = 0; r < size; r++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int c = 0; c < size; c++) {
                int number = Integer.parseInt(st.nextToken());
                if(number != 0) {
                    sortedViruses.add(new Virus(number, r, c, 0));
                    virusGrid[r][c] = number;
                }
            }
        }
        st = new StringTokenizer(br.readLine(), " ");
        int finalSecond = Integer.parseInt(st.nextToken());
        int finalRow = Integer.parseInt(st.nextToken()) - 1;
        int finalCol = Integer.parseInt(st.nextToken()) - 1;

        sortedViruses.sort((v1,v2) -> {
            return v1.num - v2.num;
        });

        for(Virus v : sortedViruses) {
            viruses.add(v);
        }

        int[] drow = {0,1,0,-1};
        int[] dcol = {1,0,-1,0};
        while(!viruses.isEmpty() && viruses.get(0).sec < finalSecond) {
            Virus curVirus = viruses.get(0);
            viruses.remove(0);
            int col = curVirus.col;
            int row = curVirus.row;
            for(int i = 0; i < 4; i++) {
                int nextCol = col + dcol[i];
                int nextRow = row + drow[i];
                if(nextCol < 0 || nextCol >= size || nextRow < 0 || nextRow >= size) continue;
                if(virusGrid[nextRow][nextCol] != 0) continue;
                virusGrid[nextRow][nextCol] = curVirus.num;
                viruses.add(new Virus(curVirus.num, nextRow, nextCol, curVirus.sec+1));
            }
        }
        System.out.println(virusGrid[finalRow][finalCol]);
    }
}

