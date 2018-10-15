/*
Given a nested list of integers, return the sum of all integers in the list weighted by their depth.
         Each element is either an integer, or a list -- whose elements may also be integers or other lists.
Example 1:
Given the list [[1,1],2,[1,1]], return 10. (four 1's at depth 2, one 2 at depth 1)
Example 2:
Given the list [1,[4,[6]]], return 27. (one 1 at depth 1, one 4 at depth 2, and one 6 at depth 3; 1 + 4*2 + 6*3 = 27)
*/

/**
 * // This is the interface that allows for creating nested lists.
 * // You should not implement it, or speculate about its implementation
 * type NestedInteger struct {
 * }
 *
 * // Return true if this NestedInteger holds a single integer, rather than a nested list.
 * func (n NestedInteger) IsInteger() bool {}
 *
 * // Return the single integer that this NestedInteger holds, if it holds a single integer
 * // The result is undefined if this NestedInteger holds a nested list
 * // So before calling this method, you should have a check
 * func (n NestedInteger) GetInteger() int {}
 *
 * // Set this NestedInteger to hold a single integer.
 * func (n *NestedInteger) SetInteger(value int) {}
 *
 * // Set this NestedInteger to hold a nested list and adds a nested integer to it.
 * func (n *NestedInteger) Add(elem NestedInteger) {}
 *
 * // Return the nested list that this NestedInteger holds, if it holds a nested list
 * // The list length is zero if this NestedInteger holds a single integer
 * // You can access NestedInteger's List element directly if you want to modify it
 * func (n NestedInteger) GetList() []*NestedInteger {}
 */
 
func depthSum(nestedList []*NestedInteger) int {
    return calculateSum(nestedList, 1)
}

func calculateSum(nestedList []*NestedInteger, level int) int {
    var sum int
    for _, val:= range nestedList {
        if val.IsInteger() {
            sum += level * val.GetInteger()
        } else {
            sum += calculateSum(val.GetList(), level+1)
        }
    }
    return sum
}


/*
	Given a nested list of integers, return the sum of all integers in the list weighted by their depth.
	Each element is either an integer, or a list -- whose elements may also be integers or other lists.
	Different from the previous question where weight is increasing from root to leaf, now the weight is defined from bottom up. i.e., the leaf level integers have weight 1, and the root level integers have the largest weight.
	Example 1:
	Given the list [[1,1],2,[1,1]], return 8. (four 1's at depth 1, one 2 at depth 2)
	Example 2:
Given the list [1,[4,[6]]], return 17. (one 1 at depth 3, one 4 at depth 2, and one 6 at depth 1; 1*3 + 4*2 + 6*1 = 17)
*/

type data struct {
    data int
    level int
}

var stack []data
var maxlevel int

func push(val int, level int) {
    var elem = data {val, level}
    stack = append(stack, elem)
    if level > maxlevel {
        maxlevel = level
    }
}


func depthSumInverse(nestedList []*NestedInteger) int {    
    var sum int
    calculateSum(nestedList, 1)
    for _, elem := range stack {
        sum += elem.data * (maxlevel-elem.level+1)
    }
    return sum
}

func calculateSum(nestedList []*NestedInteger, level int) {
    for _, val:= range nestedList {
        if val.IsInteger() {
            push(val.GetInteger(), level)
        } else {
            calculateSum(val.GetList(), level+1)
        }
    }
}
