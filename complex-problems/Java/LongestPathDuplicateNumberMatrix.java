/**
 * @Leetcode - https://leetcode.com/discuss/interview-question/392780/Doordash-or-Phone-Screen-or-Longest-path-duplicate-numbers-within-a-Matrix
 *
 */
public class LongestPathDuplicateNumberOfMatrix {
    int[][] dirs = new int[][]{{1,0}, {-1, 0}, {0, 1}, {0, -1}};

    public int longestIncreasingPath(int[][] matrix) {
        // basic sanity check
        if (matrix == null || matrix.length == 0) {
            return 0;
        }
        int maxCount = 0;
        int[][] mem = new int[matrix.length][matrix[0].length];
        boolean[][] visited = new boolean[matrix.length][matrix[0].length];
        for (boolean[] v : visited) {
            Arrays.fill(v, false);
        }

        for (int i=0; i<matrix.length; i++) {
            for (int j=0; j<matrix[i].length; j++) {
                 maxCount = Math.max(maxCount, dfs(matrix, i, j, mem, visited));
            }
        }

        // return
        return maxCount;
    }

    private int dfs(int[][] matrix, int i, int j, int[][] mem, boolean[][] visited) {
        if (mem[i][j] > 0 || visited[i][j]) {
            return mem[i][j];
        }
        visited[i][j] = true;

        int maxLen = 0;
        for (int[] dir : dirs) {
            int newX = i + dir[0];
            int newY = j + dir[1];

            if (newX >= 0 && newX < matrix.length && newY >= 0 && newY < matrix[i].length  && matrix[newX][newY] == matrix[i][j]) {
                maxLen = Math.max(maxLen, dfs(matrix, newX, newY, mem, visited));
            }
        }
        mem[i][j] = maxLen + 1;
        return maxLen+1;
    }

    public static void main(String[] args) {
        int[][] input = new int[][]{{1, 1, 5},{5, 5, 5},{5, 5, 5}, {5, 5, 5}};
        System.out.println(new LongestPathDuplicateNumberOfMatrix().longestIncreasingPath(input));
    }
}
