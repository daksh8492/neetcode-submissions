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

class Solution {
    public boolean isValidBST(TreeNode root) {
        if (root == null)
            return true;
        return isValid(root.left, Integer.MIN_VALUE, root.val)
            && isValid(root.right, root.val, Integer.MAX_VALUE);
    }

    boolean isValid(TreeNode node, int min, int max) {
        if (node == null)
            return true;
        if (node.val <= min || node.val >= max)
            return false;
        return isValid(node.left, min, node.val) && isValid(node.right, node.val, max);
    }
}
