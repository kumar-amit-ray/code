/**
Given a string s, find the longest palindromic subsequence's length in s.

A subsequence is a sequence that can be derived from another sequence by deleting some or no elements without changing the order of the remaining elements.

 

Example 1:

Input: s = "bbbab"
Output: 4
Explanation: One possible longest palindromic subsequence is "bbbb".
Example 2:

Input: s = "cbbd"
Output: 2
Explanation: One possible longest palindromic subsequence is "bb".

@Youtube - https://www.youtube.com/watch?v=_nCsPn7_OgI
@Youtube - https://www.youtube.com/watch?v=iw-UVkxqHiA
@Leetcode - https://leetcode.com/problems/longest-palindromic-subsequence/
 */
class Solution {
    public int longestPalindromeSubseq(String s) { 
        if (s.isEmpty()) {
            return 0;
        }
        int[][] dp = new int[s.length()][s.length()];
        
        // all charactor by itself is a palindrome of size 1.
        for (int i=0; i<dp.length; i++) {
            dp[i][i] = 1;
        }
        
        // set all un-used cell to 0, so that we don't need to handle a special case of length = 2
        for (int i=0; i<dp.length; i++) {
            for (int j=0; j<i; j++) {
                dp[i][j] = 0;
            }
        }
        
        // we already processed length 1. so start from 2.
        for (int l=2; l<=s.length(); l++) {
            for (int i=0; i<=s.length()-l; i++) {
                int j = i+l-1;
                if (s.charAt(i) == s.charAt(j)) {
                    dp[i][j] = 2 + dp[i+1][j-1];
                } else {
                    dp[i][j] = Math.max(dp[i+1][j], dp[i][j-1]);
                }
            }
        }
        return dp[0][s.length()-1];
    }
}
