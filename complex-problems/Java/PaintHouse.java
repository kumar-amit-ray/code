/**
 * There are a row of n houses, each house can be painted with one of the k colors. The cost of painting each house with a certain color is different. 
 * You have to paint all the houses such that no two adjacent houses have the same color.
 *
 * The cost of painting each house with a certain color is represented by a n x k cost matrix. For example, costs[0][0] is the cost of painting 
 * house 0 with color 0; costs[1][2] is the cost of painting house 1 with color 2, and so on... Find the minimum cost to paint all houses.
 *
 * Note:
 * All costs are positive integers.
 *
 * Example:
 *
 * Input: [[1,5,3],[2,9,4]]
 * Output: 5
 * Explanation: Paint house 0 into color 0, paint house 1 into color 2. Minimum cost: 1 + 4 = 5;
 *              Or paint house 0 into color 2, paint house 1 into color 0. Minimum cost: 3 + 2 = 5.
 * Follow up:
 * Could you solve it in O(nk) runtime?
 *
 * @Leetcode - https://leetcode.com/problems/paint-house-ii/
 */
public class PaintHouse {
    int curMin1;
    int curMin2;

    public static void main(String[] args) {
        int[][] costs = new int[][]{{20,19,11,13,12,16,16,17,15,9,5,18},{3,8,15,17,19,8,18,3,11,6,7,12},{15,4,11,1,18,2,10,9,3,6,4,15}};
        System.out.println(new PaintHouse().minCostII(costs));
    }
    public int minCostII(int[][] costs) {
        int minCost = 0;
        int prevMin1 = 0, prevMin2 = 0;

        for (int i=0; i<costs.length; i++) {
            curMin1 = -1;
            curMin2 = -1;
            for (int j=0; j<costs[0].length; j++) {
                if (i != 0) {
                    costs[i][j] += (j == prevMin1) ? costs[i-1][prevMin2]: costs[i-1][prevMin1];
                }
                recordCurrentMins(costs, i, j);
            }
            prevMin1 = curMin1;
            prevMin2 = curMin2;
        }

        return costs[costs.length-1][curMin1];
    }

    private void recordCurrentMins(int[][] costs, int i, int j) {
        if (curMin1 < 0) {
            curMin1 = j;
        } else if (curMin2 < 0) {
            if (costs[i][j] < costs[i][curMin1]) {
                curMin2 = curMin1;
                curMin1 = j;
            } else {
                curMin2 = j;
            }
        } else if (costs[i][j] < costs[i][curMin1]) {
            curMin2 = curMin1;
            curMin1 = j;
        } else if (costs[i][j] < costs[i][curMin2]) {
            curMin2 = j;
        }
    }
}
