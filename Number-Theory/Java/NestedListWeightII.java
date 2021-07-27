/**
 * // This is the interface that allows for creating nested lists.
 * // You should not implement it, or speculate about its implementation
 * public interface NestedInteger {
 *     // Constructor initializes an empty nested list.
 *     public NestedInteger();
 *
 *     // Constructor initializes a single integer.
 *     public NestedInteger(int value);
 *
 *     // @return true if this NestedInteger holds a single integer, rather than a nested list.
 *     public boolean isInteger();
 *
 *     // @return the single integer that this NestedInteger holds, if it holds a single integer
 *     // Return null if this NestedInteger holds a nested list
 *     public Integer getInteger();
 *
 *     // Set this NestedInteger to hold a single integer.
 *     public void setInteger(int value);
 *
 *     // Set this NestedInteger to hold a nested list and adds a nested integer to it.
 *     public void add(NestedInteger ni);
 *
 *     // @return the nested list that this NestedInteger holds, if it holds a nested list
 *     // Return empty list if this NestedInteger holds a single integer
 *     public List<NestedInteger> getList();
 * }
 */

/**
@Leetcode - https://leetcode.com/problems/nested-list-weight-sum-ii/
 */
class Solution {
    Stack<Pair<Integer, Integer>> stack = new Stack();
    static int MAXW = Integer.MIN_VALUE;
    
    public int depthSumInverse(List<NestedInteger> nestedList) {
        helper(nestedList, 1);
        return calculateWeight();
    }
    
    private void helper(List<NestedInteger> nestedList, int level) {
        MAXW = Math.max(MAXW, level);
        for (NestedInteger n : nestedList) {
            if (n.isInteger()) {
                stack.push(new Pair(n.getInteger(), level));
            } else {
                helper(n.getList(), level+1);
            }
        }
    }
    
    private int calculateWeight() {
        int weight = 0;
        while (!stack.isEmpty()) {
            Pair<Integer, Integer> val = stack.pop();
            weight += val.getKey() * (MAXW - val.getValue() + 1);
        }
        return weight;
    }
    
}
