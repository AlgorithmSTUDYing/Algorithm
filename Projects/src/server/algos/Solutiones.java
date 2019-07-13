package server.algos;

import java.util.*;

//file Ŭ����
class File {
	int idx;
	int pri;

	File(int idx, int pri) {
		this.idx = idx;
		this.pri = pri;
	}
}

class Solutiones {
	// �߿䵵 ���� �迭
	static int[] priority = new int[10];

	// ����Ʈ �����ϸ� true ��ȯ
	public static boolean check(File temp) {
		int tempP = temp.pri;
		for (int i = tempP + 1; i < 10; i++) {
			if (priority[i] != 0) {
				return false;
			}
		}
		return true;
	}

	public int solution(int[] priorities, int location) {
		int len = priorities.length;
		// ���� ��� ť
		Queue<File> q = new LinkedList<File>();
		// �߿䵵 �迭 ���� �� ���� ��� ť ����
		for (int i = 0; i < len; i++) {
			priority[priorities[i]]++;
			q.add(new File(i, priorities[i]));
		}
		// ����
		int answer = 0;
		while (!q.isEmpty()) {
			File t = q.remove();
			// ����Ʈ �������� Ȯ��
			boolean flag = check(t);
			// ����Ʈ �����ϴٸ� flag = true
			if (flag) {
				// ����+
				answer++;
				// ã�� �Ŷ��
				if (t.idx == location) {
					return answer;
				}
				// ã���� �ƴ϶�� �߿䵵 ���� -
				priority[t.pri]--;
			}
			// ����Ʈ �Ұ����̸� ��� ���� �ڿ� �ٽ� ����
			else {
				q.add(t);
			}
		}
		return answer;
	}
}
