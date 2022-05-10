//leetcode.com/problems/remove-duplicates-from-sorted-array/
class Solution {
    public int removeDuplicates(int[] nums) {
        int n=nums.length;
        int i=0,j=0;
        while(j<n){
            if(nums[i]!=nums[j]){
                nums[++i]=nums[j];
            }
            ++j;
        }
        
        return i+1;
    }
}
