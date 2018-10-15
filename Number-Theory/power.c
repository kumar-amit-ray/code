	/*
  Implement pow(x, n), which calculates x raised to the power n (x^n).
	Example 1:
	Input: 2.00000, 10
Output: 1024.00000
	Example 2:
	Input: 2.10000, 3
Output: 9.26100
	Example 3:
	Input: 2.00000, -2
Output: 0.25000
Explanation: 2-2 = 1/22 = 1/4 = 0.25
*/

double power(double x, int n) {
    if (n == 0) {return 1;}
    
    return (n%2 == 0)?power(x*x, n/2):x*power(x*x, n/2);
}
double myPow(double x, int n) {
  double ans=1;
  bool isneg=false;
  if (n < 0) {
    isneg = true;
    n = abs(n);
  }
  ans = power(x, n);
  return (isneg == true)?1/ans:ans;
}
