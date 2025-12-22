

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        int[] arr = new int[n];

        for(int i = 0; i < n; i++ ){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        int stand = arr[0];

        for(int i = 1; i < arr.length; i++){
            int denom = gcd(stand, arr[i]);
            int a = stand / denom;
            int b = arr[i] / denom;
            System.out.println(a + "/" + b);
        }
    }

    public static int gcd (int a, int b){
        while(b != 0) {
            int remain = a % b;
            a = b;
            b = remain;
        }
        return a;
    }
}