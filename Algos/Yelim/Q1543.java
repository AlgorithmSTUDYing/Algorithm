package Boj;

import java.util.Scanner;

public class Q1543 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String doc = sc.nextLine(); // ��ü ����
		String findStr = sc.nextLine(); // ã������ ���ڿ�
		int total = 0; 		
		
		// ã������ ���ڿ��� �ִ� index�� ã�� findStr.length�� ���� ����
		// (*���ϴ� ���� - �ߺ��� �������� �̹� ã�� ���ڿ��� ������ ���·� �ٽ� �˻��ؾ��ϴϱ�)
		// �� �̻� ã������ ���ڿ��� ���� ������ �ݺ� �˻�
		
		for(; doc.indexOf(findStr) > -1; total ++) {		
			doc = doc.substring(doc.indexOf(findStr) + findStr.length(), doc.length());
		}				
		System.out.println(total);
	}
}