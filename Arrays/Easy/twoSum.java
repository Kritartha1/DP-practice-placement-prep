//leetcode.com/problems/two-sum/submissions/
class Solution {
    public int[] twoSum(int[] nums, int target) {
        
        HashMap<Integer,Integer> mp=new HashMap<>();
        int n=nums.length;
        
        for(int i=0;i<n;i++){
            if(mp.containsKey(target-nums[i])){
                //putting this condition before putting new val in mp bcoz, there may be duplicate elements in the array...and sum of the duplicates may be the target...if we would have put the duplicate element in the mp , then the val would have got altered, since map doesnot carry duplicate elements..
                
                return new int[]{mp.get(target-nums[i]),i};
            }else{
                mp.put(nums[i],i);
            }
        }
        return new int[0];
    }
}
