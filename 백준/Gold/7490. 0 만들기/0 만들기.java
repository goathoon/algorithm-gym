import java.io.*;
import java.util.*;

class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int last;

    public static void main(String[] args) throws IOException {
        int N = Integer.parseInt(br.readLine());
        for(int i = 0; i < N; i++){
            last = Integer.parseInt(br.readLine());
            char[] arr = new char[2*last-1];
            for(int j = 0; j < arr.length; j ++){
                if(j%2 == 0) {
                    arr[j] = (char) ((j / 2 + 1) + '0');
                } else {
                    arr[j] = '.';
                }
            }
            solve(arr, 1);
            System.out.println();
        }
    }

    public static void solve(char[] arr, int cur) {
        if(cur == last) {
            String s = String.valueOf(arr);
            if(cal(s) == 0) {
                System.out.println(s);
            }
            return;
        }
        arr[cur*2-1] = ' ';
        solve(arr, cur+1);

        arr[cur*2-1] = '+';
        solve(arr,cur+1);

        arr[cur*2-1] = '-';
        solve(arr, cur+1);

    }

    public static int cal(String s) {
        char[] chars = s.toCharArray();
        List<Integer> list = new ArrayList<>();
        list.add(s.charAt(0) - '0');
        for(int i = 1; i < chars.length-1; i+=2){
            if(chars[i] == ' ') {
                int prior = list.get(list.size() - 1);
                list.set(list.size() - 1, prior * 10 + (chars[i + 1] - '0'));
            }
            else {
                list.add(s.charAt(i+1)-'0');
            }
        }
        int idx = 0;
        int ans = list.get(idx);
        for(int i = 1; i < chars.length-1; i+=2){
            if(chars[i] == '+'){
                ans += list.get(++idx);
            }
            else if(chars[i] == '-') {
                ans -= list.get(++idx);
            }
        }
        return ans;
    }
}

