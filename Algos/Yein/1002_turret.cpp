#include <iostream>
#include <algorithm>
#include <cmath>
using namespace std;

int main(void){
    int tc;
    cin>>tc;
    int x1, x2, y1, y2, r1, r2, ret;
    for(int i=0; i<tc; i++){
        cin>>x1>>y1>>r1>>x2>>y2>>r2;
        

        double dist = sqrt(pow(x2- x1, 2) + pow(y2 - y1, 2));
        int b = max(r1, r2);
        int s = min(r1, r2);

        if(d == 0.0){
            if(big == small)
                ret = -1;//������ ���� ��� 
            else
                ret = 0;//��ġ�� �� �� (ū ���ȿ� ���� ���� ��� ����) 
        }else{
            if(big-small < d && big+small > d)//���� ������ ��ġ�� �� �� 
                ret = 2;
            else if(big+small == d || big-small == d) //����, ���� 
                ret = 1;
            else //�ָ� ������ �־� ��ġ�� �ʴ� ��� 
                ret = 0;
        }
        cout<<ret<<endl;
    }
    return 0;
}
