answer=0

def dfs(numbers,target,current_sum,index,num):
    global answer
    
    if index<len(numbers):
        current_sum=current_sum+numbers[index]*num
        
    if index==len(numbers)-1:
        if current_sum==target:
            answer+=1
        return 
    
    dfs(numbers,target,current_sum,index+1,1)
    dfs(numbers,target,current_sum,index+1,-1)
    
        
def solution(numbers, target):
    dfs(numbers,target,0,0,1)
    dfs(numbers,target,0,0,-1)
    
    return answer


    