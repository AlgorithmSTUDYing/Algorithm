#include<iostream>
#include<algorithm>
using namespace std;

int main() {
	int dp[101][101] = { 0, }, map[101][101] = { 0, };
	int n, m;
	cin >> n >> m;
	for (int i=1; i <= n; i++) {//��ġ�� ���� ���� �Է�
		for (int j = 1; j <=m; j++) {
			cin >> map[i][j];
		}
	}
	for (int i=1; i <= n; i++) {
		for (int j = 1; j <= m; j++) {
			dp[i][j] = map[i][j]+max(dp [i - 1][j], dp[i][j - 1]);//��, ���� dp���� ū���� ������ġ�� ���������� ����
		}
	}
	cout << dp[n][m] << endl;

}