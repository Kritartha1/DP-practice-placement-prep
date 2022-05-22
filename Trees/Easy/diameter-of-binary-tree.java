//leetcode.com/problems/diameter-of-binary-tree/
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
class SolutionX {//10ms code
    public int diameterOfBinaryTree(TreeNode root) {
        if(root==null){
            return 0;
        }
        int l=height(root.left);
        int r=height(root.right);
        int d=l+r;
        return Math.max(d,Math.max(diameterOfBinaryTree(root.left),diameterOfBinaryTree(root.right)));
        
    }
    public int height(TreeNode root){
        if(root==null){
            return 0;
        }
        int h=1;
        
        return h+Math.max(height(root.left),height(root.right));
        
    }
}

public class Solution {//0 ms code
    int max = 0;
    
    public int diameterOfBinaryTree(TreeNode root) {
        maxDepth(root);
        return max;
    }
    
    private int maxDepth(TreeNode root) {
        if (root == null) return 0;
        
        int left = maxDepth(root.left);
        int right = maxDepth(root.right);
        
        max = Math.max(max, left + right);
        
        return Math.max(left, right) + 1;
    }
}
