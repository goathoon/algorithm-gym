import java.util.*;
class Solution {
    static int[] answer;
    static int[][] diceA;
    static int[][] diceB;
    static int a = 0;
    static int b = 0;
    static Set<Integer> choiceA = new HashSet<>();
    static int max = 0;
    
    // 주사위 고르기
    public void pickDiceAndSum(int n, int depth, int idx, int[][] dice) {
        if(n == depth) {
            // 고른 주사위에서 하나씩 고른 합을 배열에 저장 (A, B)
            for(int i = 0; i < dice.length; i++){
                if(!choiceA.contains(i)){
                    diceB[b++] = dice[i];
                } 
            }
            calculateWinning(diceA,diceB);
            b = 0;
            return;
        }
        
        for(int i = idx; i < dice.length; i++) {
            choiceA.add(i);
            diceA[a++] = dice[i];
            pickDiceAndSum(n, depth+1, i+1, dice);
            diceA[--a] = null;
            choiceA.remove(i);
            // pickDiceAndSum(n, depth, i+1, dice);
        }
        
    }
    
    public void calculateWinning(int[][] diceA, int[][] diceB) {
        // A배열의 각 원소를 순회하며 B배열의 원소보다 큰 횟수를 계산 (승리 횟수)  
        List<Integer> dicesA = new ArrayList<>();
        recursiveDice(0,0,diceA,dicesA);
        
        List<Integer> dicesB = new ArrayList<>();
        recursiveDice(0,0,diceB,dicesB);
        
        int win = 0;
        
        Collections.sort(dicesB);
        for(int a : dicesA) {
            int l = 0;
            int r = dicesB.size();
            while(l < r) {
                int mid = (l+r)/2;
                if(a > dicesB.get(mid)){
                    l = mid+1;
                } else {
                    r = mid;
                }
            }
            win += l;
            max = Math.max(max,win);
            
            int idx = 0;
            if(max == win) {
                for(int x : choiceA) {
                    answer[idx++] = x+1;
                }
            }
            
        }
    }
    
    // 선택한 주사위의 눈의 합을 저장
    public void recursiveDice(int depth, int sum, int[][] dice, List<Integer> dices) {
        if (dice.length == depth) {
            dices.add(sum);
            return;
        }
        for(int i = 0; i < 6; i++) {
            recursiveDice(depth+1, sum + dice[depth][i], dice, dices);
        }
    }
    
    
    public int[] solution(int[][] dice) {
        diceA = new int[dice.length/2][6];
        diceB = new int[dice.length/2][6];
        answer = new int[dice.length/2];
        pickDiceAndSum(dice.length/2, 0, 0, dice);
        Arrays.sort(answer);
        return answer;
    }
}