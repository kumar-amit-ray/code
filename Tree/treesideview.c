/*
Given a binary tree, imagine yourself standing on the right side of it, return the values of the nodes you can see ordered from top to bottom.
*/

typedef struct queueNode {
	treeNode 	*node;
	int 		level;
};


treeNode *sideView[MAX_TREE_DEPTH];

/* Algorithm:
	1. Take a array of size tree depth. This array will contain side view tree nodes.
	2. The idea is at each level we will enqueue right child first and then left. So it is guranteed that right child will always
	   get processed before left child. 
	3. If at any level we will process right subtree first and then left subtree. 
	4. As we are processing right subtree first, sideView array at each level will always contain the right most child in right subtree.
	5. If at any level right subtree does not exist, left subtree is choosen.
*/
int populateSideView(treeNode *root)
{
	queueNode *node=NULL;
	
	//Queue will have node and its depth.
	enQueue(root, 0);
	
	while ((node = dQueue()) != NULL) {
		if (sideView[node->level] == NULL) {
			sideView[node->level] = node->node;
		}
		if (node->node->right != NULL) { enQueue(node->node->right, node->level+1);}
		if (node->node->left != NULL) { enQueue(node->node->left, node->level+1);}
	}
}
