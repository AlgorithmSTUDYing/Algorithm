def solution(triangle):
    '''
    DP문제
    '''
    for i in range(1,len(triangle)):
        length=len(triangle[i])
        for j in range(0,length):
            if j==0:#맨 왼쪽일 경우
                triangle[i][j]=triangle[i-1][j]+triangle[i][j]
                
            elif j==length-1:#맨 오른쪽일 경우
                triangle[i][j]=triangle[i][j]+triangle[i-1][j-1]
                
            else:#낀 값일 경우
                triangle[i][j]=triangle[i][j]+max(triangle[i-1][j-1],triangle[i-1][j])
                
    return max(triangle[len(triangle)-1])   #triangle[-1]로 표현도 가
           
                
