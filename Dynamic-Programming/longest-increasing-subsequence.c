/*
Given an unsorted array of integers, find the length of longest increasing subsequence.
Example:
Input: [10,9,2,5,3,7,101,18]
Output: 4 
Explanation: The longest increasing subsequence is [2,3,7,101], therefore the length is 4. 
Note:
	• There may be more than one LIS combination, it is only necessary for you to return the length.
	• Your algorithm should run in O(n2) complexity.

Youtube - https://www.youtube.com/watch?v=CE2b_-XfVDk
*/


int max(int a, int b) {
    if (a > b) return a;
    return b;
}

int lengthOfLIS(int* nums, int numsSize) {
    if (nums == NULL || numsSize == 0) {
        return 0;
    }
    int lis[numsSize];
    int i, j, len=-1;
    
    // set the longest subsequence to at least 1 for each number
    for (i=0; i<numsSize; i++) {
        lis[i] = 1;
    }
    
    for (i=0; i<numsSize; i++) {
        j=0;
        while (j < i) {
            if (nums[j] < nums[i]) {
                lis[i] = max(lis[i], lis[j]+1);
            }
            j++;
        }
    }
    for (i=0; i<numsSize; i++) {
        len = max(len, lis[i]);
    }
    return len;
}
