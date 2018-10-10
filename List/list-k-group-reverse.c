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
