/**
https://leetcode.com/problems/number-of-islands-ii/

 */
class Solution {
    public List<Integer> numIslands2(int m, int n, int[][] positions) {
        List<Integer> result = new ArrayList<>();
        
        if (m == 0 || n == 0 || positions.length == 0) {
            return result;
        }
        int[][] grid = new int[m][n];
        for (int[] row: grid) {
            Arrays.fill(row, 0);
        }
        for (int i=0; i<positions.length; i++) {
            grid[positions[i][0]][positions[i][1]] = 1;
            result.add(numIslands(grid));
        }
        return result;
    }
    
    private int numIslands(int[][] grid) {
        if (grid == null || grid.length == 0) {
            return 0;
        }
        int numsIsland = 0;
        
        boolean[][] visited = new boolean[grid.length][grid[0].length];
        for (boolean[] row: visited) {
            Arrays.fill(row, false);
        }
        for (int i=0;i<grid.length; i++) {
            for (int j=0; j<grid[i].length; j++) {
                if (grid[i][j] == 1 && !visited[i][j]) {
                    numsIsland++;
                    markCells(grid, i, j, visited);
                }
            }
        }
        return numsIsland;
    }
    
    private void markCells(int[][] grid, int i, int j, boolean[][] visited) {
        if (i >= grid.length || i < 0 || j >= grid[i].length || j < 0 || visited[i][j]) {
            return;
        }
        if (grid[i][j] == 1) {
            // mark it as visited
            visited[i][j] = true;
            markCells(grid, i+1, j, visited);
            markCells(grid, i-1, j, visited);
            markCells(grid, i, j+1, visited);
            markCells(grid, i, j-1, visited);
        }
    }
}
