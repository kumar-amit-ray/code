/*
	6. Find a sorted subsequence of size 3 in linear time
Given an array of n integers, find the 3 elements such that a[i] < a[j] < a[k] and i < j < k in 0(n) time. If there are multiple such triplets, then print any one of them.
Examples:
Input:  arr[] = {12, 11, 10, 5, 6, 2, 30}
Output: 5, 6, 30
Input:  arr[] = {1, 2, 3, 4}
Output: 1, 2, 3 OR 1, 2, 4 OR 2, 3, 4
Input:  arr[] = {4, 3, 2, 1}
Output: No such triplet
*/

bool increasingTriplet(int* nums, int numsSize) {
    int small=INT_MAX, large=INT_MAX;
    int i, j;
    
    for (i=0; i<numsSize; i++) {
        if (nums[i] <= small) {small = nums[i];}
        else if (nums[i] <= large) {large = nums[i];}
        else {break;}
    }
    if (i == numsSize) {return false;}
    
    /* Note that small can get incorrect after the above operation.
       for input [5,7,4,8], the above loop will return small=4, large=7, last=nums[i]=8.
       which is incorrect. So we have to fix small. Small can be the first number in the array
       which is less than the large.
    */   
    for (j=0; j<i; j++) {
        if (nums[i] < large) {small = nums[j];}
    }
    return true;
}
