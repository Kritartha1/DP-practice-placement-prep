//leetcode.com/problems/find-all-duplicates-in-an-array/
class Solution {
    public List<Integer> findDuplicates(int[] nums) {
        List<Integer> ans=new ArrayList<>();
        for(int i=0;i<nums.length;i++){
            int a=Math.abs(nums[i])-1;
            if(nums[a]<0){
                ans.add(a+1);
            }else{
                nums[a]=-1*nums[a];
            }
        }
        return ans;
    }
}
