
/*
  Suppose an array sorted in ascending order is rotated at some pivot unknown to you beforehand.
(i.e., [0,1,2,4,5,6,7] might become [4,5,6,7,0,1,2]).
You are given a target value to search. If found in the array return its index, otherwise return -1.
You may assume no duplicate exists in the array.
Your algorithm's runtime complexity must be in the order of O(log n).
Example 1:
Input: nums = [4,5,6,7,0,1,2], target = 0
Output: 4
Example 2:
Input: nums = [4,5,6,7,0,1,2], target = 3
Output: -1

*/
#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <stdbool.h>

/*
  1. pivot = (start+end)/2
  2. if array[pivot] > array[pivot+1], return pivot else
  3. if array[start] < array[pivot], means starting 'start' to 'pivot' is fully sorted. So, pivot
    lies between pivot+1 to end.
  4. if array[start] > array[pivot], means 'start' to 'pivot' is not fully sorted. So, pivot lies
    between start, pivot-1.
  5. We ignore pivot in both cases because we know that it is not pivot.
*/
int findPivot(int *array, int start, int end)
{
    int pivot;

    while (start <= end) {
	pivot = (start+end)/2;
	if (array[pivot] > array[pivot+1]) return pivot+1;
	if (array[start] <= array[pivot]) start = pivot+1;
	else end = pivot-1;	
    }
    return -1;
}

int binarySearch(int *array, int start, int end, int target)
{
    int pivot;	
    while (start <= end) {
	pivot = (start+end)/2;
	if (array[pivot] == target) return pivot;
	if (array[pivot] < target) start = pivot+1;
	else end = pivot-1;	
    }
    return -1;
}

int search(int* nums, int numsSize, int target) {
    int pivot;

    pivot = findPivot(nums, 0, numsSize-1);
    if (nums[pivot] == target) return pivot;
    if (target > nums[pivot] && target < nums[numsSize-1]) return binarySearch(nums, pivot+1, numsSize-1, target);
    else return binarySearch(nums, 0, pivot-1, target);
}



/*
	Given a sorted array with possibly duplicate elements, the task is to find indexes of first and last occurrences of an element x in the given array.
	Examples:
	Input : arr[] = {1, 3, 5, 5, 5, 5 ,67, 123, 125}    
        x = 5
Output : First Occurrence = 2
         Last Occurrence = 5
	Input : arr[] = {1, 3, 5, 5, 5, 5 ,7, 123 ,125 }    
        x = 7
Output : First Occurrence = 6
         Last Occurrence = 6

*/
/*
  it is based on same binary search algo.
  1. Calculate pivot.
  2. If array[pivot] == target, modify *li and *hi. Now because target is repeated,
      more values of target can be present on both right and left side of pivot.
      So, just check array[pivot-1] and [pivot+1] to see we should do a binary search on the
      corresponding sides.
*/
void binarySearchStartEnd(int *array, int start, int end, int target, int *li, int *hi)
{
    printf("Start:%d end:%d\n",start, end);
    if (start > end) return;
    int pivot = (start+end)/2;
    if (array[pivot] == target) {
      if (*li == -1) {*li = pivot;*hi = pivot;}
      else if (pivot < *li) {*li = pivot;}
      else if (pivot > *hi) {*hi = pivot;}
      printf("Changed low:%d, hi:%d \n", *li, *hi);
      if (pivot > start && array[pivot-1] == target) {
         binarySearchStartEnd(array, start, pivot-1, target, li, hi);
      }
      if (pivot < end && array[pivot+1] == target) {
         binarySearchStartEnd(array, pivot+1, end, target, li, hi);
      }
    } else if (target > array[pivot]) {
      binarySearchStartEnd(array, pivot+1, end, target, li, hi);
    } else {
      binarySearchStartEnd(array, start, pivot-1, target, li, hi);
    }
}

int main()
{
  int array[] = {2,4,5,6,7,8,9,0,1};
  //int array[] = {1,3};
  int size = 9;
  printf("%d\n", findPivot(array, 0, size-1));
  printf("Expected:0 Got=%d\n", search(array, size,2));
  printf("Expected:6 Got=%d\n", search(array, size,9));
  printf("Expected:-1 Got=%d\n", search(array, size,50));
  printf("Expected:3 Got=%d\n", search(array, size,6));
/*
  //int array[] = {5,7,7,8,8,10};
  int array[] = {1, 3, 5, 5, 5, 5 ,67, 123, 125};
  int size = 9;
  int li=-1, hi=-1;
  binarySearchStartEnd(array, 0, size-1, 5, &li, &hi);
  printf("\n%d %d\n", li, hi);
*/
}
