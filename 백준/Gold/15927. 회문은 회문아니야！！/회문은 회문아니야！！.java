
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        String s = br.readLine();

        // ABCDCBA
        boolean isAllSame = true;
        int len = s.length();
        for (int i = 0; i < len / 2; i++) {
            if (s.charAt(i) != s.charAt(len - i - 1)) {
                System.out.println(len);
                return;
            }
            if(s.charAt(i) != s.charAt(i+1)) isAllSame = false;
        }

        if (isAllSame) {
            System.out.println(-1);
        } else {
            System.out.println(len - 1);
        }
    }

}