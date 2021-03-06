//leetcode.com/problems/maximum-depth-of-binary-tree/
class Solution {//O(n)===space and time complexity
    public int maxDepth(TreeNode root) {
        if(root==null){
            return 0;
        }
        return 1+Math.max(maxDepth(root.left),maxDepth(root.right));
    }
}
