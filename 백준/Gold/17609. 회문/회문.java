

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        int N = Integer.parseInt(br.readLine());

        for(int i = 0; i < N; i++) {
            String s = br.readLine();
            System.out.println(getAnswer(s, 0));
        }
    }

    static int getAnswer(String s, int cnt) {
        int len = s.length();
        int start = 0;
        int end = len - 1;

        int ans = 0;
        while(start < end) {
            if(s.charAt(start) == s.charAt(end)) {
                start++;
                end--;
            }
            else {
                if(cnt == 1)
                    return 2;
                if (getAnswer(s.substring(start+1, end+1), 1) == 0) {
                    ans = 1;
                } else {
                    ans = 2;
                }
                if (getAnswer(s.substring(start, end), 1) == 0) {
                    if (ans == 2) ans = 1;
                } else {
                    if (ans == 0) ans = 2;
                }
                break;
            }
        }
        return ans;
    }
}