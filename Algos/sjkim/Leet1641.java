public class Leet1641 {
	/***
	 * 1 <= n <= 50
	 */
	public int countVowelStrings(int n) {
		int[][] arr = new int[50][5];
		arr[0] = new int[] { 1, 1, 1, 1, 1 };
		arr[1] = new int[] { 1, 2, 3, 4, 5 };
		for (int i = 2; i < n; i++) {
			for (int j = 0; j < 5; j++) {
				if (j == 0) {
					arr[i][j] = 1;
					continue;
				}
				/*
				 * n = 1, 1 1 1 1 1 2, 1 2 3 4 5 3, 1 1+2 1+2+3 ~..
				 * 
				 * 50, 1 1+~
				 */
				arr[i][j] = sum(arr[i - 1], j);
			}
		}
		return sum(arr[n - 1], 5);
//		return Arrays.stream(arr[n - 1]).sum();
	}

	public int sum(int[] arr, int n) {
		int result = 0;
		for (int i = 0; i < n + 1; i++) {
			result += arr[i];
		}
		return result;
	}
}
