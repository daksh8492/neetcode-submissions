/*
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
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return build(preorder, 0, preorder.length-1, inorder, 0, inorder.length-1);
    }

    TreeNode build(int[] pre, int preS, int preE, int[] in, int inS, int inE){
        if (inE - inS < 0 || preE - preS < 0) return null;
        TreeNode root = new TreeNode(pre[preS]);
        int rootPos = inS;
        for(; rootPos <= inE && in[rootPos] != pre[preS]; rootPos++){}
        int left = preS;
        for(int i = 0; i < rootPos - inS;  left++, i++){}
        root.left = build(pre, preS+1, left, in, inS, rootPos-1);
        root.right = build(pre,left+1,preE,in,rootPos+1,inE);
        return root;
    }
}
