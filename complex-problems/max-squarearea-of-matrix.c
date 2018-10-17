/*
https://www.youtube.com/watch?v=FO7VXDfS8Gk
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
