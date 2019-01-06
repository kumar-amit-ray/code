/**
 * Definition for a binary tree node.
 * type TreeNode struct {
 *     Val int
 *     Left *TreeNode
 *     Right *TreeNode
 * }
 */
func largestValues(root *TreeNode) []int {
    m := make(map[int]int)
    largestHelper(root, 0, m)
    ans := make([]int, len(m))
    for key, val:= range m {
        ans[key] = val
    }
    return ans
}

func largestHelper(root *TreeNode, level int, m map[int]int) {
	if root == nil {
		return
	}
	if val, ok := m[level]; ok {
		m[level] = int(math.Max(float64(val), float64(root.Val)))
	} else {
		m[level] = root.Val
	}
	largestHelper(root.Left, level+1, m)
	largestHelper(root.Right, level+1, m)
}
