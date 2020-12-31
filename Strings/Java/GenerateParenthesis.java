/**
Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses.

 

Example 1:

Input: n = 3
Output: ["((()))","(()())","(())()","()(())","()()()"]
Example 2:

Input: n = 1
Output: ["()"]
 

Constraints:

1 <= n <= 8

@Leetcode - https://leetcode.com/problems/generate-parentheses/
*/

class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        if (n == 0) { return result;}
        
        generateParenthesisRecursive(0, 0, n, "", result);
        return result;
        
    }
    
    private void generateParenthesisRecursive(int op, int ep, int n, String curr, List<String> result) {
        if (op == n && ep == n) {
            result.add(curr);
        } else if (op == ep) {
            generateParenthesisRecursive(op+1, ep, n, curr+"(", result);
        } else if (op == n) {
            generateParenthesisRecursive(op, ep+1, n, curr+")", result);
        } else {
            generateParenthesisRecursive(op+1, ep, n, curr+"(", result);
            generateParenthesisRecursive(op, ep+1, n, curr+")", result);
        }
    }  
}
