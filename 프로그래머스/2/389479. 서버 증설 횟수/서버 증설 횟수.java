class Solution {
    public int solution(int[] players, int m, int k) {
        int[] minusServers = new int[players.length + players.length];
        int answer = 0;
        
        int cur = 1;
        for(int i = 0; i < players.length; i++) {
            cur += minusServers[i];
            int addServer = (players[i] / m) - cur + 1 >= 0 ? (players[i] / m) - cur + 1 : 0;
            cur += addServer;
            answer += addServer;
            minusServers[i + k] -= addServer;
        }
        return answer;
    }
}