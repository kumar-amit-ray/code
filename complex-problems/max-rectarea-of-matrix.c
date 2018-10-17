/*
Given a 2D binary matrix filled with 0's and 1's, find the largest rectangle containing only 1's and return its area.
Input:
[
  ["1","0","1","0","0"],
  ["1","0","1","1","1"],
  ["1","1","1","1","1"],
  ["1","0","0","1","0"]
]
Output: 6

https://www.youtube.com/watch?v=g8bSdXCG-lA
*/
int findMaxSquareAreaofMatrix1s(int matrix[4][5], int matrixRowSize, int matrixColSize)
{
		int i,j, min, maxarea=0;
		for (i=0; i<matrixRowSize; i++) {
			for (j=0; j<matrixColSize; j++) {
				if (i==0 || j==0) { continue;}
				if (matrix[i][j] > 0) {
					matrix[i][j] = 1+findMinof3(matrix[i-1][j], matrix[i-1][j-1], matrix[i][j-1]);
				}
				if (matrix[i][j] > maxarea) {maxarea = matrix[i][j];}
			}
		}
		return maxarea;
}

