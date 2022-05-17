//leetcode.com/problems/subarray-sum-equals-k/
class Solution {
    public int subarraySum(int[] nums, int k) {
        HashMap<Integer,Integer> mp=new HashMap<>();
        int n=nums.length;
        int s=0;
        int ans=0;
        mp.put(0,1);//when the subarray is the full array, and it gives us an answer, then total sum must be k, so y=k-k=0. 0 must be present in the hashmap.
        
        //if running sum till ith index is x
        //and prefix sum of index j<i is  y.
        //then x-y =k. So, y=x-k.
        //so for running sum x, we need to find a previous prefix sum y=x-k, then the subarray between j and i will fetch the required k sum
        
        for(int i=0;i<n;i++){
            s+=nums[i];//prefix sum
            ans+=mp.getOrDefault(s-k,0);
            mp.put(s,mp.getOrDefault(s,0)+1);
        }
        return ans;
    }
}
