//leetcode.com/problems/merge-two-binary-trees/solution/
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

//Approach 1: Recursive
// Time complexity : O(m). A total of mm nodes need to be traversed. Here, mmrepresents the minimum number of nodes from the two given trees.

// Space complexity : O(m). The depth of the recursion tree can go upto m in the case of a skewed tree. In average case, depth will be O(logm).
class Solution {
    public TreeNode mergeTrees(TreeNode root1, TreeNode root2) {
        if(root1==null){
            return root2;
        }
        if(root2==null){
            return root1;
        }
        root1.val+=root2.val;
        root1.left=mergeTrees(root1.left,root2.left);
        root1.right=mergeTrees(root1.right,root2.right);
        return root1;
    }
}

//Approach 2: Iterative
class Solution {
    public TreeNode mergeTrees(TreeNode root1, TreeNode root2) {
        if(root1==null){
            return root2;
        }
        Stack<TreeNode[]> st =new Stack<>();
        st.push(new TreeNode[]{root1,root2});
        while(!st.isEmpty()){
            TreeNode[] t=st.pop();
            if(t[1]==null){//t[0]!=null bcoz the first line and the below two conditions account for that
                continue;
            }
            t[0].val+=t[1].val;
            if(t[0].left==null){//condition 1
                t[0].left=t[1].left;
            }
            else{
                st.push(new TreeNode[]{t[0].left,t[1].left});
            }
            if(t[0].right==null){//condition 2
                t[0].right=t[1].right;
            }
            else{
                st.push(new TreeNode[]{t[0].right,t[1].right});
            }
            
        }
        return root1;
    }
}
