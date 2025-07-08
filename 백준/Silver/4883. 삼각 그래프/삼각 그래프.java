import java.io.*;
import java.util.*;

class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        int idx = 0;
        while(true) {
            int row = Integer.parseInt(br.readLine());
            if (row == 0) {
                break;
            }

            int[][] arr = new int[row][3];
            int[][] dp = new int[row][3];

            for(int i = 0; i < row; i++) {
                st = new StringTokenizer(br.readLine(), " ");
                arr[i][0] = Integer.parseInt(st.nextToken());
                arr[i][1] = Integer.parseInt(st.nextToken());
                arr[i][2] = Integer.parseInt(st.nextToken());
            }

            idx++;

            for(int i = 0; i < row; i++){
                if(i == 0) {
                    dp[0][0] = 987654321;
                    dp[0][1] = arr[0][1];
                    dp[0][2] = dp[0][1] + arr[0][2];
                    continue;
                }
                dp[i][0] = Math.min(dp[i-1][0] + arr[i][0], dp[i-1][1] + arr[i][0]);

                int secondMin1 = Math.min(dp[i][0] + arr[i][1], dp[i-1][0] + arr[i][1]);
                int secondMin2 = Math.min(dp[i-1][0] + arr[i][1], dp[i-1][1] + arr[i][1]);
                dp[i][1] = Math.min(secondMin1,secondMin2);
                dp[i][1] = Math.min(dp[i][1], dp[i-1][2] + arr[i][1]);

                dp[i][2] = Math.min(dp[i][1] + arr[i][2], dp[i-1][1] + arr[i][2]);
                dp[i][2] = Math.min(dp[i][2], dp[i-1][2] + arr[i][2]);
            }
            System.out.println(idx + ". " + dp[row-1][1]);

            arr = null;
            dp = null;
        }

    }
}