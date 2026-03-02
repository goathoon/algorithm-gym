import java.util.*;

class Solution
{
    public int solution(int []A, int []B)
    {
        Arrays.sort(A);
        Arrays.sort(B);
        
        int len = A.length;
        int answer = 0;
        
        for(int ai = 0; ai < A.length; ai++) {
            answer += A[ai] * B[len - ai - 1];
        }
        
        return answer;
    }
}