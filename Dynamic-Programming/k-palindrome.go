/*
Given a string, find out if the string is K-Palindrome or not. A K-palindrome string transforms into a palindrome on removing at most k characters from it.

Examples:

Input : String - abcdecba, k = 1
Output : Yes
String can become palindrome by removing
1 character i.e. either d or e

Input  : String - abcdeca, K = 2
Output : Yes
Can become palindrome by removing
2 characters b and e (or b and d).

Input : String - acdcb, K = 1
Output : No
String can not become palindrome by
removing only one character.
*/

Find the longest palindromic subsequence and check if the strlen(s)-len>k
