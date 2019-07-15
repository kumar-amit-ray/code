"""
Serialization is the process of converting a data structure or object into a sequence of bits so that it can be stored in a file or memory buffer, or transmitted across a network connection link to be reconstructed later in the same or another computer environment.

Design an algorithm to serialize and deserialize a binary tree. There is no restriction on how your serialization/deserialization algorithm should work. You just need to ensure that a binary tree can be serialized to a string and this string can be deserialized to the original tree structure.

Example: 

You may serialize the following tree:

    1
   / \
  2   3
     / \
    4   5

as "[1,2,3,null,null,4,5]"
Clarification: The above format is the same as how LeetCode serializes a binary tree. You do not necessarily need to follow this format, so please be creative and come up with different approaches yourself.

Note: Do not use class member/global/static variables to store states. Your serialize and deserialize algorithms should be stateless.

Leetcode - https://leetcode.com/problems/serialize-and-deserialize-binary-tree/

"""
# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Codec:

    def serialize(self, root):
        """Encodes a tree to a single string.
        
        :type root: TreeNode
        :rtype: str
        """
        result = list()
        if root is None:
            return result
        result.append(str(root.val))
        self.serialize_helper(root, result)
        return ''.join(result)
    
    def serialize_helper(self, node, result):
        if node is None:
            return
        if node.left:
            result.append(','+str(node.left.val))
        else:
            result.append(',NIL')
        if node.right:
            result.append(','+str(node.right.val))
        else:
            result.append(',NIL')

        self.serialize_helper(node.left, result)
        self.serialize_helper(node.right, result)

    def deserialize(self, data):
        """Decodes your encoded data to tree.
        
        :type data: str
        :rtype: TreeNode
        """
        if data is None or len(data) == 0:
            return None
        data = data.split(',')
        node = TreeNode((data[0]))
        del data[0]
        self.deserialize_helper(node, data)
        return node
    
    def deserialize_helper(self, node, data):
        if node is None or len(data) == 0:
            return
        lnode = None
        rnode = None

        if data[0] != 'NIL':
           lnode = TreeNode((data[0]))
           node.left = lnode
           del data[0]
        else:
            del data[0]

        if data[0] != 'NIL':
           rnode = TreeNode((data[0]))
           node.right = rnode
           del data[0]
        else:
            del data[0]

        self.deserialize_helper(lnode, data)
        self.deserialize_helper(rnode, data)
        
# Your Codec object will be instantiated and called as such:
# codec = Codec()
# codec.deserialize(codec.serialize(root))
