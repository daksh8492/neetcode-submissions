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
    public int kthSmallest(TreeNode root, int k) {
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        inOrderK(root, maxHeap, k);
        return maxHeap.poll();
    }

    void inOrderK(TreeNode node, PriorityQueue<Integer> heap, int k) {
        if (node == null)
            return;
        if (heap.size() == k)
            return;
        inOrderK(node.left, heap, k);
        if (heap.size() == k)
            return;
        heap.add(node.val);
        if (heap.size() == k)
            return;
        inOrderK(node.right, heap, k);
    }
}
