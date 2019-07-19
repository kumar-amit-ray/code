'''
Design and implement a data structure for Least Recently Used (LRU) cache. It should support the following operations: get and put.

get(key) - Get the value (will always be positive) of the key if the key exists in the cache, otherwise return -1.
put(key, value) - Set or insert the value if the key is not already present. When the cache reached its capacity, it should invalidate the least recently used item before inserting a new item.

The cache is initialized with a positive capacity.

Follow up:
Could you do both operations in O(1) time complexity?

Example:

LRUCache cache = new LRUCache( 2 /* capacity */ );

cache.put(1, 1);
cache.put(2, 2);
cache.get(1);       // returns 1
cache.put(3, 3);    // evicts key 2
cache.get(2);       // returns -1 (not found)
cache.put(4, 4);    // evicts key 1
cache.get(1);       // returns -1 (not found)
cache.get(3);       // returns 3
cache.get(4);       // returns 4


Leetcode - https://leetcode.com/problems/lru-cache/
'''

class LRUCache(object):
    def __init__(self, capacity):
        """
        :type capacity: int
        """
        self.capacity = capacity
        self.head = ListNode(None)
        self.tail = ListNode(None)
        self.head.next = self.tail
        self.tail.prev = self.head
        self.hashmap = dict()

    def delete_node(self, node):
        node.next.prev = node.prev
        node.prev.next = node.next
        del node


    def add_node(self, key, val):
        node = ListNode((key, val))
        node.next = self.tail
        self.tail.prev.next = node
        node.prev = self.tail.prev
        self.tail.prev = node
        return node

    def get(self, key):
        """
        :type key: int
        :rtype: int
        """
        if key not in self.hashmap: return -1
        node = self.hashmap[key]
        value = node.val[1]

        self.delete_node(node)
        self.add_node(key, value)

        return value

    # node-->(key,value)  hash[key]=node
    def put(self, key, value):
        """
        :type key: int
        :type value: int
        :rtype: None
        """
        if key in self.hashmap: return

        if len(self.hashmap) == self.capacity:
            # delete LRU node from list and hash
            lru = self.head.next           
            del self.hashmap[lru.val[0]]
            self.delete_node(lru)
                

        # add the new node
        new_node = self.add_node(key, value)
        #add to hash
        self.hashmap[key] = new_node



# Your LRUCache object will be instantiated and called as such:
# obj = LRUCache(capacity)
# param_1 = obj.get(key)
# obj.put(key,value)
