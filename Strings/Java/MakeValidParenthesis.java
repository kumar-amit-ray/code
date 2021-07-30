/**
@Leetcode - https://leetcode.com/problems/minimum-remove-to-make-valid-parentheses/
@Algorithm:
    Each time a '(' is encountered put a * in sb and push the index i to stack
    Each time a ')' is encounterd
        if the stack is empty - it is not a valid ')', so put * in the sb.
        if the stack is not empty - we found one matching ')' for '(', so pop the stack and set the index with '('
        
    Now go through sb and remove all * from the it becaue these are the '(' that does not have a ')'
 */
class Solution {
    public String minRemoveToMakeValid(String s) {
        if (s == null || s.length() == 0) {
            return s;
        }
        StringBuilder sb = new StringBuilder();
        Stack<Integer> stack = new Stack();
        
        for (int i=0; i<s.length();i++) {
            if (s.charAt(i) == '(') {
                stack.push(i);
                sb.append('*');
            } else if (s.charAt(i) == ')') {
                if (!stack.isEmpty()) {
                    int index = stack.pop();
                    sb.setCharAt(index, s.charAt(index));
                    sb.append(s.charAt(i));
                } else {
                    sb.append('*');
                }
            } else {
                sb.append(s.charAt(i));
            }
        }
        StringBuilder result = new StringBuilder();
        for (int i=0; i<sb.length(); i++) {
            if (sb.charAt(i) != '*') {
                result.append(sb.charAt(i));
            }
        }
        return result.toString();
    }
}

public class MakeValidParenthesis {
    /**
     * Given a string s of '(' , ')' and lowercase English characters.
     *
     * Your task is to remove the minimum number of parentheses ( '(' or ')', in any positions ) so that the resulting parentheses string is valid and return any valid string.
     *
     * Formally, a parentheses string is valid if and only if:
     *
     * It is the empty string, contains only lowercase characters, or
     * It can be written as AB (A concatenated with B), where A and B are valid strings, or
     * It can be written as (A), where A is a valid string.
     *
     *
     * Example 1:
     *
     * Input: s = "lee(t(c)o)de)"
     * Output: "lee(t(c)o)de"
     * Explanation: "lee(t(co)de)" , "lee(t(c)ode)" would also be accepted.
     * Example 2:
     *
     * Input: s = "a)b(c)d"
     * Output: "ab(c)d"
     * Example 3:
     *
     * Input: s = "))(("
     * Output: ""
     * Explanation: An empty string is also valid.
     * Example 4:
     *
     * Input: s = "(a(b(c)d)"
     * Output: "a(b(c)d)"
     *
     * @Leetcode - https://leetcode.com/problems/minimum-remove-to-make-valid-parentheses/
     * @youtube - https://www.youtube.com/watch?v=thL70BR3yMA
     */
    public String minRemoveToMakeValid(String s) {
        if (s.isEmpty()) {return null;}

        int balance = 0;

        StringBuilder sb = new StringBuilder();
        for (char c: s.toCharArray()) {
            if (c == '(') {balance++;}
            else if (c == ')') {
                if (balance == 0) {continue;}
                balance--;
            }
            sb.append(c);
        }

        StringBuilder result = new StringBuilder();
        for (int i=sb.length()-1; i>=0; i--) {
            if (sb.charAt(i) == '(' && balance-- > 0) {
                continue;
            }
            result.append(sb.charAt(i));
        }
        return result.reverse().toString();
    }
}
