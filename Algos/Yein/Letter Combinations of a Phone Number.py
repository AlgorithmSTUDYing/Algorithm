class Solution:
    def letterCombinations(self, digits: str) -> List[str]:
        
        words = {
          '2': list('abc'),
          '3': list('def'),
          '4': list('ghi'),
          '5': list('jkl'),
          '6': list('mno'),
          '7': list('pqrs'),
          '8': list('tuv'),
          '9': list('wxyz')
        }
        
        if len(digits)==0:
            return []
        
        if len(digits) == 1:
            return words[digits]
        
        
        
        arr = []
		
        for letter in words[digits[0]]:		#d,e,f	
            for rest_combination in self.letterCombinations(digits[1:]):
                arr.append(letter+rest_combination)

        return arr
    
    