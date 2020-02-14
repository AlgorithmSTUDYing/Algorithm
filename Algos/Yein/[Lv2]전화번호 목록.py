
def solution(clothes):
    answer = 'true'
    length=len(clothes)
    
    for i in range (0,length):
        if(answer=='false'):
            break
        for j in range (0,length):
            if i!=j and len(clothes[i])<=len(clothes[j]):
                if clothes[i]==clothes[j][:len(clothes[i])]:
                    answer='false'
                    break;
    return answer

print(solution(['123', '456', '789']))