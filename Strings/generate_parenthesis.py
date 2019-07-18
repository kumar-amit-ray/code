'''
Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses.

For example, given n = 3, a solution set is:

[
  "((()))",
  "(()())",
  "(())()",
  "()(())",
  "()()()"
]
Leetcode- https://leetcode.com/problems/generate-parentheses/
Youtube-https://www.youtube.com/watch?v=dhqdjOdOXtk
'''

class Solution(object):
    def generateParenthesis(self, n):
        """
        :type n: int
        :rtype: List[str]
        """
        result = list()
        if n==0: return result
        self.generate_parenthesis_helper(n, '', 0, 0, result)
        return result
    
    def generate_parenthesis_helper(self, n, cstr, op, ep, result):
        if op==n and ep==n:
            # if we have utilized all the openning and closing paranthesis, we have one result
            result.append(''.join(cstr))
            return
        elif op==n:
            # if we utilized all the openning paranthesis, we can put only closing one
            self.generate_parenthesis_helper(n, cstr+')', op, ep+1, result)
        elif op==ep:
            # if we have equal openning and closing paranthesis, we can put only opening one
            self.generate_parenthesis_helper(n, cstr+'(', op+1, ep, result)
        else:
            # else we put one opening and generate combination and then one closing and generate combination
            self.generate_parenthesis_helper(n, cstr+')', op, ep + 1, result)
            self.generate_parenthesis_helper(n, cstr+'(', op + 1, ep, result)
