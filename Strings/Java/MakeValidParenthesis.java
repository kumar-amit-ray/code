
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
