import numpy as np
class Solution:
    def minDistance(self, word1: str, word2: str) -> int:
        length1=len(word1)
        length2=len(word2)
        dp=np.zeros((len(word1)+1,len(word2)+1))
        
        
        for i in range(0,length1+1):
            for j in range(0,length2+1):
                
                if i==0:
                    dp[i][j]=j
                elif j==0:
                    dp[i][j]=i
                    
                elif word1[i-1]==word2[j-1]:
                    dp[i][j]=dp[i-1][j-1]
                
                else:
                    dp[i][j]=min(min(dp[i-1][j],dp[i][j-1]),dp[i-1][j-1])+1
                    
        
      
        return int(dp[-1][-1])
    

