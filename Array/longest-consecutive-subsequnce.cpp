/*
Given an array of integers, find the length of the longest sub-sequence such that elements in the subsequence
are consecutive integers, the consecutive numbers can be in any order.
Examples

Input: arr[] = {1, 9, 3, 10, 4, 20, 2};
Output: 4
The subsequence 1, 3, 4, 2 is the longest subsequence
of consecutive elements

Input: arr[] = {36, 41, 56, 35, 44, 33, 34, 92, 43, 32, 42}
Output: 5
The subsequence 36, 35, 33, 34, 32 is the longest subsequence
of consecutive elements.

Link to the solution - https://www.geeksforgeeks.org/longest-consecutive-subsequence/
*/

// C++ program to find longest contiguous subsequence 
#include<bits/stdc++.h> 
using namespace std; 
  
// Returns length of the longest contiguous subsequence 
int findLongestConseqSubseq(int arr[], int n) 
{ 
    unordered_set<int> S; 
    int ans = 0; 
  
    // Hash all the array elements 
    for (int i = 0; i < n; i++) 
        S.insert(arr[i]); 
  
    // check each possible sequence from the start 
    // then update optimal length 
    for (int i=0; i<n; i++) 
    { 
        // if current element is the starting 
        // element of a sequence 
        if (S.find(arr[i]-1) == S.end()) 
        { 
            // Then check for next elements in the 
            // sequence 
            int j = arr[i]; 
            while (S.find(j) != S.end()) 
                j++; 
  
            // update  optimal length if this length 
            // is more 
            ans = max(ans, j - arr[i]); 
        } 
    } 
    return ans; 
} 
