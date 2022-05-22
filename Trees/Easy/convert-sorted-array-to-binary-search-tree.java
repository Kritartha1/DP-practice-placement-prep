//leetcode.com/problems/convert-sorted-array-to-binary-search-tree
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
//Approach 1: O(n) solution --->faster
class Solution {
    public TreeNode sortedArrayToBST(int[] nums) {
        return helper(nums,0,nums.length-1);
        
    }
    //Idea : Since nums is in increasing order..
    //so we can make BST easily..
    //the mid index nums will always make the root..
    //and the elements left to it will go for its left subtree and right elements will account for its right subtree at ease..
    TreeNode helper(int[] nums,int l,int r){
        if(l>r){
            return null;
        }
        int mid=l+(r-l)/2;
        TreeNode root=new TreeNode(nums[mid]);
        root.left=helper(nums,l,mid-1);
        root.right=helper(nums,mid+1,r);
        return root;
    }
    
}

//Approach 2:slower solution--//5 ms stack solution.........probably O(nlogn)--->slower
class Solution {

  class Node {
      TreeNode root;
      int right;
      int left;
      
      Node(TreeNode root, int left,int right) {
          this.root =root;
          this.left = left;
          this.right = right;
     }
  }
 
 
    public TreeNode sortedArrayToBST(int[] nums) {
        int n=nums.length;
        TreeNode root=new TreeNode(0);
        Stack<Node> st=new Stack<>();
        Node node=new Node(root,0,n-1);
        st.push(node);
        while(!st.isEmpty()){
            Node curr=st.pop();
            int mid=curr.left+(curr.right-curr.left)/2;
            curr.root.val=nums[mid];
            if(curr.left<mid){
                curr.root.left=new TreeNode(0);
                st.push(new Node(curr.root.left,curr.left,mid-1));
            }
            if(curr.right>mid){
                curr.root.right=new TreeNode(0);
                st.push(new Node(curr.root.right,mid+1,curr.right));
            }
        }
        return root;
    }
}
