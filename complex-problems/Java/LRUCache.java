/**
 * Design a data structure that follows the constraints of a Least Recently Used (LRU) cache.
 *
 * Implement the LRUCache class:
 *
 * LRUCache(int capacity) Initialize the LRU cache with positive size capacity.
 * int get(int key) Return the value of the key if the key exists, otherwise return -1.
 * void put(int key, int value) Update the value of the key if the key exists. Otherwise, add the key-value pair to the cache. If the number of keys exceeds the capacity from this operation, evict the least recently used key.
 * Follow up:
 * Could you do get and put in O(1) time complexity?
 *
 *
 *
 * Example 1:
 *
 * Input
 * ["LRUCache", "put", "put", "get", "put", "get", "put", "get", "get", "get"]
 * [[2], [1, 1], [2, 2], [1], [3, 3], [2], [4, 4], [1], [3], [4]]
 * Output
 * [null, null, null, 1, null, -1, null, -1, 3, 4]
 *
 * Explanation
 * LRUCache lRUCache = new LRUCache(2);
 * lRUCache.put(1, 1); // cache is {1=1}
 * lRUCache.put(2, 2); // cache is {1=1, 2=2}
 * lRUCache.get(1);    // return 1
 * lRUCache.put(3, 3); // LRU key was 2, evicts key 2, cache is {1=1, 3=3}
 * lRUCache.get(2);    // returns -1 (not found)
 * lRUCache.put(4, 4); // LRU key was 1, evicts key 1, cache is {4=4, 3=3}
 * lRUCache.get(1);    // return -1 (not found)
 * lRUCache.get(3);    // return 3
 * lRUCache.get(4);    // return 4
 *
 * @Leetcode- https://leetcode.com/problems/lru-cache/
 */
class LRUCache {
    class LRUNode {
        int key;
        int val;
        LRUNode next;
        LRUNode prev;
    }
    LRUNode head;
    LRUNode tail;
    Map<Integer, LRUNode> lruMap;
    int capacity;
    int size;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.size = 0;
        lruMap  = new HashMap<>();
        head = new LRUNode();
        tail = new LRUNode();
        head.next = tail;
        tail.prev = head;
        tail.next = null;
        head.prev = null;
    }

    private LRUNode addNode(int key, int val) {
        LRUNode node = new LRUNode();
        node.key = key;
        node.val = val;
        node.prev = tail.prev;
        tail.prev.next = node;
        tail.prev = node;
        node.next = tail;
        return node;
    }

    private void delNode(LRUNode node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
        node.prev = null;
        node.next = null;
    }

    public int get(int key) {
        if (!lruMap.containsKey(key)) {
            return -1;
        }
        LRUNode node = lruMap.get(key);
        int value = node.val;
        lruMap.remove(key);
        delNode(node);
        lruMap.put(key, addNode(key, value));
        return value;
    }

    public void put(int key, int value) {
        LRUNode node = lruMap.get(key);

        if (node == null) {
            if (size < capacity) {
                lruMap.put(key, addNode(key, value));
                size++;
            } else {
                // delete the least recently used key
                lruMap.remove(head.next.key);
                delNode(head.next);
                // add the new one
                lruMap.put(key, addNode(key, value));
            }
        } else {
            node.val = value;
            // make a get call to move it to the front
            get(key);
        }
    }
}


/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
