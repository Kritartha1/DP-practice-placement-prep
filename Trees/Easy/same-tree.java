//leetcode.com/problems/same-tree/
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
//Approach 1:
class Solution {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if(p==null&&q==null){
            return true;
        }else if(p==null||q==null){
            return false;
        }
        return p.val==q.val&&isSameTree(p.left,q.left)&&isSameTree(p.right,q.right);
    }
}

//Approach 2:
class Solution {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if(p==null&&q==null){
            return true;
        }else if(p==null||q==null){
            return false;
        }
        Stack<TreeNode[]> st=new Stack<>();
        st.push(new TreeNode[]{p,q});
        while(!st.isEmpty()){
            TreeNode[] t=st.pop();
            if(t[0].val!=t[1].val){
                return false;
            }
            if(t[0].left==null&&t[1].left==null){
                //
            }
            else if(t[0].left!=null&&t[1].left!=null){
                st.push(new TreeNode[]{t[0].left,t[1].left});
            }
            else{
                return false;
            }
            if(t[0].right==null&&t[1].right==null){
                //
            }
            else if(t[0].right!=null&&t[1].right!=null){
                st.push(new TreeNode[]{t[0].right,t[1].right});
            }
            else{
                return false;
            }
            
        }
        return true;
    }
}

//Approach 3
class Solution {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if(p==null&&q==null){
            return true;
        }else if(p==null||q==null){
            return false;
        }
        Stack<TreeNode[]> st=new Stack<>();
        st.push(new TreeNode[]{p,q});
        while(!st.isEmpty()){
            TreeNode[] t=st.pop();
            if(t[0]==null&&t[1]==null){
                continue;
            }
            if(t[0]==null||t[1]==null){
                return false;
            }
            if(t[0].val!=t[1].val){
                return false;
            }
            st.push(new TreeNode[]{t[0].left,t[1].left});
            st.push(new TreeNode[]{t[0].right,t[1].right});
            
            
            
        }
        return true;
    }
}
