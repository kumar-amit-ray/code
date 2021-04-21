/**
You are given an integer array coins representing coins of different denominations and an integer amount representing a total amount of money.

Return the fewest number of coins that you need to make up that amount. If that amount of money cannot be made up by any combination of the coins, return -1.

You may assume that you have an infinite number of each kind of coin.

 

Example 1:

Input: coins = [1,2,5], amount = 11
Output: 3
Explanation: 11 = 5 + 5 + 1
Example 2:

Input: coins = [2], amount = 3
Output: -1
Example 3:

Input: coins = [1], amount = 0
Output: 0
Example 4:

Input: coins = [1], amount = 1
Output: 1
Example 5:

Input: coins = [1], amount = 2
Output: 2

@Leetcode - https://leetcode.com/problems/coin-change/
@Youtube - https://www.youtube.com/watch?v=jgiZlGzXMBw
 */
class Solution {
    public int coinChange(int[] coins, int amount) {
        if (coins.length == 0 || amount == 0) {
            return 0;
        }
        int[] dp = new int[amount+1];
        dp[0] = 0;
        for (int i=1; i<dp.length; i++) {
            // don't use Integer.MAX_VALUE as 1+Integer.MAX_VALUE will go negetive
            dp[i] = amount+1;
        }
        for (int i=1; i<dp.length; i++) {
            for (int j=0; j<coins.length; j++) {
                if (coins[j] > i) {
                    continue;
                }
                dp[i] = Math.min(dp[i], 1 + dp[i - coins[j]]);
            }
        }
        return dp[amount] > amount ? -1 : dp[amount];                                 
    }
}
