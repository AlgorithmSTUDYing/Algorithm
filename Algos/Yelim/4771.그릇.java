package algorithm;

import java.util.Scanner;

public class Question1 {

	public static void main(String[] args) {
		// �׸��� �ٴڿ� ������ �� �� ���̴� 10cm 
		// �׷��� �� ���� �׸��� ���� �������� ������ �� ���̴� 5cm�� ����
		// ���� �ݴ�������� ���̸� ���̴� �׸���ŭ, �� 10cm ����
		// �Է� ���� 
		// ()()() ))( => ���� �ݴ���� (10x6) = 60  + �������� (5x2) = 10 + �ٸ����� 10
		// �� 80
		
		
		Scanner sc = new Scanner(System.in);
		String su = sc.next();
		
		// 1. ���ڿ� �ɰ������� �迭�� �ְ� �迭�� ���̸�ŭ for�� ������ �˻�
		// 2. 0��° �迭�� ������ +10
		// 3. �� �������ʹ� (1) ���� �迭���ҿ� ������ +5  (2) �ٸ��� +10
		
		String a[] = su.split("");
		int height=0;
		
		for(int i=0; i<a.length; i++) {
			
			if(i==0)
				height = 10; 
			else if (a[i].equals(a[i-1]))
						height +=5;
			else
						height +=10;
			
		}
		
		System.out.println("�����" + height);

	}

}
