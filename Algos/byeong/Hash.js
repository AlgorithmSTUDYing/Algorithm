function solution(baseball) {
    let answer = 0;
    
    /**
     * 1. 각자리수가 다른 모든 경우의 수를 만들어준다.
     *      - [123] ~ [987]까지
     * 2. 모든 경우의 수 배열을 순회하면서 baseball의 case에 만족하는지 확인한다.
     */

    // 1. 각자리수가 다른 모든 경우의 수를 만들어준다.
    let allCase = [];
    for (let i = 1; i <= 9; i++)
    {
        for (let j = 1; j <= 9; j++)
        {
            if (i === j) 
                continue;

            for (let k = 1; k <= 9; k++)
            {
                if (j === k || i === k) 
                    continue;

                allCase.push(""+i+j+k);
            }
        }
    }

    // 2. 모든 경우의 수 배열을 순회하면서 baseball의 case에 만족하는지 확인한다.
    for (let i = 0; i < allCase.length; i++)
    {
        let flag = true;

        for (let j = 0; j < baseball.length; j++)
        {
            let str = baseball[j][0].toString();
            let strike = 0;
            let ball = 0;
            
            // 스트라이크 & 볼 갯수 확인
            for (let k = 0; k < str.length; k++)
            {
                if (str[k] === allCase[i][k])
                    strike++;
                else
                {
                    if (str.indexOf(allCase[i][k]) !== -1)
                        ball++;
                }
            }

            if (strike === baseball[j][1] && ball === baseball[j][2])
                continue;
            else
            {
                flag = false;
                break;
            }
        }

        if (flag)
            answer++;
    }

    return answer;
}

console.log(solution([[123, 1, 1], [356, 1, 0], [327, 2, 0], [489, 0, 1]])); // 2
 
