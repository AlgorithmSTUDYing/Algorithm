#include<iostream>
#include<vector>
using namespace std;
int main() {
	vector<int>v;
	int tc, n, days, max = -9999999;
	cin >> tc;
	cin >> days;
	for (int i = 0; i < tc; i++) {//�Ϻ� �µ� �Է�
		cin >> n;
		v.push_back(n);
	}
	int sum;
	for (int i = 0; i <= tc - days; i++) {
		sum = 0;
		for (int j = i, cnt = 0; cnt < days; j++, cnt++) {//i��°~i+days�� ��¥������ �µ��� ���ϱ�
			sum += v[j];
		}
		if (sum > max)max = sum;
	}
	cout << max;

}