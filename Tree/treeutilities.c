	//Algorithm to find height/depth of a Binary tree
			
			Uint32_t  findHeightOfTree(node *tree)
			{
				If (tree == NULL) {
					Return 0;
				}
				If (tree->left != NULL) {
					H1 = findHeightOfTree(tree->left);
				}
				If (tree->right != NULL) {
					H2 = findHeightOfTree(tree->right);
				}
				Return (max(H1, H2) +1);
			}
				 
				
	//Algorith to find number of elements in a Binary tree
  
				int numNodeBst(bsNode *root)
				{
				    if (root == NULL) {
				        return 0;
				    } else {
				        return (numNodeBst(root->left) + numNodeBst(root->right) + 1);
				    }
				}
				
	//Algorithm to do DFS on a Binary search tree
	
	Void doDfs(node *root)
	{
		Node *temp=root;
		
		qEnqueue(temp);
		While ((temp = qDequeue()) != NULL) {
			Printf("%d", temp->data);
			If (temp->ltree) {
				qEnqueue(temp->ltree);
			}
			If (temp->rtree) {
				qEnqueue(temp->rtree);
			}
			
		}
	}
