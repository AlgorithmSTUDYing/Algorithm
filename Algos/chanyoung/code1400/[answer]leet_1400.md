# 1400. Construct K Palindrome Strings

input

> s = "annabelle", k = 2

output

> true

explanation

- You can construct two palindromes using all characters in s.
Some possible constructions "anna" + "elble", "anbna" + "elle", "anellena" + "b"

<hr>

## Answer Code

```js
var canConstruct = function(s, k) {
    // 예외 처리
    if(s.length === k) return true;
    if(s.length < k) return false;
    
    // 알파벳의 수(26) 만큼 Array.fill -> 0
    let charArr = new Array(26).fill(0);
    
    // s의 모든 알파벳 수를 세어, charArr[] 안에 알파벳의 수 ++
    for(c of s){
        let charNum = c.charCodeAt(c)
        
        charArr[charNum-97]++;
    }

    // charArr -> filter Odd Num -> length
    // 홀수의 Alphabet들만 구하는 이유는, 홀수인 이들은 대칭이 되지 않고 k개보다 적어야 palindrome 하기 떄문.
    // (짝수로 구성된 Alphabet 들은 서로 palindrome 되기 떄문에 없어도 됨.)
    let odds = charArr.filter(char => char % 2).length

    // 결론 : 대칭이 되지 않는 Odd Alphabet들은 k 개 보다 적다면, palindrome 하지 않음 => return false
    return odds <= k
};
};
```

<hr/>

## Test Result

<img src="./testResult.png">
