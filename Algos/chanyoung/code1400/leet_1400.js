/**
 * @param {string} s
 * @param {number} k
 * @return {boolean}
 */
 var canConstruct = function(s, k) {
    if(s.length === k) return true;
    if(s.length < k) return false;
    
    
    let charArr = new Array(26).fill(0);
    
    for(c of s){
        let charNum = c.charCodeAt(c)
        
        charArr[charNum-97]++;
    }
    
    let odds = charArr.filter(char => char % 2).length
    
    return odds <= k
};

 
let s = "annabelle", k = 2

console.log(canConstruct(s,k))