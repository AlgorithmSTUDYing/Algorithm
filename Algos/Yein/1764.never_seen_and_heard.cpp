#include<iostream>
#include<algorithm>
#include<string>
#include<set>
#include<vector>
using namespace std;

int main(){
	int n,m;
	string name;
	set<string> heard_list;
	vector<string> both_list;
	cin>>n>>m;
	
	for(int i=0;i<n;i++){//���� ���� ���  
		cin>>name;
		heard_list.insert(name);
		
	}
	set<string>::iterator it;
	for(int i=0;i<m;i++){ //���� ���� ��� 
		cin>>name;
		it=heard_list.find(name);// ���� ���� ��� ����Ʈ�� �ִ��� Ȯ��  
		if(it!=heard_list.end()){ //���� ������ both_list�� �߰����ش�. 
			both_list.push_back(name);
		}
	}
	sort(both_list.begin(),both_list.end());//���� 
	cout<<both_list.size()<<endl;
	
	for(int i=0;i<both_list.size();i++){
		cout<<both_list[i]<<endl;
	}
}
