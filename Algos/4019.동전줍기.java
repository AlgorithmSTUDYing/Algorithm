package algorithm;
import java.util.Scanner;

public class Question2 {

	public static void main(String[] args) {		
		//8
		//5 7 10 1 2 10 11 6 => ��°�: 38		
		Scanner sc = new Scanner(System.in);
		int count;
		do {
			count = sc.nextInt(); // ���� ����
		}while(count>100 || count<2);
			
		int total = 0; //��� ��
		int arr[] = new int[count-1]; // ���� �� �Է¹��� int�� �迭
		int arr2[]  = new int[count-2] ;
		// ���� �� �Է� ����
		for(int i=0; i<arr.length; i++) {
			arr[i] = sc.nextInt();
		
			
		}

		for (int i=0; i<arr.length-1; i++) {
			arr2[i] = arr[i]+arr[i+1];
		}

		// �ִ밪 2�� ã��
		int temp=0;
		int max = arr2[0];
		for (int i=0; i<arr2.length; i++) {

			// �������� ���� (selection sort)
			for(i=0; i<arr2.length-1; i++) {
				for(int j=i+1; j<arr2.length; j++) {
					if(arr2[i]<arr2[j]) {
						temp = arr2[i];
						arr2[i] = arr2[j];
						arr2[j] = temp;
					}
				}
			}

			System.out.println(arr2[0] + arr2[1]);


		}

	}

}

