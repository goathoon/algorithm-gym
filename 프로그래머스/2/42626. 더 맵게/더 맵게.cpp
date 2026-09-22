#include <string>
#include <vector>
#include <queue>
#include <algorithm>
using namespace std;

int solution(vector<int> scoville, int K) {
    int answer = 0;

    priority_queue<int, vector<int>, greater<int>> pq;

    for (int x : scoville) {
        pq.push(x);
    }

    while (pq.size() >= 2 && pq.top() < K) {
        int x = pq.top();
        pq.pop();

        int y = pq.top();
        pq.pop();

        pq.push(x + 2 * y);
        answer++;
    }

    if (!pq.empty() && pq.top() >= K) {
        return answer;
    }

    return -1;
}