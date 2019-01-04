/*
Given a string containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.
An input string is valid if:
	1. Open brackets must be closed by the same type of brackets.
	2. Open brackets must be closed in the correct order.
Note that an empty string is also considered valid.
Example 1:
Input: "()"
Output: true
Example 2:
Input: "()[]{}"
Output: true
Example 3:
Input: "(]"
Output: false
Example 4:
Input: "([)]"
Output: false
Example 5:
Input: "{[]}"
Output: true
*/


func parenthesesisValidator(str string) bool {
    var s sstack

    if len(str) == 0 {
        return true
    }
    if len(str) == 1 {
        return false
    }
    s.stackinit()
    sarr := strings.Split(str, "")
    for _, b:= range sarr {
        if b == "(" {
            s.push(")")
        } else if b == "{" {
            s.push("}")
        } else if b == "[" {
            s.push("]")
        } else if s.isempty() || s.pop() != b {
            return false
        }
    }
    return s.isempty()
}



/*
	Given a string with alpha-numeric characters and parentheses, return a string with balanced parentheses 
	by removing the fewest characters possible. You cannot add anything to the string.

*/

#include<stdio.h>
#include<memory.h>
#include<stdlib.h>


#define MAX_STACK_ELEM	20
typedef struct stack_t_ {
	int elem[MAX_STACK_ELEM];
	int top;
}stack_st;

void initStack(stack_st	*stack)
{
	memset(stack, 0, sizeof(stack_st));
	stack->top = -1;
}

void pushStack(stack_st *stack, int val)
{
	if (stack->top == MAX_STACK_ELEM - 1) {
		printf("\nStack is full..");
		return;
	}
	(stack->top)++;
	stack->elem[stack->top] = val;
}

int popStack(stack_st *stack)
{
	int temp;

	if (stack->top == -1) {
		printf("\nstack is empty..");
		return -1;
	}
	temp = stack->elem[stack->top];
	(stack->top)--;
	return temp;
}

void displayStack(stack_st *stack)
{
	int i=0;

	if (stack->top == -1) {
		printf("\nstack is empty..");
		return;
	}

	printf("\n");
	for (i=0; i<= stack->top; i++) {
		printf("%d ", stack->elem[i]);
	}
}

/* Algorithm :
	1. scan through all char. If the char is not '(' or ')', copy it as is.
	2. If the char is '(', push it's position onto a stack and also copy it. If we don't find a corresponding ')', we will delete it latter.
	3. if the char is ')', pop element from stack.
		a. If we get an element from the stack, it is a balanced ')', so copy it to array.
		b. if we don't, it is a unbalanced ')', don't copy it in array.
	4. Finally pop all element from stack. These are the unbalanced "(". Mark them for deletion.
*/

void removeUnbalcedParanthesis(char *str)
{
	stack_st 	stack;
	char 		arr[strlen(str)];
	int         i=0;
	int 		index=0;
	char 		*wrstr=str;

	initStack(&stack);
	memset(arr, 0, sizeof(arr));

	while (*str != '\0') {
		if (*str != '(' && *str != ')') {
			/* regular char, copy as is */
			arr[i] = *str;
		} else if (*str == '(') {
			/* save the char position on the stack */
			pushStack(&stack, i);
			arr[i] = *str;
		} else {
			/* we got a ')', pop from stack to see if we have a '(' for this one */
			index = popStack(&stack);
			if (index == -1) {
				/* we don't. so mark it for deletion*/
				arr[i] = '\0';
			} else {
				/* we have, so copy the char */
				arr[i] = *str;
			}
		}
		str++; i++;
	}
	/* Now pop any remaining '(', for which we don't have a ')'. Mark them for deletion */
	while ((index = popStack(&stack)) != -1) {
		arr[index] = '\0';
	}
	/* copy all the valid char to the same string now */
	for (i=0; i<sizeof(arr); i++) {
		if (arr[i] != '\0') {
			*wrstr = arr[i];
			wrstr++;
		}
	}
	/* null terminate the string */
	*wrstr = '\0';
}

int main()
{
	char arr[] = "ab(cd)))))))(ef(hh))";

	removeUnbalcedParanthesis((char *)arr);
	printf("\n%s\n", arr);
}
