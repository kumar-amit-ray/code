/*
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
*/

int countSubstrings(char* s) {
    int count =0;
    
    if (s == NULL || strlen(s)==0) return 0;
    for (int i=0; i<strlen(s); i++) {
        checkpalidrome(s, i, i, &count);
        checkpalidrome(s, i, i+1, &count);
    }
    return count;
}

void checkpalidrome(char *s, int start, int end, int *count){
    while (start >=0 && end <strlen(s) && s[start]==s[end]) {
        start--;end++;(*count)++;
    }
}
