/**
Leetcode - https://leetcode.com/problems/serialize-and-deserialize-binary-tree/
 */
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Codec {

    int index = 0;

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if (root == null) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        sb.append(root.val);
        serializeRecursive(root, sb);
        return sb.toString();
    }

    private void serializeRecursive(TreeNode root, StringBuilder sb) {
        if (root == null) {
            return;
        }
        sb.append(",");
        sb.append(root.left == null ? "null" : root.left.val);
        sb.append(",");
        sb.append(root.right == null ? "null" : root.right.val);
        serializeRecursive(root.left, sb);
        serializeRecursive(root.right, sb);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if (data.isEmpty()) {
            return null;
        }
        String[] splitter = data.split(",");
        index = 0;
        TreeNode root = new TreeNode(Integer.parseInt(splitter[0]));
        index++;
        deserializeRecursive(root, splitter);
        return root;
    }

    private void deserializeRecursive(TreeNode root, String[] data) {
        if (root == null || index >= data.length) {
            return;
        }

        if (!"null".equals(data[index])) {
            root.left = new TreeNode(Integer.parseInt(data[index]));
        }
        index++;
        if (!"null".equals(data[index])) {
            root.right = new TreeNode(Integer.parseInt(data[index]));
        }
        index++;
        deserializeRecursive(root.left, data);
        deserializeRecursive(root.right, data);
    }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));
