import java.util.*;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        Queue<Task> q = new LinkedList<>();
        for(int i = 0; i < progresses.length; i++) {
            q.add(new Task(progresses[i], speeds[i]));
        }
        
        List<Integer> answer = new ArrayList<>();
        
        int time = 0;
        int curFinish = 0;
        while(!q.isEmpty()) {
            Task curTask = q.poll();
            int curP = curTask.progress;
            int speed = curTask.speed;
            
            int nowP = curP + speed * time;
            if(nowP >= 100) {
                curFinish++;
                continue;
            }
            
            if(curFinish != 0) {
                answer.add(curFinish);
            }
            
            curFinish = 0;
            time += Math.ceil((100-nowP) / (float)speed);
            curFinish++;
            
        }
        if(curFinish != 0) {
            answer.add(curFinish);
        }
        
        int[] ans = new int[answer.size()];
        for(int i = 0; i < answer.size(); i++) {
            ans[i] = answer.get(i);
        }
        return ans;
    }
    
    class Task {
        int progress;
        int speed;
        
        Task(int progress, int speed) {
            this.progress = progress;
            this.speed = speed;
        }
    }
}