bsNode *findInorderSucc(bsNode *root, int key)
{
	bsNode *node=NULL;
	bsNode *parent=NULL;
	bsNode *temp=NULL;
	bsNode *inSucc=NULL;

	if (!root) return NULL;

	searchBst(root, &node, &parent, key);
	if (node == NULL) {
		printf("\nCould not find node with key:%d", key);
		return NULL;
	}

	/* Algo:
	 * if node has a right subtree then min value of right subtree is the inorder successor.
	 *    - to Find min, keep going left unless a node is find which does not have a left child.
	 * if node does not have a right subtree then keep travesing the tree unless we find the
	 *    node which is just greater than the key.
	 */
	if (node->right != NULL) {
		temp = node->right;
		while (temp->left) {
			temp = temp->left;
		}
		return (temp);
	}
	temp = root;
	while (temp) {
		if (key < temp->data) {
			inSucc = temp;
			temp = temp->left;
		} else if (key > temp->data) {
			temp = temp->right;
		} else{
			break;
		}
	}
	return (inSucc);
}
