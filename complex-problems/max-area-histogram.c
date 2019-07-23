/*
https://www.youtube.com/watch?v=MhQPpAoZbMc&t=1411s

Create an empty stack.
2) Start from first bar, and do following for every bar ‘hist[i]’ where ‘i’ varies from 0 to n-1.
……a) If stack is empty or hist[i] is higher than the bar at top of stack, then push ‘i’ to stack.
……b) If this bar is smaller than the top of stack, then keep removing the top of stack while top of the stack 
is greater. Let the removed bar be hist[tp]. Calculate area of rectangle with hist[tp] as smallest bar. For hist[tp], 
the ‘left index’ is previous (previous to tp) item in stack and ‘right index’ is ‘i’ (current index).
3) If the stack is not empty, then one by one remove all bars from stack and do step 2.b for every removed bar.
Following is implementation of the above algorithm.

*/

int findMaxRectrangeAreaOfHistogram(int hist[], int size)
{
	int i=0;
	int area=0,maxarea=0, index=0;
	stack_t stack;

	initStack(&stack);

	while (i<size) {
		if ((stackisEmpty(&stack) == true) || (hist[i] >= hist[stackTop(&stack)])) {
			pushStack(&stack, i++);
		} else {
			index = popStack(&stack);
			area = hist[index] * ((stackisEmpty(&stack) == true)?i : i-stackTop(&stack)-1);
			if (area > maxarea) {
				maxarea = area;
			}
		}
	}
	while(stackisEmpty(&stack) == false) {
		index = popStack(&stack);
		area = hist[index] * ((stackisEmpty(&stack) == true)?i : i-stackTop(&stack)-1);
		if (area > maxarea) {
			maxarea = area;
		}
	}
	return maxarea;
}

In Python
---------
class Solution(object):
    def __init__(self):
        self.stack = list()

    def stack_empty(self):
        if len(self.stack)==0:
            return True
        return False

    def stack_top(self):
        return self.stack[len(self.stack)-1]

    def stack_pop(self):
        return self.stack.pop()

    def stack_push(self, val):
        self.stack.append(val)
        
    def largestRectangleArea(self, heights):
        """
        :type heights: List[int]
        :rtype: int
        """
        if heights is None or len(heights) == 0: return 0
        i = 0
        maxarea = 0
        while i < len(heights):
            if self.stack_empty() or heights[i] >= heights[self.stack_top()]:
                self.stack_push(i)
                i +=1
            else:
                current = self.stack_pop()
                if self.stack_empty():
                    area = heights[current] * i
                else:
                    area = heights[current] * (i-self.stack_top()-1)

                maxarea = max(maxarea, area)

        while self.stack_empty() is False:
            current = self.stack_pop()
            if self.stack_empty():
                area = heights[current] * i
            else:
                area = heights[current] * (i - self.stack_top() - 1)

            maxarea = max(maxarea, area)

        return maxarea
