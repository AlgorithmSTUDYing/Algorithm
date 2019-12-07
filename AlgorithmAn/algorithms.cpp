import java.util.*;

public class test { //����Ž�� << next_permutation�� ����� ��� �����غ��� < �ִ밪���� sum�� ���� ������ combination �� max ��������?
	public static int budget = 0;    // budget �Է��� ����
	public static int actNum = 0;    // budget activity �Է��� ����Ȱ�� ��(size)
	public static int[] actValue = null;    // budget array  �������� �� �迭
	public static int[] visited = null;        // budget used array Ž���� path�� ���� �� �迭
	public static int max = Integer.MIN_VALUE;    // Maximum budget �ִ�� Ž���� ���� �ִ밪
	public static String maxPath = "";            // Maximum budget passed path ������ �ִ�� Ž���� ���� �迭 

	// max�� maxPath ������� �ʰ� return�� ����� ���� ���̴� ��� �����غ���
	// func << �Է°����� �޴� �������ִ� �� �����ʰ� check
  // �־��� ����Ȱ������� �����Ͽ� �����ϴ� ���� �������� �ʰ� �����ϴ� ���� ������ ������� ȣ��� �ε����� ������Ų��.
	public static void main(final String[] args) {

		final Scanner scan = new Scanner(System.in);

		budget = scan.nextInt();
		actNum = scan.nextInt();
		actValue = new int[actNum];
		visited = new int[actNum];

		for (int i = 0; i < actNum; i++) { //insert budget array
			actValue[i] = scan.nextInt();
		}
		// initialization
		final int curValue = 0;    // current budget value
		final int curIndex = 0;    // current  index
		final String curPath = ""; // print current passed path value

		func(curValue, curIndex, curPath); // ���� ������ �ִ� �� ����üũ, �����뿹��� �ִ밪 �� �� max ��������
		System.out.println(max); //�ִ�� ����� ���� ��� �ݾ�

		scan.close();
	}


	private static void func(final int curValue, final int curIndex, final String curPath) {

		if (curValue > budget || curIndex == actNum) {
			return;
		} // ���� ����� ����� �ѿ��꺸�� ũ�ų�, �������ִ� ����Ȱ�� ���� �������� return

		if (max <= curValue) {
			max = curValue;
			maxPath = curPath;
		} //���� ��뿹��� �ִ밪 �� ���� ��뿹���� ũ�� �� ���� �ִ밪, �� ���� ��θ� maxpath�� ����


		// ���� Ȱ������� �������� ���� ���(�������) cur+1 �� �ٽ� func
		func(curValue, curIndex + 1, curPath);

		// ���� Ȱ������� ������ ���(ū ���) curvalue+actvalue[]�� ���� curvalue �Ķ��Ÿ�� �Ѱ��־� max���� ���, curpath�� curindex��actvalue �߰�
		func(curValue + actValue[curIndex], curIndex + 1, curPath + "," + actValue[curIndex]);
	}

}import java.util.*;

public class test { //����Ž�� << next_permutation�� ����� ��� �����غ��� < �ִ밪���� sum�� ���� ������ combination �� max ��������?
	public static int budget = 0;    // budget �Է��� ����
	public static int actNum = 0;    // budget activity �Է��� ����Ȱ�� ��(size)
	public static int[] actValue = null;    // budget array  �������� �� �迭
	public static int[] visited = null;        // budget used array Ž���� path�� ���� �� �迭
	public static int max = Integer.MIN_VALUE;    // Maximum budget �ִ�� Ž���� ���� �ִ밪
	public static String maxPath = "";            // Maximum budget passed path ������ �ִ�� Ž���� ���� �迭 

	// max�� maxPath ������� �ʰ� return�� ����� ���� ���̴� ��� �����غ���
	// func << �Է°����� �޴� �������ִ� �� �����ʰ� check
  // �־��� ����Ȱ������� �����Ͽ� �����ϴ� ���� �������� �ʰ� �����ϴ� ���� ������ ������� ȣ��� �ε����� ������Ų��.
	public static void main(final String[] args) {

		final Scanner scan = new Scanner(System.in);

		budget = scan.nextInt();
		actNum = scan.nextInt();
		actValue = new int[actNum];
		visited = new int[actNum];

		for (int i = 0; i < actNum; i++) { //insert budget array
			actValue[i] = scan.nextInt();
		}
		// initialization
		final int curValue = 0;    // current budget value
		final int curIndex = 0;    // current  index
		final String curPath = ""; // print current passed path value

		func(curValue, curIndex, curPath); // ���� ������ �ִ� �� ����üũ, �����뿹��� �ִ밪 �� �� max ��������
		System.out.println(max); //�ִ�� ����� ���� ��� �ݾ�

		scan.close();
	}


	private static void func(final int curValue, final int curIndex, final String curPath) {

		if (curValue > budget || curIndex == actNum) {
			return;
		} // ���� ����� ����� �ѿ��꺸�� ũ�ų�, �������ִ� ����Ȱ�� ���� �������� return

		if (max <= curValue) {
			max = curValue;
			maxPath = curPath;
		} //���� ��뿹��� �ִ밪 �� ���� ��뿹���� ũ�� �� ���� �ִ밪, �� ���� ��θ� maxpath�� ����


		// ���� Ȱ������� �������� ���� ���(�������) cur+1 �� �ٽ� func
		func(curValue, curIndex + 1, curPath);

		// ���� Ȱ������� ������ ���(ū ���) curvalue+actvalue[]�� ���� curvalue �Ķ��Ÿ�� �Ѱ��־� max���� ���, curpath�� curindex��actvalue �߰�
		func(curValue + actValue[curIndex], curIndex + 1, curPath + "," + actValue[curIndex]);
	}

}