#include <string>
#include <vector>
#include <queue>
 
#define INF 987654321
using namespace std;
//다익스트라 
typedef pair<int, int> pp;
 
vector<pp> edges[101];
bool visited[101];
int res[101];
 
void dijkstra(int start, int costs) {
    priority_queue<pp, vector<pp>, greater<pp>> pq;
    pq.push(pp(costs, start));
    
    while(!pq.empty()) {
        pp now = pq.top(); pq.pop();
        
        if (visited[now.second]) continue; //이미 한 번 결정된 값은 번복 X
        
        visited[now.second] = true;
        
        for (auto i : edges[now.second] ) {
            //연결된 선들을 통해서 최단 경로를 완성한다. 
            int next = i.second;
            int n_cost = i.first;
            
            if (!visited[next] && res[next] >  n_cost) {
                res[next] = n_cost;
                pq.push(pp(res[next], next));
            }
        }
    }
}
int solution(int n, vector<vector<int>> costs) {
    int answer = 0;
    
    for (int i = 0; i < n; i++) {
        res[i] = INF; // 결과값을 무한대의 수로 초기화 
    }
    
    int min_c = INF, startidx = 0;
    for (int i = 0; i < costs.size(); i++) {
        edges[costs[i][0]].push_back(pp(costs[i][2], costs[i][1]));
        edges[costs[i][1]].push_back(pp(costs[i][2], costs[i][0]));
        if (min_c > costs[i][2]) {
            min_c = costs[i][2];
            startidx = costs[i][0];
        }
    }
    
    res[startidx] = 0;
    dijkstra(startidx, min_c);
    
    for (int i = 0; i < n; i++) {
        // cout << res[i] << '\n';
        if (visited[i]) {
            answer += res[i];
        }
    }
 
    return answer;
}
