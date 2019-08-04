 '''
 You are given coins of different denominations and a total amount of money. Write a function to compute 
 the number of combinations that make up that amount. You may assume that you have infinite number of each kind of coin.

 

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
 '''
 '''
    https://www.youtube.com/watch?v=PafJOaMzstY
    '''
    def change(self, amount, coins):
        """
        :type amount: int
        :type coins: List[int]
        :rtype: int
        """
        dp = numpy.zeros((len(coins) + 1, amount + 1))
        dp[0][0] = 1

        i = 1
        while i < amount + 1:
            dp[0][i] = 0
            i += 1

        i = 1
        try:
            while i < len(coins) + 1:
                j = 0
                while j < amount + 1:
                    if j >= coins[i - 1]:
                        dp[i][j] = dp[i - 1][j] + dp[i][j - coins[i-1]]
                    else:
                        dp[i][j] = dp[i - 1][j]
                    j += 1
                i += 1
        except Exception as e:
            print i,j

        print dp
        return int(dp[len(coins)][amount])
        
'''
You are given coins of different denominations and a total amount of money amount. Write a function to compute 
the fewest number of coins that you need to make up that amount. If that amount of money cannot be made up by any 
combination of the coins, return -1.

Example 1:

Input: coins = [1, 2, 5], amount = 11
Output: 3 
Explanation: 11 = 5 + 5 + 1
Example 2:

Input: coins = [2], amount = 3
Output: -1

Leetcode - https://leetcode.com/problems/coin-change/
youtube- https://www.youtube.com/watch?v=F28xN-S1SmI
'''
   def coinChange(self, coins, amount):
        """
        :type coins: List[int]
        :type amount: int
        :rtype: int
        """
        dp = numpy.zeros(amount+1)
        dp[0] = 0
        i = 1
        while i < amount+1:
            dp[i] = float('inf')
            i +=1

        i = 1
        while i<amount+1:
            j =0
            while j<len(coins):
                if i >= coins[j]:
                    dp[i] = min(dp[i], 1+dp[i-coins[j]])
                j +=1
            i +=1

        if dp[amount] > amount: return -1
        else: return int(dp[amount])
