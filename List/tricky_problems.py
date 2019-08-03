'''
    Implement an algorithm to delete the node in the moddle of a singly linked list, given
    only access to that node. 
    
    Solution - Copy the data from the node.next to node and then delete the node.next.
    But this will not work if the node to be deleted is the last node unless there is a 
    specific marker for the last node.
 '''
    def remove_node_from_middle(self, node):
        node.val = node.next.val
        node.next = node.next.next
        del node
 
 '''
    Write code to remove duplicates from an unsorted linked list
 '''
    def ddup(self):
        hashmap = dict()
        node = self.head
        while node is not None:
            if node.val not in hashmap:
                hashmap[node.val] = node
            else:
                self.delete(node)
            node = node.next
    '''
    write code to partition linked list around a value x, such that all nodes less than x comes before all nodes greater 
    than or equal to x.
    
    Algo: maintain two list - l1 and l2. travel the list - for element < x, add to l1, for element > x add to l2. For element=x,
          add to l2's head, so that x is always the start element of l2. Now just merge l1 and l2.
    '''
    def partitionatx(self, x):
        l1 = None
        l2 = None
        tnode = self.head
        l1prev = None
        l2prev = None
        while tnode:
            nnode = tnode.next
            if tnode.val < x:
                if l1 is None:
                    l1 = tnode
                    l1prev = l1
                else:
                    l1prev.next = tnode
                    l1prev = tnode
            elif tnode.val == x:
                if l2 is None:
                    l2 = tnode
                    l2prev = l2
                else:
                    tnode.next = l2
                    l2 = tnode
            else:
                if l2 is None:
                    l2 = tnode
                    l2prev = l2
                else:
                    l2prev.next = tnode
                    l2prev = tnode

            tnode = nnode

        l1prev.next = l2

        return l1
