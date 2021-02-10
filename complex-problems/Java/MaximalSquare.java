/**
Input: matrix = [["1","0","1","0","0"],["1","0","1","1","1"],["1","1","1","1","1"],["1","0","0","1","0"]]
Output: 4

Input: matrix = [["0","1"],["1","0"]]
Output: 1

Input: matrix = [["0"]]
Output: 0

@Leetcode - https://leetcode.com/problems/maximal-square/
@Youtube - https://www.youtube.com/watch?v=FO7VXDfS8Gk
*/
class Solution {
    public int maximalSquare(char[][] matrix) {
        if (matrix == null || matrix.length == 0) {
            return 0;
        }
        int[][] result = new int[matrix.length][matrix[0].length];
        int ans = 0;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                result[i][j] = Character.getNumericValue(matrix[i][j]);
            }
        }
        
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (i != 0 && j != 0 && result[i][j] > 0) {
                    result[i][j] += Math.min(result[i][j-1], Math.min(result[i-1][j], result[i-1][j-1]));
                }
                ans = Math.max(ans, result[i][j]);
            }
        }
        return ans * ans;
    }
}
