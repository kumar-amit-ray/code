/*
Write a program to print all the columns of a binary tree from left to right and top down.

          1
        /    \ 
       2      3
      / \   /   \
     4   5  6    7
               /  \ 
              8    9 
               
              
The output of print this tree vertically will be:
4
2
1 5 6
3 8
7
9
*/

/*
We need to check the Horizontal Distances from root for all nodes. If two nodes have the same Horizontal Distance (HD), 
then they are on same vertical line. The idea of HD is simple. HD for root is 0, a right edge (edge connecting to 
right subtree) is considered as +1 horizontal distance and a left edge is considered as -1 horizontal distance. 
For example, in the above tree, HD for Node 4 is at -2, HD for Node 2 is -1, HD for 5 and 6 is 0 and HD for node 7 is +2.
We can do preorder traversal of the given Binary Tree. While traversing the tree, we can recursively calculate HDs.
We initially pass the horizontal distance as 0 for root. For left subtree, we pass the Horizontal Distance as 
Horizontal distance of root minus 1. For right subtree, we pass the Horizontal Distance as Horizontal Distance 
of root plus 1. For every HD value, we maintain a list of nodes in a hasp map. Whenever we see a node in traversal,
we go to the hash map entry and add the node to the hash map using HD as a key in map.
*/

func VOrderTraversal(root *node) map[int][]int {

out := make(map[int][]int)
if root == nil {
	return out
}
VOrderTraversalHelper(root, 0, out)
}

func VOrderTraversalHelper(root *node, level int, result map[int][]int) {
if root == nil {
	return
}
if _, ok := result[level]; ok {
	result[level] = append(result[level], node.value)
} else {
	result[level] = []int{node.value}
}
VOrderTraversalHelper(node.left, level-1, result)
VOrderTraversalHelper(node.right, level+1, result)
}
