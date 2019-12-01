package algorithm;

import java.util.Arrays;
import java.util.Scanner;

public class Question3_1 {
	
	static int n;
	static int m;
	static int array[];
	
	public static long ans() {
		
		long current =0; // ����ż� ������ ����
		long max = 0; // �ִ�� ��µǴ� ����
		for(int i=0; i<n; i++) {
			
			if(array[i] * n < m) {
				current += array[i];						
			} else {
				max = (m-current) / (n-i);
				break;
			}
			
		}
		
		return max;
		
	}

	public static void main(String[] args) {
		
		Scanner in = new Scanner(System.in);
		n = in.nextInt();
		array = new int[n]; // 4
		long total =0;
		
		for(int i=0; i<n; i++) {
			array[i] = in.nextInt(); // {120, 110, 140, 150}
			total +=array[i];
		}
		
		m = in.nextInt(); // �� ����: 485
		in.close();
		
		// ����
		Arrays.sort(array); // 110  120  140  150
		
		// �迭 ������� 110 *4 �� �ؼ� ����Ⱥ��� ������ 
		// �� �迭���Ҵ� �״�� ������ ����
		// n: ���갹��(4) m: �ѿ���(485)
		
		if (total <= m) {
			System.out.println(array[n-1]);
		} else {
			System.out.println(ans());
		}
		
		
	}

}
