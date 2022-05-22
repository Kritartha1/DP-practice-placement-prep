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
 
//leetcode.com/problems/subtree-of-another-tree/
//Approach 1:
 
class Solution {
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        return kmp(serialize(root),serialize(subRoot));
    }
    
    boolean kmp(String s,String p){
        int n=s.length(),m=p.length();
        int[] lps=LPS(p);
        for(int i=0,j=0;i<n;i++){
            while(s.charAt(i)!=p.charAt(j)&&j>0) j=lps[j-1];
            if(s.charAt(i)==p.charAt(j)) ++j;
            if(j==m) return true;
            
        }
        return false;
    }
    
    int[] LPS(String s){
        int m=s.length();
        int[] lps=new int[m];
        for(int i=1,j=0;i<m;i++){
            while(s.charAt(i)!=s.charAt(j)&&j>0) j=lps[j-1];
            if(s.charAt(i)==s.charAt(j)) lps[i]=++j;
        }
        return lps;
    }
    
    String serialize(TreeNode root){
        StringBuilder sb=new StringBuilder();
        serialize(root,sb);
        return sb.toString();
    }
    void serialize(TreeNode root,StringBuilder sb){
        if(root==null){
            sb.append("#");
            return;
        }
        sb.append(","+root.val);
        serialize(root.left,sb);
        serialize(root.right,sb);
    }
    
}

////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//Approach 2:

class Solution {
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        if(isIdentical(root,subRoot)){
            return true;
        }
        // if(root==null&&subRoot==null){
        //     return true;
        // }
        else if((root==null&&subRoot!=null)||(root!=null&&subRoot==null)){
            return false;
        }
        
        
        return isSubtree(root.left,subRoot)||isSubtree(root.right,subRoot);
    }
    boolean isIdentical(TreeNode root,TreeNode subRoot){
        if((root==null&&subRoot!=null)||(subRoot==null&&root!=null)){
            return false;
        }else if(root==null&&subRoot==null){
            return true;
        }
        return root.val==subRoot.val&&isIdentical(root.left,subRoot.left)&&isIdentical(root.right,subRoot.right);
    }
}
