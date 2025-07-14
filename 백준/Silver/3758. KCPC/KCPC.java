
import java.io.*;
import java.util.*;

class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;


    public static void main(String[] args) throws IOException {
        int T = Integer.parseInt(br.readLine());
        List<Team> teams = new ArrayList<>();

        for(int t = 0; t < T; t++) {
            st = new StringTokenizer(br.readLine(), " ");
            int team = Integer.parseInt(st.nextToken());
            int problem = Integer.parseInt(st.nextToken());
            int myId = Integer.parseInt(st.nextToken());
            int log = Integer.parseInt(st.nextToken());
            teams.clear();

            for(int i = 0; i < team; i++) {
                teams.add(new Team(i,0,0,0, problem));
            }

            for(int l = 1; l <= log; l++) {
                st = new StringTokenizer(br.readLine(), " ");
                int id = Integer.parseInt(st.nextToken()) - 1;
                int p = Integer.parseInt(st.nextToken());
                int score = Integer.parseInt(st.nextToken());

                teams.get(id).lastTime = l;
                teams.get(id).submit ++;

                Map<Integer,Integer> curTeamScores = teams.get(id).scores;
                int beforeScore = curTeamScores.get(p);
                if(score > beforeScore) {
                    curTeamScores.put(p,score);
                    teams.get(id).score = teams.get(id).score - beforeScore + score;
                }
            }

            Collections.sort(teams, (t1,t2) -> {
                if(t1.score == t2.score) {
                    if(t1.submit == t2.submit) {
                        return t1.lastTime - t2.lastTime;
                    }
                    return t1.submit - t2.submit;
                }
                return t2.score - t1.score;
            });

            for(int x = 0; x < team; x++){
                if(teams.get(x).id == myId -1) {
                    System.out.println(x+1);
                    break;
                }
            }
        }
    }

    static class Team {
        int id;
        int score;
        int submit;
        int lastTime;
        Map<Integer, Integer> scores = new HashMap<>();

        Team (int id, int score, int submit, int lastTime, int problems) {
            this.id = id;
            this.score = score;
            this.submit = submit;
            this.lastTime = lastTime;
            for(int i = 0; i <= problems; i++) {
                scores.put(i, 0);
            }
        }
    }
}

