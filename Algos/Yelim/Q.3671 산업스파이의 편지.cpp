#include<iostream>
#include<string>
#include<vector>
#include<set>
#include<cstring>
 
#define endl "\n"
using namespace std;
 
string Inp; // �������� ���ڿ�
bool Select[7]; // �� �������� �����ߴ��� ���ߴ����� ���� t/f �� (�ִ� 7)
int Len, Answer; // �������� ���ڿ� ����
 
vector<char> V;
set<int> Visit;

// 2. �ʱ�ȭ
void Initialize()
{
    Inp.clear();
    Visit.clear();
    memset(Select, false, sizeof(Select)); // false�� ���� �ʱ�ȭ
    Answer = 0;
    Len = 0;
    V.clear();
}

// 3. �ϳ��� �׽�Ʈ ���̽��� ���� ���ڿ� �Է� ����
void Input()
{
    cin >> Inp;
    Len = Inp.length(); // ���� Len�� ���ڿ� ���� ����
}

// �Ҽ����� �Ǵ��ϴ� �Լ� 
bool Calculate(int Data)    
{
    if (Data < 2) return false;
    // 16�� ��� ����� 1 2 4 8 16 
    // => ��¥�� 2x8 = 8x2�ϱ� �ð����⵵ ���̱� ���ؼ� i*i�� ����Ͽ� �˻�
    for (int i = 2; i * i <= Data; i++)
    {
        if (Data % i == 0) return false;
    }
    return true;
}

// 5. vector�� ��� char ���ڵ��� ���ļ� ���ڷ� ��ȯ
int SumOf_Vector()
{
    int Sum = 0;
    for (int i = 0; i < V.size(); i++)
    {
        Sum = Sum + (V[i] - '0');
        if (i != V.size() - 1) 
        	Sum = Sum * 10;
    }
    return Sum;
}

// 4. DFS 
void DFS(int Cnt)
{
	// ���ڿ��� ���̺��� ũ�� ��ȯ
    if (Cnt > Len) return;
    if (V.size() != 0)
    {
        int Value = SumOf_Vector();
        // 111, 111 -> ���� dfs�� ���� ��, �̷��� �� ���� ���ؼ� �� �˻��� �ʿ� �����Ƿ�
        // �ߺ� üũ�ϱ� ���� set�� ����
        
        // int ������ ��ȯ�� Value���� ������, set�� �ش� Value���� ������ �Ҽ��˻�
        if (Visit.find(Value) == Visit.end())
        {
            Visit.insert(Value);
            // 6. Value�� �Ҽ����� �˻縦 ���� �Ҽ� ������ ++ ���ش�.
            if (Calculate(Value) == true) 
            		Answer++;
        }
    }
 	
    // 7. ���� DFS 
    for (int i = 0; i < Len; i++)
    {
        if (Select[i] == true) continue;
        Select[i] = true;
        // ������ ���̴ϱ� vector�� ����ִ´�.
        V.push_back(Inp[i]);
        DFS(Cnt + 1);
        Select[i] = false;
        V.pop_back();
    }
}
 
void Solution()
{
    DFS(0);
    cout << Answer << endl;
}

// 1. �׽�Ʈ ���̽� �Է¹޴´�.
void Solve()
{
    int Tc;
    cin >> Tc;
    for (int T = 1; T <= Tc; T++)
    {
        Initialize();
        Input();
        Solution();
 
    }
}
 
int main(void)
{
    ios::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);
 
    //freopen("Input.txt", "r", stdin);
    Solve();
 
    return 0;
}