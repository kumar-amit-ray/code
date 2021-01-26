/**
 * Given n non-negative integers representing the histogram's bar height where the width of each bar is 1,
 * find the area of largest rectangle in the histogram.
 *
 * @Leetcode - https://leetcode.com/problems/largest-rectangle-in-histogram/
 * @Youtube - https://www.youtube.com/watch?v=MhQPpAoZbMc&t=1411s
 * 1) Create an empty stack.
 * 2) Start from first bar, and do following for every bar ‘hist[i]’ where ‘i’ varies from 0 to n-1.
 *  a) If stack is empty or hist[i] is higher than the bar at top of stack, then push ‘i’ to stack.
 *  b) If this bar is smaller than the top of stack, then keep removing the top of stack while top of the stack 
 *     is greater. Let the removed bar be hist[tp]. Calculate area of rectangle with hist[tp] as smallest bar. For hist[tp], 
 *     the ‘left index’ is previous (previous to tp) item in stack and ‘right index’ is ‘i’ (current index).
 * 3) If the stack is not empty, then one by one remove all bars from stack and do step 2.b for every removed bar.
 *  
 */
public class MaxAreaOfHistogram {
    public int largestRectangleArea(int[] hist) {
        if (hist == null || hist.length == 0) {return 0;}

        int i = 0;
        int result = Integer.MIN_VALUE;
        Stack<Integer> stack = new Stack();
        while(i<hist.length) {
            if (stack.isEmpty() || hist[i] >= hist[stack.peek()]) {
                stack.push(i++);
            } else {
                int elem = stack.pop();
                int area = hist[elem] * (stack.isEmpty() ? i : (i - stack.peek() - 1));
                result = Math.max(result, area);
            }
        }
        while(!stack.isEmpty()) {
            int elem = stack.pop();
            int area = hist[elem] * (stack.isEmpty() ? i : (i - stack.peek() - 1));
            result = Math.max(result, area);
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(new MaxAreaOfHistogram().largestRectangleArea(new int[]{2, 0, 2}));
    }
}
