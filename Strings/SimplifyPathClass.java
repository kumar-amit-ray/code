public class SimplifyPathClass {
    /**
     * Given an absolute path for a file (Unix-style), simplify it. Or in other words, convert it to the canonical path.
     *
     * In a UNIX-style file system, a period '.' refers to the current directory. Furthermore, a double period '..' moves the directory up a level.
     *
     * Note that the returned canonical path must always begin with a slash '/', and there must be only a single slash '/' between two directory names. The last directory name (if it exists) must not end with a trailing '/'. Also, the canonical path must be the shortest string representing the absolute path.
     *
     *
     *
     * Example 1:
     *
     * Input: path = "/home/"
     * Output: "/home"
     * Explanation: Note that there is no trailing slash after the last directory name.
     * Example 2:
     *
     * Input: path = "/../"
     * Output: "/"
     * Explanation: Going one level up from the root directory is a no-op, as the root level is the highest level you can go.
     * Example 3:
     *
     * Input: path = "/home//foo/"
     * Output: "/home/foo"
     * Explanation: In the canonical path, multiple consecutive slashes are replaced by a single one.
     * Example 4:
     *
     * Input: path = "/a/./b/../../c/"
     * Output: "/c"
     *
     *
     * Constraints:
     *
     * 1 <= path.length <= 3000
     * path consists of English letters, digits, period '.', slash '/' or '_'.
     * path is a valid Unix path.
     *
     * @Leetcode - https://leetcode.com/problems/simplify-path/
     */
    public String simplifyPath(String path) {
        if (path == null || path.isEmpty()) {
            return null;
        }
        Stack<String> stack = new Stack<>();
        for (String curr: path.split("/")) {
            if (curr.equals(".."))  {
                if (!stack.empty()) {
                    stack.pop();
                }
            } else if (!curr.equals(".") && !curr.isEmpty()) {
                stack.push(curr);
            }
        }
        StringBuilder result = new StringBuilder();
        // in Java for loop, you can iterate the stack in the other way
        for (String item: stack) {
            result.append("/");
            result.append(item);
        }
        return result.length() > 0? result.toString() : "/";
    }
}
