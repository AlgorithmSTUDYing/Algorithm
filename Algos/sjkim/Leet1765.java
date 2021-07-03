class Leet1765 {
	public int[][] highestPeak(int[][] isWater) {
		int m = isWater.length;
		int n = isWater[0].length;


		Queue<Land> q = new LinkedList<Land>();
		int[][] map = new int[m][n];
		
		for(int i=0;i< m ; i++) {
			for(int j=0;j<n;j++) {
                
                //is water
                if(isWater[i][j] == 1){
				    q.offer(new Land(i,j));
                }
                else{
                    //is land
                    map[i][j] = -1;
                }
			}
		}
		int[] dx= {0,0,-1,1};//t d l r
		int[] dy= {1,-1,0,0};//t d l r
		
		while(!q.isEmpty()) {
            int cnt = q.size();
    		
			for(int i=0 ; i < cnt ; i++) {
                Land cur = q.poll();
				
                //search t d l r
                for(int d=0; d<4;d++){
                    int x = cur.x + dx[d];
                    int y = cur.y + dy[d];
                                        
                    
                    // is water or wall or visited
				    if(x < 0 || y < 0
                            || x >= m || y >= n || map[x][y] != -1 ) {
                        continue;
				    }
					
					//count
                    map[x][y] = map[cur.x][cur.y] + 1;
                    q.offer(new Land(x,y));
                    
                }
			}
		}
		
	    return map;
	}
    
    class Land{
		int x;
		int y;
		Land(int x, int y){
			this.x=x;
			this.y = y;
		}
	}
}