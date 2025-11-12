
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static String answer = "";
    static int cnt = 0;

    public static void main(String[] args) throws IOException {
        int N = Integer.parseInt(br.readLine());

        int digits = 1;
        int[] digit;
        while(true) {
            if(digits == 11) break;
            digit = new int[digits];

            dfs(digit, 0 ,N);
            digits++;
        }
        if(!answer.isEmpty()) {
            System.out.println(answer);
        } else {
            System.out.println(-1);
        }
    }

    public static void dfs(int[] digits, int curDigit, int max) {
        if (cnt == max) {
            return;
        }

        if(curDigit >= digits.length) {
            cnt++;
            if (cnt == max) {
                answer = getDigits(digits);
            }
            return;
        }

        if (curDigit >= 1) {
            for (int i = 0; i < digits[curDigit - 1]; i++) {
                digits[curDigit] = i;
                dfs(digits, curDigit+1, max);
            }
        } else {
            for (int i = 0; i < 10; i++) {
                digits[curDigit] = i;
                dfs(digits, curDigit+1, max);
            }
        }
    }

    public static String getDigits(int[] digit){
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i <digit.length; i++) {
            sb.append(digit[i]);
        }
        return (sb.toString());
    }

}