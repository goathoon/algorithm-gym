import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Main {
    static List<Cell> list;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int T = Integer.parseInt(st.nextToken());
        boolean[] visit = new boolean[n+1];
        Queue<Cell> q = new LinkedList<>();
        list = new ArrayList<>();
        list.add(new Cell(0, 0, 0));

        for (int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine());
            int row = Integer.parseInt(st.nextToken());
            int col = Integer.parseInt(st.nextToken());
            Cell cell = new Cell(i, row, col);
            list.add(cell);
        }

        Collections.sort(list, (c1,c2) -> c1.row - c2.row);
        q.add(new Cell(0,0,0,0));
        visit[0] = true;
        while(!q.isEmpty()) {
            Cell cell = q.poll();
            int curRow = cell.row;
            int curCol = cell.col;
            int curCnt = cell.cnt;
            if(curCol == T) {
                System.out.println(curCnt);
                System.exit(0);
            }
            int minIdx = binSearchLow(curRow-2);
            int maxIdx = binSearchHigh(curRow+2)-1;

            for(int idx = minIdx; idx <= maxIdx; idx++) {
                Cell nextCell = list.get(idx);
                if(nextCell.col <= curCol + 2 && nextCell.col >= curCol - 2){
                    if(visit[nextCell.number]){
                        continue;
                    }
                    visit[nextCell.number] = true;
                    q.add(new Cell(nextCell.number, nextCell.row, nextCell.col, curCnt + 1));
                }
            }
        }
        System.out.println(-1);
    }

    static int binSearchLow(int row) {
        int start = 0;
        int end = list.size();
        while(start < end) {
            int mid = (start + end) / 2;
            Cell cell = list.get(mid);
            if(cell.row >= row) {
                end = mid;
            } else {
                start = mid + 1;
            }
        }
        return start;
    }

    // 상계 (처음 row보다 큰게 등장하는 index)
    static int binSearchHigh(int row) {
        int start = 0;
        int end = list.size();
        while(start < end) {
            int mid = (start + end) / 2;
            Cell cell = list.get(mid);
            if(cell.row > row) {
                end = mid;
            } else {
                start = mid + 1;
            }
        }
        return start;
    }

    static class Cell {
        int number;
        int row;
        int col;
        int cnt;

        Cell (int number, int row, int col) {
            this.number = number;
            this.row = row;
            this.col = col;
        }

        Cell (int number, int row, int col, int cnt) {
            this.number = number;
            this.row = row;
            this.col = col;
            this.cnt = cnt;
        }
    }
}