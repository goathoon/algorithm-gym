class Solution {
    
    class Point {
        int x;
        int y;
        
        Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    
    public int[] solution(int m, int n, int startX, int startY, int[][] balls) {
        int[] answer = new int[balls.length];
        
        Point start = new Point(startX, startY);
        
        for(int i = 0; i < balls.length; i++) {
            int[] ball = balls[i];
            
            int minVal = Integer.MAX_VALUE;
            
            Point point1 = new Point(m + m - ball[0], ball[1]);
            Point point2 = new Point(-ball[0], ball[1]);
            Point point3 = new Point(ball[0], n + n - ball[1]);
            Point point4 = new Point(ball[0], -ball[1]);
            
            if(start.x < ball[0] && start.y == ball[1]) {
                minVal = Math.min(getDistance(start, point2), minVal);
                minVal = Math.min(getDistance(start, point3), minVal);
                minVal = Math.min(getDistance(start, point4), minVal);
                
            }else if(start.x > ball[0] && start.y == ball[1]) {
                minVal = Math.min(getDistance(start, point1), minVal);
                minVal = Math.min(getDistance(start, point3), minVal);
                minVal = Math.min(getDistance(start, point4), minVal);
            }else if(start.y < ball[1] && start.x == ball[0]) {
                minVal = Math.min(getDistance(start, point1), minVal);
                minVal = Math.min(getDistance(start, point2), minVal);
                minVal = Math.min(getDistance(start, point4), minVal);
            }else if(start.y > ball[1] && start.x == ball[0]) {
                minVal = Math.min(getDistance(start, point1), minVal);
                minVal = Math.min(getDistance(start, point2), minVal); 
                minVal = Math.min(getDistance(start, point3), minVal);
            } else {
                minVal = Math.min(getDistance(start, point1), minVal);
                minVal = Math.min(getDistance(start, point2), minVal); 
                minVal = Math.min(getDistance(start, point3), minVal);
                minVal = Math.min(getDistance(start, point4), minVal);
            }
            
            
            answer[i] = minVal;
        }
        
        return answer;
    }
    
    public int getDistance(Point start, Point end) {
        int sx = start.x;
        int ex = end.x;
        
        int sy = start.y;
        int ey = end.y;
        
        System.out.println("ex = " + ex + "Ey = "+ ey);

        return (int) (Math.pow(Math.abs(sx - ex), 2) + Math.pow(Math.abs(sy - ey), 2));
    }
}