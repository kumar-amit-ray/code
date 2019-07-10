'''
Given a string containing digits from 2-9 inclusive, return all possible letter combinations that the number could represent.

A mapping of digit to letters (just like on the telephone buttons) is given below. Note that 1 does not map to any letters.

https://leetcode.com/problems/letter-combinations-of-a-phone-number/

Example:

Input: "23"
Output: ["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].
Note:

Although the above answer is in lexicographical order, your answer could be in any order you want.
'''

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
