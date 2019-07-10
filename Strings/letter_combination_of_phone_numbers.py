class Solution(object):
    def letterCombinations(self, digits):
        """
        :type digits: str
        :rtype: List[str]
        """
        mapper = {
        '0':'',
        '1':'',
        '2': 'abc',
        '3': 'def',
        '4': 'ghi',
        '5': 'jkl',
        '6': 'mno',
        '7': 'pqrs',
        '8': 'tuv',
        '9': 'wxyz'
        }
        result = list()
        if digits is None or len(digits) == 0:
            return result
        self.generate_combination(result, list(digits), '', 0, mapper)
        return result
        
    def generate_combination(self, result, digits, combination, index, mapping):
        if index == len(digits):
            result.append(combination)
            return
        curr_str = list(mapping[digits[index]])
        i = 0
        while i<len(curr_str):
            self.generate_combination(result, digits, combination+curr_str[i], index+1, mapping)
            i = i+1
