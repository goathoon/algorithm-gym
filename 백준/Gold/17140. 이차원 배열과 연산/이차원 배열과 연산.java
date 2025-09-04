

import java.io.*;
import java.util.*;

class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int[][] grid = new int[201][201];

    public static void main(String[] args) throws IOException {
        for(int i = 0; i < grid.length; i++){
            for(int j = 0; j <grid[0].length; j++){
                grid[i][j] = -1;
            }
        }

        String s;
        st = new StringTokenizer(br.readLine(), " ");
        int r = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int idx = 0;
        for(int x = 0; x < 3; x++){
            st = new StringTokenizer(br.readLine(), " ");
            for(int i = 0; i < 3; i++) {
                grid[idx][i] = Integer.parseInt(st.nextToken());
            }
            idx++;
        }

        int ans = 0;
        while(true) {
            if(ans > 100) {
                System.out.println(-1);
                break;
            }

            if(grid[r-1][c-1] == k) {
                System.out.println(ans);
                break;
            }
            int colSize = getColSize(grid[0]);
            int rowSize = getRowSize(grid);

            if (rowSize >= colSize) {
                int maxSize = 0;
                for (int row = 0 ; row < rowSize; row++){
                    int[] sortedArr = sort(grid[row]);

                    for(int i = 0; i < sortedArr.length; i++) {
                        grid[row][i] = sortedArr[i];
                    }
                    for(int x = sortedArr.length; x < grid[0].length; x++){
                        if(grid[row][x] > 0) {
                            grid[row][x] = -1;
                        }
                    }

                    maxSize = Math.max(sortedArr.length, maxSize);
                }
                for (int row = 0; row < rowSize; row++) {
                    for(int i = 0; i < maxSize; i++){
                        if(grid[row][i] == -1)
                            grid[row][i] = 0;
                    }
                }
            } else {
                int maxSize = 0;
                for (int col = 0 ; col < colSize; col++){
                    int[] temp = new int[rowSize];
                    for(int row = 0; row < rowSize; row++) {
                        temp[row] = grid[row][col];
                    }
                    int[] sortedArr = sort(temp);
                    for(int i = 0; i < sortedArr.length; i++) {
                        grid[i][col] = sortedArr[i];
                    }
                    for(int x = sortedArr.length; x < grid.length; x++){
                        if(grid[x][col] > 0) {
                            grid[x][col] = -1;
                        }
                    }
                    maxSize = Math.max(sortedArr.length, maxSize);
                }
                for (int col = 0; col < rowSize; col++) {
                    for(int i = 0; i < maxSize; i++){
                        if(grid[i][col] == -1)
                            grid[i][col] = 0;
                    }
                }
            }
            ans++;
        }
    }

    static int getColSize(int[] list) {
        for(int i = 0; i <list.length; i++) {
            if(list[i] == -1) {
                return i;
            }
        }
        return grid[0].length;
    }

    static int getRowSize(int[][] list) {

        for(int i = 0; i <list.length; i++) {
            if(list[i][0] == -1) {
                return i;
            }
        }
        return grid.length;
    }

    static int[] sort (int[] list) {
        Map<Integer, Integer> countMap = new HashMap<>();
        for(int i = 0; i < list.length; i++) {
            int x = list[i];
            if(x == -1 || x == 0) continue;

            if(countMap.get(x) == null) {
                countMap.put(x,1);
            } else {
                countMap.put(x, countMap.get(x) + 1);
            }
        }

        List<Pair> sortedList = new ArrayList<>();
        for(int key : countMap.keySet()) {
            sortedList.add(new Pair(key, countMap.get(key)));
        }

        sortedList.sort((p1,p2) -> {
            if(p1.cnt == p2.cnt) {
                return p1.number - p2.number;
            }
            return p1.cnt - p2.cnt;
        });

        int[] returnArr = new int[sortedList.size()*2];
        int idx = 0;
        for(Pair p : sortedList) {
            returnArr[idx++] = p.number;
            returnArr[idx++] = p.cnt;
        }
        return returnArr;
    }

    static class Pair {
        int number;
        int cnt;

        Pair(int number, int cnt) {
            this.number = number;
            this.cnt = cnt;
        }
    }
}

