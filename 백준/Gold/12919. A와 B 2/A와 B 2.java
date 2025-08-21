

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        String S = br.readLine();
        String T = br.readLine();

        if(dfs(S,T)) System.out.println("1");
        else System.out.println("0");
    }

    public static boolean dfs(String s, String t) {
        if(s.equals(t)) return true;
        if(s.length() == t.length()) return false;

        boolean val = false;

        if(t.charAt(t.length()-1) == 'A') {
            val |= dfs(s, t.substring(0,t.length()-1));
        } if(t.charAt(0) == 'B') {
            val |= dfs(s, reverseString(t.substring(1)));
        }
        return val;
    }

    public static String reverseString(String s) {
        StringBuilder sb= new StringBuilder();
        for(int i = s.length()-1; i >= 0; i--){
            sb.append(s.charAt(i));
        }
        return sb.toString();
    }

}