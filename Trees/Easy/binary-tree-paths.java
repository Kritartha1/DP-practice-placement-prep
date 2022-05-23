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
//leetcode.com/problems/binary-tree-paths/
//Good qsn
class Solution {
    List<String> l;
    StringBuilder sb;
    public List<String> binaryTreePaths(TreeNode root) {
        l=new ArrayList<>();
        sb=new StringBuilder();
        binaryTreePathshelper(root);
        return l;
    }
    public void binaryTreePathshelper(TreeNode root) {
        if(root==null){
            return;
        } 
        int n=sb.length();
        sb.append(root.val+"");
        if(root.left==null&&root.right==null){
            l.add(sb.toString());
        }
        else{ sb.append("->");
           binaryTreePathshelper(root.left);//after this's been done root.left node has to be kicked out...which will be taken care by the last line of the code
           binaryTreePathshelper(root.right);//after this's been done root.right node has to be kicked out...which will be taken care by the last line of the code
        }
          
        sb.setLength(n);//it will be O(n)
        
    }
}
