/**
 Given a rows x cols binary matrix filled with 0's and 1's, find the largest rectangle containing only 1's and return its area.

 Example 1:
 Input: matrix = [["1","0","1","0","0"],["1","0","1","1","1"],["1","1","1","1","1"],["1","0","0","1","0"]]
 Output: 6
 Explanation: The maximal rectangle is shown in the above picture.

 Example 2:

 Input: matrix = []
 Output: 0
 Example 3:

 Input: matrix = [["0"]]
 Output: 0
 Example 4:

 Input: matrix = [["1"]]
 Output: 1
 Example 5:

 Input: matrix = [["0","0"]]
 Output: 0

 @Leetcode - https://leetcode.com/problems/maximal-rectangle/
 @Youtube - https://www.youtube.com/watch?v=g8bSdXCG-lA
 */

class Solution {
    public int maximalRectangle(char[][] matrix) {
        if (matrix == null || matrix.length == 0) {
            return 0;
        }
        int result = 0;
        int[] hist = new int[matrix[0].length];

        Arrays.fill(hist, 0);

        for (int i=0; i < matrix.length; i++) {
            for (int j=0; j < matrix[0].length; j++) {
                if (matrix[i][j] == '0') {
                    hist[j] = 0;
                } else {
                    hist[j] += Character.getNumericValue(matrix[i][j]);
                }
            }
            result = Math.max(result, largestRectangleArea(hist));
        }
        return result;
    }

    /**
     Max Area of a histogram
     */
    public int largestRectangleArea(int[] hist) {
        if (hist == null || hist.length == 0) {return 0;}

        int i = 0;
        int result = Integer.MIN_VALUE;
        Stack<Integer> stack = new Stack();
        while(i<hist.length) {
            if (stack.isEmpty() || hist[i] >= hist[stack.peek()]) {
                stack.push(i++);
            } else {
                int elem = stack.pop();
                int area = hist[elem] * (stack.isEmpty() ? i : (i - stack.peek() - 1));
                result = Math.max(result, area);
            }
        }
        while(!stack.isEmpty()) {
            int elem = stack.pop();
            int area = hist[elem] * (stack.isEmpty() ? i : (i - stack.peek() - 1));
            result = Math.max(result, area);
        }
        return result;
    }
}
