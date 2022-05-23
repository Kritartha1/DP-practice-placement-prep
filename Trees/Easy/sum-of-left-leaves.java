//leetcode.com/problems/sum-of-left-leaves/
//Approach 1: faster
class Solution {
    public int sumOfLeftLeaves(TreeNode root) {
        if(root==null){
            return 0;
        }
        int ans=0;
        if(root.left!=null){
            if(root.left.left==null&&root.left.right==null){
                ans+=root.left.val;
            }else{
                ans+=sumOfLeftLeaves(root.left);
            }
        }
        ans+=sumOfLeftLeaves(root.right);
        return ans;
    }
}

//Approach 2: slower
class Solution {
    public int sumOfLeftLeaves(TreeNode root) {
        int ans=helper(root,false);
        return ans;
        
    }
    int helper(TreeNode root,boolean isLeft){
        if(root==null){
            return 0;
        }
        if(root.left==null&&root.right==null&&isLeft){
            return root.val;
        }
        return helper(root.left,true)+helper(root.right,false);
    }
}
