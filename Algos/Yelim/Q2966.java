package Boj;

import java.util.Scanner;
// 2019-12-17
public class Q2966Test {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt(); // ������ �� (1<=n<=100)

		String ans1[] = new String[101]; // ����� ���� 100/3 = 1
		String ans2[] = new String[101]; // â���� ���� 100/4 = 0
		String ans3[] = new String[101]; // ������ ���� 100/6 = 4
		// A B C
		// B A B C
		// C C A A B B
		
		// 1. �����,â����,�������� �������Ͽ� �°� �迭 String ����
		String repeated1 = new String(new char[99]).replace("\0", "ABC");
		repeated1 = repeated1.concat("A");
		ans1 = repeated1.split(""); // �迭�� ������ ������ ���� ����
		String repeated2 = new String(new char[25]).replace("\0", "BABC");
		ans2 = repeated2.split("");
		String repeated3 = new String(new char[16]).replace("\0", "CCAABB");
		repeated3 = repeated3.concat("CCAA");
		ans3 = repeated3.split("");

		// 2. ������ ���� �Է¹��� (ex. AAAABBBBB)
		String str = sc.next().toUpperCase();
		str = str.substring(0,n);
		String answer[] = new String[101];
		answer = str.split(""); // ���� ���ڿ��� �迭�� ����
		
		// 3. ���� ����� 3���� ������ ���Ͽ� ���� ���� üũ
		int i = 0;
		int cnt1 =0; int cnt2=0; int cnt3=0;
		while (i < n) {
			if (answer[i].equals(ans1[i]))	// ����� ���� (Adrian)
				cnt1 ++;
			if (answer[i].equals(ans2[i])) // â���� ���� (Bruno)
				cnt2 ++;
			if (answer[i].equals(ans3[i])) // ������ ���� (Goran)
				cnt3 ++;
			i++;
		}
		
		// 4. ���� ���� ������ ���� ������ ���� max ���� �������
		int max=0;
		int[] arr = {cnt1,cnt2,cnt3};
		for(i=0; i<3; i++) {
			if(max<arr[i]) {
				max = arr[i];
			}
		}
		System.out.println(max); // ���� ���� ������ ���� ����� �� ���� ������� ���
		
		// 5. �ִ����䰹�� max�� ���� ���ڰ� �ִ� �迭 ���Ҹ� ã�� Ardian - Bruno - Goran ������� ���
		for (i=0; i<3; i++) {
			if(arr[i]==max) {
				switch(i) {
				case 0:
					System.out.println("Adrian");
					break;
				case 1:
					System.out.println("Bruno");
					break;
				case 2:
					System.out.println("Goran");
					break;
				}
			}
		}
	}
}