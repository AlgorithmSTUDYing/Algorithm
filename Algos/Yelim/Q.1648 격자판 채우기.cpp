#include <iostream>
#include <cstring>

using namespace std; 

const int MAX = 14;
const int MOD = 9901;

int N, M;
int D[MAX*MAX][1 << MAX];
//  D[i][bit] : i-1 �� Ÿ�ϱ��� ä�����ְ�, i�����κ��� M���� Ÿ���� ���°� bit�� ����� �� 
// ex. D[7][5] : 7��° ĭ���� M���� ĭ�� ���°� 5�̴�. ( 5 = 0 0 0 1 0 1 (2) ) 

int tiling(int i, int bit) {

        //���� ä�����ٸ� ����� 1�� �����ش�.
        if (i == N * M && bit == 0)
                 return 1;

        //������ ĭ���� ���µ� �� ä������ ���� ��� ���дϱ� 0�� ��ȯ
        if (i >= N * M)
                 return 0;       
		
        // D[i][bit] : i-1 �� Ÿ�ϱ��� ä�����ְ�,
        // i������ M���� Ÿ���� ���°� bit�� ����� �� 
        int &result = D[i][bit];		
        if (result != -1)
                 return result;
                 
        result = 0;

        // i��°�� �̹� ä���� �־ ĭ�� ä�� �� ���� ���
        // ���� ĭ�� ä���� ��
        // bit�� ���������� �Ѻ�Ʈ ����Ʈ
        if (bit & 1)
            	  result = tiling(i + 1, (bit >> 1));
        //�ش� ĭ�� ĥ�������� �ʴٸ� ä������
        else {
        		//�ش� ĭ�� ���� ��ġ���� �׻� �»���̶�� �����ϰ� Ǭ��
                 //2 * 1           
                 result = tiling(i + 1, (bit >> 1) | (1 << (M - 1)));

                 //1 * 2
                 //M - 1��° Ÿ�Ͽ� ��ġ���� �ʾҰ� (�̷� ��� 1 * 2�� ���� �� �����ϱ�) 
                 //����ĭ�� ������� ���
                 if ((i % M) != (M - 1) && (bit & 2) == 0)
                         result += tiling(i + 2, bit >> 2);
        }
        return result %= MOD;
} 

int main(void)
{
        ios_base::sync_with_stdio(0);
        cin.tie(0);

        cin >> N >> M; // N x M ĭ

        memset(D, -1, sizeof(D));
        cout << tiling(0, 0) << "\n";

        return 0;
}