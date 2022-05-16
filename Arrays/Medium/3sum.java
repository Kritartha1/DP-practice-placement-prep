//leetcode.com/problems/3sum/
class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        int n=nums.length;
        Arrays.sort(nums);
        List<List<Integer>> ans=new ArrayList<>();
        for(int i=0;i<n-2;i++){
            if(i>0&&nums[i-1]==nums[i]){
                continue;//to avoid redundant solution
            }
            int a =-nums[i];
            int j=i+1;
            int k=n-1;
            while(j<k){
                if(nums[j]+nums[k]<a){
                    j++;
                }else if(nums[j]+nums[k]>a){
                    k--;
                }else{
                    ArrayList<Integer> temp=new ArrayList<>();
                    temp.add(nums[i]);
                    temp.add(nums[j]);
                    temp.add(nums[k]);
                    ans.add(temp);
                    while(j<k&&j<n-1&&nums[j+1]==nums[j]){
                        ++j;
                    }
                    while(j<k&&nums[k-1]==nums[k]){
                        --k;
                    }
                    ++j;
                    --k;
                }
            }
        }
        return ans;
    }
}
