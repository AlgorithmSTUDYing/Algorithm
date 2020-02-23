def solution(numbers):
    answer = ''
    numbers=[str(s) for s in numbers]   #numbers의 정수를 문자열로 변환
    numbers.sort(reverse=True,key=lambda x: x*3)    #1000이하라는 조건때문에 *3만 해주면됨
    '''
    만약 numbers=[3,30,34,5,9]
    x*2를 한 것을 비교하면 (문자열이라는 것에 유의!!)
    '333' '303030' '343434' '555' '999'    
    이것을 내림차순으로 정렬하게 되면 
    '9' '5' '34' '3' '30'
    '''
    
    for num in numbers:
        answer=answer+num
    
    print(answer)
    return answer


solution([3, 30, 34, 5, 9])