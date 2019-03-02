	/*
  Given a non-negative integer c, your task is to decide whether there're two integers a and b such that a2 + b2 = c. 
  Sum of Square of Two numbers
	
	Example 1:
	Input: 5
Output: True
Explanation: 1 * 1 + 2 * 2 = 5
	Example 2:
	Input: 3
Output: False
*/

bool judgeSquareSum(int c) {
    int left, right;
    int sum; 
    
    left = 0; right  = sqrt(c);
    while (left <= right) {
        sum = left*left+right*right;
        if (sum < c) {left++;}
        else if (sum > c) {right--;}
        else {return true;}
    }
    return false;
}
