/**
Given a string, your task is to count how many palindromic substrings in this string.

The substrings with different start indexes or end indexes are counted as different substrings even they consist of same characters.

Example 1:

Input: "abc"
Output: 3
Explanation: Three palindromic strings: "a", "b", "c".
 

Example 2:

Input: "aaa"
Output: 6
Explanation: Six palindromic strings: "a", "a", "a", "aa", "aa", "aaa".

@Leetcode - https://leetcode.com/problems/palindromic-substrings/
 */
class Solution {
    public int countSubstrings(String s) {
        int count = 0;
        
        if (s.isEmpty()) {
            return 0;
        }
        
        for (int i=0; i<s.length(); i++) {
            count += getPalindromicSubStringLength(s, i, i) + getPalindromicSubStringLength(s, i, i+1);    
        }
        return count;
    }
    
    private int getPalindromicSubStringLength(String s, int start, int end) {
        int count = 0;
        while (start >= 0 && end < s.length() && s.charAt(start) == s.charAt(end)) {
            start--;
            end++;
            count++;
        }
        return count;
    }
}
