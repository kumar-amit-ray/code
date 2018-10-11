/*
Given a linked list, reverse the nodes of a linked list k at a time and return its modified list. k is a positive integer and is less than or equal to the length of the linked list. If the number of nodes is not a multiple of k then left-out nodes in the end should remain as it is.
Example:
Given this linked list: 1->2->3->4->5
For k = 2, you should return: 2->1->4->3->5
For k = 3, you should return: 3->2->1->4->5

*/

node * getKthNode(node *head, int k)
{
	node *temp= head;
	k--;
	while (k && temp != NULL) {
		temp = temp->next;
		k--;
	}
	return temp;
}
void reverseKNodes(node **start, int k)
{
	node *point_to=NULL, *to_point=NULL, *curr=NULL;
	if (*start == NULL) {
		return;
	}
	curr = *start;
	while(k) {
		point_to = curr;
		curr = curr->next;
		point_to->next = to_point;
		to_point = point_to;
		k--;
	}
}

void listKReverse(node **head, int k)
{
	node *start = *head;
	node *kth = NULL;
	node *save = NULL;
	node *prevend = NULL;

	kth = getKthNode(start, k);
	*head = kth;
	while (kth) {
		save = kth->next;
		reverseKNodes(&start, k);
		if (prevend) prevend->next=kth;
		prevend = start;
		start = save;
		kth = getKthNode(save, k);
	}
	prevend->next = save;
}
