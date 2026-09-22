#include <string>
#include <queue>
#include <vector>
#include <stack>
using namespace std;

int solution(vector<int> priorities, int location) {
    int answer = 0;
    priority_queue<int> pq;
    queue<pair<int,int>> q;
    
    for(int i = 0; i < priorities.size(); i++) {
        q.push(make_pair(priorities[i], i));
        pq.push(priorities[i]);
    }
    
    while(!q.empty()) {
        auto [priority, num] = q.front();
        q.pop();
        
        if(priority < pq.top()) {
            q.push({priority,num});
        } else {
            answer++;
            if (num == location) {
                return answer;
            } 
            pq.pop();
        }
    }
    
    return answer;
}