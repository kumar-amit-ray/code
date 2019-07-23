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
class Solution(object):
    def __init__(self):
        self.h = Histogram()

    def maximalRectangle(self, matrix):
        """
        :type matrix: List[List[str]]
        :rtype: int
        """
        if matrix is None or len(matrix) == 0:
            return 0
        i = 0
        j = 0
        heights = [0] * len(matrix[0])
        maxarea = 0
        while i<len(matrix):
            j =0
            while j<len(matrix[0]):
                if i==0: heights[j] = int(matrix[i][j])
                else:
                    if matrix[i][j] == '0':
                        heights[j] = 0
                    else:
                        heights[j] += int(matrix[i][j])
                j +=1
            maxarea = max(maxarea, self.h.largestRectangleArea(heights))
            i +=1

        return maxarea
