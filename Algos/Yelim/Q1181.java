package Boj;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

/* <���� ����>
1. ���̰� ª�� �ͺ���
2. ���̰� ������ ���� ������
3. ���� �ܾ ���� �� �Էµ� ��쿡�� �� ������ ���
 */
public class Q1181 {
	public static void main(String[] args) throws IOException { 

		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt(); // �ܾ� ����
		List<String> n = new ArrayList<String>(20010); 
		
		for(int i =0; i<T; i++){ 
			String temp= sc.next();
			if(!n.contains(temp)) 		//3�� ����
				n.add(temp); 
		}		

		//1�� ���� ���̴� String x������ .length()�� ���ؼ� üũ 
		// Comparator  Ŭ������ Main()�޼ҵ� �ȿ����� ���� ���̱� ������ ����Ŭ������ ������
		Comparator<String> myComparator = new Comparator<String>() { 
			public int compare(String x, String y) {
				if(x.length()>y.length()){ 
					return 1;
				} else if(x.length()==y.length()){  
					return x.compareTo(y); 
				} 				
				return -1;  // x < y �̸�, (������ ����)
			}
		}; 

		//2�������� CompareTo�� ���ؼ� �ذ�. 
		Collections.sort(n, myComparator);
		for(int i =0; i<n.size(); i++){ 
			System.out.println(n.get(i)); 
		} 
	}

}