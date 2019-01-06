/*
Given a binary tree, return the zigzag level order traversal of its nodes' values. (ie, from left to right, then right to left for the next level and alternate between).

For example:
Given binary tree [3,9,20,null,null,15,7],
    3
   / \
  9  20
    /  \
   15   7
return its zigzag level order traversal as:
[
  [3],
  [20,9],
  [15,7]
]
*/

// NOTE - This code has problem that map does not preserve order or levels, so the output can come in any 
// order. E.g. for above example output can [[15,7],[20,9],[3]]. So, we need to use a 2D slice as is for storing
// output instead of a temporary map


/**
 * Definition for a binary tree node.
 * type TreeNode struct {
 *     Val int
 *     Left *TreeNode
 *     Right *TreeNode
 * }
 */
func zigzagLevelOrder(root *TreeNode) [][]int {
	var result [][] int
	var m map[int][]int

	m = make(map[int][]int)
	zigzagLevelOrderHelper(root, m, 0)

	for _, value := range m {
		result = append(result, value)
	}
	return result
}

func zigzagLevelOrderHelper(root *TreeNode, m map[int][]int, level int) {
	if root == nil {
		return
	}
	val, ok := m[level]
	if ok == true {
		val = append(val, root.Val)
		m[level]  = val
	} else {
		newval := make([]int, 0)
		newval = append(newval, root.Val)
		m[level] = newval
	}
	if level%2 != 0 {
		zigzagLevelOrderHelper(root.Left, m, level+1)
		zigzagLevelOrderHelper(root.Right, m, level+1)
	} else {
		zigzagLevelOrderHelper(root.Right, m, level+1)
		zigzagLevelOrderHelper(root.Left, m, level+1)
	}
}
