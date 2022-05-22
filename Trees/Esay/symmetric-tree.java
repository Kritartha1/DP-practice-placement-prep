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
//leetcode.com/problems/symmetric-tree/

//Approach 1: recursive ..faster
class Solution {
    public boolean isSymmetric(TreeNode root) {
        if(root==null){
            return true;
        }
       return isIdentical(root.left,root.right);
        
    }
    boolean isIdentical(TreeNode root1,TreeNode root2){
        if(root1==null&&root2==null){
            return true;
        }else if(root1==null||root2==null){
            return false;
        }
        //the above two if and else can be combined in an if statement 
        //if(root1==null||root2==null){return root1==root2;}
        else{
            return (root1.val==root2.val)&&isIdentical(root1.left,root2.right)&&isIdentical(root1.right,root2.left);
        }
    }
}

//Approach 2: Iterative
class Solution {
    //Stack can hold null
    public boolean isSymmetric(TreeNode root) {
        if(root==null){
            return true;
        }
        Stack<TreeNode> st=new Stack<>();
        st.push(root.left);
        st.push(root.right);
        while(!st.isEmpty()){
            TreeNode r=st.pop();
            TreeNode l=st.pop();
            if(r==null&&l==null){
                continue;
            }else if(r==null||l==null||r.val!=l.val){
                return false;
            }
            st.push(l.left);
            st.push(r.right);
            st.push(l.right);
            st.push(r.left);
        }
        return true;
        
    }
   
}
