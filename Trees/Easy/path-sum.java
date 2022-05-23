//leetcode.com/problems/path-sum/
//Approach 1: recursive
class Solution {
    public boolean hasPathSum(TreeNode root, int targetSum) {
        if(root==null){
            return false;
        }
        if(root.val==targetSum&&root.left==null&&root.right==null){
            return true;
        }
        
        return hasPathSum(root.left,targetSum-root.val)||hasPathSum(root.right,targetSum-root.val);
        
    }
}

//Approach 2: slower --iterative
class Solution {
    public boolean hasPathSum(TreeNode root, int targetSum) {
        if(root==null){
            return false;
        }
        Stack<TreeNode> st=new Stack<>();
        Stack<Integer> value=new Stack<>();
        st.push(root);
        value.push(targetSum);
        while(!st.isEmpty()){
            TreeNode t=st.pop();
            int v=value.pop();
            if(t.left==null&&t.right==null&&t.val==v){
                return true;
            }
            if(t.left!=null){
                st.push(t.left);
                value.push(v-t.val);
            }
            if(t.right!=null){
                st.push(t.right);
                value.push(v-t.val);
            }
            
        }
        return false;
        
    }
}
