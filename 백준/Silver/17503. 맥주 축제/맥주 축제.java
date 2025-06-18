import java.io.*;
import java.util.*;

class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static class Beer {
        int like;
        int level;

        Beer(int like, int level) {
            this.level = level;
            this.like = like;
        }
    }

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine(), " ");
        int day = Integer.parseInt(st.nextToken());
        int like = Integer.parseInt(st.nextToken());
        int beer = Integer.parseInt(st.nextToken());
        List<Beer> beers = new ArrayList<>();

        for (int b = 0; b < beer; b++) {
            st = new StringTokenizer(br.readLine(), " ");
            beers.add(new Beer(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
        }

        Collections.sort(beers, (b1,b2) -> {
            if(b1.like == b2.like) {
                return b1.level - b2.level;
            }
            return b2.like - b1.like;
        });

        long start = 0;
        long end = Integer.MAX_VALUE;
        boolean isDone = false;

        while(start <= end) {
            long mid = (start + end) / 2;
            long curLike = 0;
            int drinkDay = 0;
            for(int i = 0; i < beer; i++){
                Beer curBeer = beers.get(i);
                if(curBeer.level > mid) {
                    continue;
                }
                curLike += curBeer.like;
                drinkDay++;
                if(drinkDay == day) break;
            }
            if(curLike < like || drinkDay < day) {
                start = mid + 1;
            }
            else if (curLike >= like){
                end = mid - 1;
                isDone = true;
            }
        }
        if(isDone){
            System.out.println(start);
        }
        else {
            System.out.println(-1);
        }

    }
}

