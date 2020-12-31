/**
Given an input string , reverse the string word by word. 
Example:
Input:  ["t","h","e"," ","s","k","y"," ","i","s"," ","b","l","u","e"]
Output: ["b","l","u","e"," ","i","s"," ","s","k","y"," ","t","h","e"]
Note: 
	• A word is defined as a sequence of non-space characters.
	• The input string does not contain leading or trailing spaces.
	• The words are always separated by a single space.
Follow up: Could you do it in-place without allocating extra space?

@Leetcode - https://leetcode.com/problems/reverse-words-in-a-string-ii/submissions/
 */


class Solution {
    public void reverseWords(char[] s) {
        //reverse the whole string
        reverseAtIndex(s, 0, s.length-1);
        
        // now reverse each word
        int start=0;
        int index=0;
        while(index < s.length) {
            if (s[index] == ' ') {
                reverseAtIndex(s, start, index-1);
                start = index+1;
            }
            index++;
        }
        // reverse the last word
        reverseAtIndex(s, start, index-1);
    }
    
    private void reverseAtIndex(char[] s, int start, int end) {
        while (start <= end) {
            char temp = s[start];
            s[start] = s[end];
            s[end] = temp;
            start++;
            end--;
        }
    }
}
