/**
@Leetcode - https://leetcode.com/problems/longest-increasing-path-in-a-matrix/
@Youtube - https://www.youtube.com/watch?v=WiEqhI7v2FY
 */
class Solution {
    int[][] dirs = new int[][]{{1,0}, {-1, 0}, {0, 1}, {0, -1}};

    public int longestIncreasingPath(int[][] matrix) {
        // basic sanity check
        if (matrix == null || matrix.length == 0) {
            return 0;
        }
        int maxCount = 0;
        int[][] mem = new int[matrix.length][matrix[0].length];

        for (int i=0; i<matrix.length; i++) {
            for (int j=0; j<matrix[i].length; j++) {
                 maxCount = Math.max(maxCount, dfs(matrix, i, j, mem));
            }
        }

        // return
        return maxCount;
    }

    private int dfs(int[][] matrix, int i, int j, int[][] mem) {
        if (mem[i][j] > 0) {
            return mem[i][j];
        }
        int maxLen = 0;
        for (int[] dir : dirs) {
            int newX = i + dir[0];
            int newY = j + dir[1];

            if (newX >= 0 && newX < matrix.length && newY >= 0 && newY < matrix[i].length  && matrix[newX][newY] > matrix[i][j]) {
                maxLen = Math.max(maxLen, dfs(matrix, newX, newY, mem));
            }
        }
        mem[i][j] = maxLen + 1;
        return maxLen+1;
    }
}
