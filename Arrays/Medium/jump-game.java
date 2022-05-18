//leetcode.com/problems/jump-game/
class Solution {
    public boolean canJump(int[] nums) {
        int ladder=0;
        int n=nums.length;
        int i=0;
        for(;i<n&&i<=ladder;i++){
            ladder=Math.max(ladder,nums[i]+i);
            
        }
        
        return i==n;
        
    }
}
