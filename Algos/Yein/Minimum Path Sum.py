class Solution:
    def minPathSum(self, grid: List[List[int]]) -> int:
        row=len(grid)
        col=len(grid[0])
        
        for i in range(row):
            for j in range(col):
                if i==0 and j==0:
                    pass
                elif i==0:
                    grid[i][j]=grid[i][j-1]+grid[i][j]
                    
                elif j==0:
                    grid[i][j]=grid[i-1][j]+grid[i][j]
                
                else:
                    grid[i][j]+=min(grid[i][j-1],grid[i-1][j])
        
        return grid[row-1][col-1]
        