//가장 큰 K x K 를 찾기
//DP
class Solution {
   public int largestMagicSquare(int[][] grid) {
		int m = grid.length;
		int n = grid[0].length;
		int k = 0;

		if (m > n) {
			k = n;
		} else {
			k = m;
		}
       
		while(k > 1) {
			for(int i=0;i<=m-k;i++) {
				for(int j=0;j<=n-k;j++) {
					int[][] tempGrid = getGrid(k, i,j, grid);
					if(check(tempGrid)) {
						return k;
					}
				}
			}
			k--;
		}
		return k;
	}
	public int[][] getGrid(int size, int sRow, int sCol, int[][] grid){
		int[][] oGrid = new int[size][size];
		for(int i=sRow, x=0; i < sRow+size ;i++, x++) {
			for(int j= sCol,y=0 ; j < sCol+size; j++, y++) {
				oGrid[x][y] = grid[i][j];
			}
		}
		return oGrid;
	}

	public boolean check(int[][] grid) {
		boolean flag = true;//magic square 인지 최종 판별
        
		int value = 0;
		int k = grid.length;
		int sumRow = 0;
		int sumCol = 0;
		int sumDiagonal_1 = 0;
		int sumDiagonal_2 = 0;

		for (int i = 0; i < k; i++) {
			for (int j = 0; j < k; j++) {
				sumRow += grid[i][j];
				sumCol += grid[j][i];
			}
			sumDiagonal_1 += grid[i][i];
			sumDiagonal_2 += grid[i][(k-1) - i ];
			
			if(i==0) {
				value = sumRow;
			}
			// 행,열 합계 값 확인
			if (sumRow != sumCol || value != sumRow || value != sumCol) {
				flag = false;
				break;
			} else {
				value = sumRow;
			}
			sumRow = 0;
			sumCol = 0;
		}
        //대각선 합계 값 확인
		if (sumDiagonal_1 != value || sumDiagonal_2 != value) {
			flag = false;
		}

		return flag;
	}
}