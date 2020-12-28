public class ParenthesisValidator {
    /**
     *
     * Given a string s containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.
     *
     * An input string is valid if:
     *
     * Open brackets must be closed by the same type of brackets.
     * Open brackets must be closed in the correct order.
     *
     *
     * Example 1:
     *
     * Input: s = "()"
     * Output: true
     * Example 2:
     *
     * Input: s = "()[]{}"
     * Output: true
     * Example 3:
     *
     * Input: s = "(]"
     * Output: false
     * Example 4:
     *
     * Input: s = "([)]"
     * Output: false
     * Example 5:
     *
     * Input: s = "{[]}"
     * Output: true
     *
     * @Leetcode - https://leetcode.com/problems/valid-parentheses/
     */
    private HashMap<Character, Character> pmap = new HashMap<>();

    public ParenthesisValidator() {
        pmap.put('}', '{');
        pmap.put(']', '[');
        pmap.put(')', '(');
    }

    public boolean isValid(String s) {
        if (s.isEmpty()) {return true;}

        Stack<Character> st = new Stack<>();
        for(int i=0; i<s.length(); i++) {
            if (pmap.containsKey(s.charAt(i))) {
                if (st.isEmpty() || st.pop() != pmap.get(s.charAt(i))) {
                    return false;
                }
            } else {
                st.push(s.charAt(i));
            }
        }
        return st.isEmpty();
    }
}
