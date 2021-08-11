/**
You are given coins of different denominations and a total amount of money. Write a function to compute the number of combinations 
that make up that amount. You may assume that you have infinite number of each kind of coin.

 

Example 1:

Input: amount = 5, coins = [1, 2, 5]
Output: 4
Explanation: there are four ways to make up the amount:
5=5
5=2+2+1
5=2+1+1+1
5=1+1+1+1+1
Example 2:

Input: amount = 3, coins = [2]
Output: 0
Explanation: the amount of 3 cannot be made up just with coins of 2.
Example 3:

Input: amount = 10, coins = [10] 
Output: 1
@Leetcode - https://leetcode.com/problems/coin-change-2/
@Youtube - https://www.youtube.com/watch?v=DJ4a7cmjZY0
 */
class Solution {
    public int change(int amount, int[] coins) {
        // row = number of coins  + 1 for 0 coin
        // col = amount + 1 for 0 amount
        int[][] dp = new int[coins.length + 1][amount + 1];
        
        // ways to make amount 0 with coins [0..i].
        for (int i=0; i<dp.length; i++) {
            dp[i][0] = 1; 
        }
        // ways to make amount [1..amount] using coin 0
        for (int j=1; j<dp[0].length; j++) {
            dp[0][j] = 0; 
        }
        
        for (int i=1; i<dp.length; i++) {
            for (int j=1; j<dp[0].length; j++) {
                // if the coin value is less than the amount, we can't make the amount with that coin.
                // so copy the value from the cell with not using the coin.
                if (coins[i-1] > j) {
                    dp[i][j] = dp[i-1][j];
                } else {
                    dp[i][j] = dp[i-1][j] + dp[i][j - coins[i-1]];
                }
            }
        }
        
        return dp[coins.length][amount];
    }
}
