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
    public List<List<Integer>> levelOrder(TreeNode root) {
        if (root == null)
            return new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        List<List<Integer>> ans = new ArrayList<>();
        while (!queue.isEmpty()) {
            ans.add(emptySize(queue, queue.size()));
        }
        return ans;
    }

    private List<Integer> emptySize(Queue<TreeNode> queue, int size) {
        if (size == 0)
            return new ArrayList<>();
        List<Integer> ans = new ArrayList<>();
        for (int i = 1; i <= size; i++) {
            TreeNode cur = queue.poll();
            ans.add(cur.val);
            if (cur.left != null)
                queue.add(cur.left);
            if (cur.right != null)
                queue.add(cur.right);
        }
        return ans;
    }
}
