/*
There are a row of n houses, each house can be painted with one of the k colors. The cost of 
painting each house with a certain color is different. You have to paint all the houses such that 
no two adjacent houses have the same color.

The cost of painting each house with a certain color is represented by a n x k cost matrix. For example, costs[0][0] is the cost of painting house 0 with color 0; costs[1][2] is the cost of painting house 1 with color 2, and so on... Find the minimum cost to paint all houses.
Note:
All costs are positive integers.
Example:
Input: [[1,5,3],[2,9,4]]
Output: 5
Explanation: Paint house 0 into color 0, paint house 1 into color 2. Minimum cost: 1 + 4 = 5; 
             Or paint house 0 into color 2, paint house 1 into color 0. Minimum cost: 3 + 2 = 5. 
*/

#define MAX_ROW 4
#define MAX_COL 3

int cost[MAX_ROW][MAX_COL] = {{5,3,2},
                              {1,8,4},
                              {2,9,6},
                              {8,3,1}};

/* Algorithm -
            1. Copy the 1st as is. Keep two variable to calculate two most less cost for each row.
            2. Also keep two variable to remember the 2 lowest cost for previous row.
            2. Now starting row 1, calculate the cost for each col as follows:
                a. if the j is same as minCostIndex, we can't use it bcos two neighbor can't have same color, so use minCost2Index.
                b. else use minCostIndex.
            3. Repeat step 2 for each row. Min cost of last row will be the total min cost to paint all houses.
*/

void getMinCostIndex(int row, int col, int *minCost, int *minCost2)
{
    if (*minCost < 0) {
        *minCost = col;
    } else if (*minCost2 < 0) {
        *minCost2 = col;
    }

    if (cost[row][col] < cost[row][*minCost]) {
        *minCost2 = *minCost;
        *minCost = col;
    } else if (cost[row][col] < cost[row][*minCost2]) {
        *minCost2 = col;
    }
}
void printCost()
{
   int i,j;

   printf("\n");

   for (i=0;i<MAX_ROW;i++) {
       for (j=0; j<MAX_COL;j++) {
           printf("%d  ", cost[i][j]);
       }
       printf("\n");
   }
}
int solvePaintHouse()
{
    int i,j;
    int  minCostIndex=0, minCost2Index=0;
    int prevMinCost=0, prevMinCost2=0;

    for (i=0; i<MAX_ROW; i++) {
        minCostIndex=-1; minCost2Index=-1;
        for (j=0; j<MAX_COL; j++) {
            if (i !=0) {
                cost[i][j] += (prevMinCost == j)?cost[i-1][prevMinCost2]:cost[i-1][prevMinCost];
            }
            getMinCostIndex(i, j, &minCostIndex, &minCost2Index);

        }
        prevMinCost = minCostIndex;
        prevMinCost2 = minCost2Index;
	printf("\nPrev:%d, Prev2:%d", prevMinCost, prevMinCost2);
	printCost();
    }
    return cost[MAX_ROW-1][minCostIndex];
}
