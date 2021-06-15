/**
@Leetcode - https://leetcode.com/problems/max-area-of-island/
 */
class Solution {
    public int maxAreaOfIsland(int[][] grid) {
        if (grid == null || grid.length == 0) {
            return 0;
        }
        boolean[][] visited = new boolean[grid.length][grid[0].length];
        for (int i=0; i<grid.length; i++) {
            for (int j=0 ; j<grid[i].length; j++)
            visited[i][j] = false;
        }
        int maxArea = 0;
        for (int i=0; i<grid.length; i++) {
            for (int j=0; j<grid[i].length; j++) {
                maxArea = Math.max(maxArea, area(grid, i, j, visited));
            }
        }
        return maxArea;
    }
    
    private int area(int[][] grid, int i, int j, boolean[][] visited) {
        if (i < 0 || i >= grid.length || j < 0 || j >= grid[i].length || grid[i][j] == 0 || visited[i][j]) {
            return 0;
        }
        visited[i][j] = true;
        return (1 + area(grid, i+1, j, visited) + area(grid, i-1, j, visited) + area(grid, i, j+1, visited) + area(grid, i, j-1, visited));
    }
}
