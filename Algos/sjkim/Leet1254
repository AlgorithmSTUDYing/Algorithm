
public class Leet1254 {
	int cntZero = 0;
	int[][] copyGrid;//visit check
	boolean isLand = true;
	public int closedIsland(int[][] grid) {
		int n = grid.length; 		//가로
		int m = grid[n-1].length;	//세로
		copyGrid = grid;
		int cnt = 0;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				srchLand(i, j, n, m);
				if(cntZero > 0) {
					if(isLand) {
						cnt++;
					}
					isLand = true;
					cntZero=0;
				}
			}
		}
		return cnt;
	}
	
	public void srchLand( int i, int j, int n, int m) {
		if(copyGrid[i][j] == 1) return;
		
		copyGrid[i][j] = 1;
		
		if(i == 0 || j == 0||i == n-1 || j == m-1) {
			isLand = false;
		}
		
		/*동북서남 탐색*/
		if(j > 0)
			srchLand(i,j-1,n,m);
		if(i >0)
			srchLand(i-1,j,n,m);
		if(j < m-1)
			srchLand(i,j+1,n,m);
		if(i < n-1)
			srchLand(i+1,j,n,m);
		cntZero++;
	}
}
