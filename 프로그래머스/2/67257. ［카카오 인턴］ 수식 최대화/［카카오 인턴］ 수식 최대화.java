import java.util.*;

class Solution {
    public long solution(String expression) {
        List<Long> baseNums = new ArrayList<>();
        List<Character> baseOps = new ArrayList<>();

        long cur = 0;
        for (int i = 0; i < expression.length(); i++) {
            char ch = expression.charAt(i);
            if (ch >= '0' && ch <= '9') {
                cur = cur * 10 + (ch - '0');
            } else { // operator
                baseNums.add(cur);
                baseOps.add(ch);
                cur = 0;
            }
        }
        baseNums.add(cur);

        // 2) All precedence permutations (fixed 6)
        char[][] orders = {
                {'+', '-', '*'},
                {'+', '*', '-'},
                {'-', '+', '*'},
                {'-', '*', '+'},
                {'*', '+', '-'},
                {'*', '-', '+'}
        };

        long ans = 0;

        for (char[] order : orders) {
            List<Long> nums = new ArrayList<>(baseNums);
            List<Character> ops = new ArrayList<>(baseOps);

            for (char target : order) {
                for (int i = 0; i < ops.size(); ) {
                    if (ops.get(i) == target) {
                        long a = nums.get(i);
                        long b = nums.get(i + 1);
                        long res = calc(a, b, target);

                        nums.set(i, res);
                        nums.remove(i + 1);
                        ops.remove(i);
                    } else {
                        i++;
                    }
                }
            }

            ans = Math.max(ans, Math.abs(nums.get(0)));
        }

        return ans;
    }

    private long calc(long a, long b, char op) {
        if (op == '+') return a + b;
        if (op == '-') return a - b;
        return a * b; // '*'
    }
}