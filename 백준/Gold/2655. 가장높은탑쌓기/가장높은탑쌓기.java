
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        int N = Integer.parseInt(br.readLine());
        Block[] areaSort = new Block[N];
        int[] dp = new int[N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int number = i+1;
            int area = Integer.parseInt(st.nextToken());
            int height = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());

            areaSort[i] = new Block(number, area, height, weight);
        }

        Arrays.sort(areaSort, (b1,b2) -> {
            if(b1.area == b2.area) {
                return b1.weight - b2.weight;
            }
            return b1.area - b2.area;
        });

        for(int i = 0; i < areaSort.length; i++) {
            dp[i] = areaSort[i].height;
            for(int j = 0; j < i; j++) {
                if(areaSort[j].weight <= areaSort[i].weight) {
                    if(dp[i] < dp[j] + areaSort[i].height) {
                        dp[i] = dp[j] + areaSort[i].height;
                    }
                }
            }
        }

        int maxHeight = 0;
        for (int i=0; i < dp.length; i++) {
            if (maxHeight < dp[i]) maxHeight = dp[i];
        }
        int index = dp.length-1;
        ArrayList<Integer> result = new ArrayList<>();

        while (index!=-1) {
            if (maxHeight == dp[index]) {
                result.add(areaSort[index].number);
                maxHeight -= areaSort[index].height;
            }
            index--;
        }

        System.out.println(result.size());
        for (int i=result.size()-1; i>=0; i--) {
            System.out.println(result.get(i));
        }
    }

    static class Block {
        int number;
        int area;
        int height;
        int weight;

        Block (int number, int area, int height, int weight) {
            this.number = number;
            this.area = area;
            this.height = height;
            this.weight = weight;
        }
    }

}