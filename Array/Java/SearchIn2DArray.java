/**
    @Leetcode - https://leetcode.com/problems/search-a-2d-matrix/
    
    Write an efficient algorithm that searches for a value in an m x n matrix. This matrix has the following properties:

    Integers in each row are sorted from left to right.
    The first integer of each row is greater than the last integer of the previous row.

    @Youtube - https://www.youtube.com/watch?v=FOa55B9Ikfg
 */
class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0) {
            return false;
        }
        int rows = matrix.length;
        int cols = matrix[0].length;
                          
        int left = 0;
        int right = (rows * cols) - 1;
        while (left <= right) {
            int mid = left + (right - left)/2;
            int elem = getElement(matrix, rows, cols, mid);
            if (target == elem) {
                return true;
            } else if (target > elem) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return false;
    }
    
    /*
      Take a single dimension index and convert it into 2D.
     */
    int getElement(int[][] matrix, int rows, int cols, int sindex) {
        int i = sindex / cols;
        int j = sindex % cols;
        
        return matrix[i][j];
    }
}


/**
@Leetcode - https://leetcode.com/problems/search-a-2d-matrix-ii/

Write an efficient algorithm that searches for a target value in an m x n integer matrix. The matrix has the following properties:

Integers in each row are sorted in ascending from left to right.
Integers in each column are sorted in ascending from top to bottom.

Runtime complexity = O(m+n) because the loop is a single traversal.
Space Complexity = O(1)
 */
class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0) {
            return false;
        }
        int i = 0, j = matrix[0].length - 1;
        
        while (i < matrix.length && j >= 0) {
            if (target == matrix[i][j]) {
                return true;
            } else if (target > matrix[i][j]) {
                i++;
            } else {
                j--;
            }
        }
        return false;
    }
}
