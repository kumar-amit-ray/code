/**
Given a string s, find the length of the longest substring without repeating characters.

 

Example 1:

Input: s = "abcabcbb"
Output: 3
Explanation: The answer is "abc", with the length of 3.
Example 2:

Input: s = "bbbbb"
Output: 1
Explanation: The answer is "b", with the length of 1.
Example 3:

Input: s = "pwwkew"
Output: 3
Explanation: The answer is "wke", with the length of 3.
Notice that the answer must be a substring, "pwke" is a subsequence and not a substring.
Example 4:

Input: s = ""
Output: 0

@Leetcode - https://leetcode.com/explore/featured/card/google/59/array-and-strings/3047/
 */
class Solution {
    public int lengthOfLongestSubstring(String s) {
        if (s.isEmpty()) {
            return 0;
        }
        Map<Character, Integer> cache = new HashMap();
        int result = 0;
        int curSubStrLen = 0;
        int curIndex = 0;
         while (curIndex < s.length()) {
            if (!cache.containsKey(s.charAt(curIndex))) {
                cache.put(s.charAt(curIndex), curIndex);
                curIndex++;
                curSubStrLen++;
            } else {
                result = Math.max(result, curSubStrLen);
                curSubStrLen = 0;
                curIndex = cache.get(s.charAt(curIndex)) + 1;
                cache.clear();
            }
        }
        result = Math.max(result, curSubStrLen);
        return result;
    }
}
