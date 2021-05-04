/**
Given a string s, return the length of the longest substring that contains at most two distinct characters.

 

Example 1:

Input: s = "eceba"
Output: 3
Explanation: The substring is "ece" which its length is 3.
Example 2:

Input: s = "ccaabbb"
Output: 5
Explanation: The substring is "aabbb" which its length is 5.

@Leetcode - https://leetcode.com/problems/longest-substring-with-at-most-two-distinct-characters/
 */
class Solution {
    public int lengthOfLongestSubstringTwoDistinct(String s) {
        if (s.isEmpty()) {
            return 0;
        }
        int i = 0;
        Set<Character> seen = new HashSet();
        int result = 0;
        int subStringLen = 0;
        int startIndex = 0;
        while (i < s.length()) {
            seen.add(s.charAt(i));
            if (seen.size() == 3) {
                seen.clear();
                result = Math.max(result, subStringLen);
                subStringLen = 0;
                startIndex++;
                i = startIndex;
            } else {
                subStringLen++;
                i++;
            }
        }
        result = Math.max(result, subStringLen);
        return result;
    }
}
