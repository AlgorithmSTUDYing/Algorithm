#include <iostream>
#include <algorithm>

using namespace std;
const int MAX = 100 + 1;
const int INF = 100000 + 1;

int N, M;
int graph[MAX][MAX];

void floyd(void)
{

    // via��° ���ø� ���İ��°� �� ���� ��� update
    for (int via = 1; via <= N; via++)
    {
        for (int from = 1; from <= N; from++)
        {
            // from ���� ���İ��� �ٸ������� ��ΰ� ���� ���� �� �ʿ䵵 �����Ƿ�
            if (graph[from][via] == 0)
                continue;

            for (int to = 1; to <= N; to++)
            {
                // ���İ��� �ٸ����� to������ ��ΰ� ���� ��� or  
                // ��������� ���������� ���� ���� �� �ʿ䰡 �����Ƿ� 
                if (graph[via][to] == 0 || from == to)
                    continue;

                // graph[from][to] == 0 �� ���� ��ΰ� ���ٴ� �Ŵϱ�, ������ ���İ��� ��θ� �־��־�� �Ѵ� 
                if (graph[from][to] == 0 || graph[from][to] > graph[from][via] + graph[via][to])
                    graph[from][to] = graph[from][via] + graph[via][to];
            }
        }
    }
}

int main(void)
{
    cin >> N >> M;

    for (int i = 0; i < M; i++)
    {
        int from, to, cost;
        cin >> from >> to >> cost;

        if (!graph[from][to])
            graph[from][to] = cost;

        else //�̹� ��ΰ� �ִ� ��� �ּҰ� ����  - ������ ���� ���� ���ÿ� ���� ���ø� �����ϴ� �뼱�� �ϳ� �̻��� �� �ִٰ� �Ǿ�����.
            graph[from][to] = min(graph[from][to], cost);
    }

    floyd();

    for (int i = 1; i <= N; i++)
    {
        for (int j = 1; j <= N; j++)
            cout << graph[i][j] << " ";

        cout << "\n";
    }
    return 0;
}