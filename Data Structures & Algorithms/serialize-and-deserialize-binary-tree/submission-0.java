/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

public class Codec {
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        serialize(root, sb);
        sb.deleteCharAt(sb.length() - 1);
        return sb.toString();
    }

    private void serialize(TreeNode node, StringBuilder sb) {
        if (node == null) {
            sb.append('#').append(',');
            return;
        }
        sb.append(node.val).append(',');
        serialize(node.left, sb);
        serialize(node.right, sb);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        return deserialize(new StringBuilder(data));
    }

    private TreeNode deserialize(StringBuilder data) {
        if (data.isEmpty())
            return null;
        int pos = data.indexOf(",");
        if (pos == -1)
            pos = data.length() - 1;
        if (data.charAt(0) == '#') {
            data.delete(0, pos + 1);
            return null;
        }
        int val = Integer.parseInt(data.substring(0, pos));
        TreeNode node = new TreeNode(val);
        data.delete(0, pos + 1);
        node.left = deserialize(data);
        node.right = deserialize(data);
        return node;
    }
}
