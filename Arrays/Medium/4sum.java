//leetcode.com/problems/4sum/
class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        int n=nums.length;
        List<List<Integer>> ans=new ArrayList<>();
        Arrays.sort(nums);
        
        for(int i=0;i<n-3;i++){
            if(i>0&&nums[i-1]==nums[i]){
                
                continue;
            }
            
            for(int j=i+1;j<n-2;j++){
                if(j>i+1&&nums[j-1]==nums[j]){
                   
                    continue;
                }
                
                int k=j+1;
                int l=n-1;
                int s=nums[i]+nums[j];
                while(k<l){
                    
                    if(s+nums[k]+nums[l]==target){
                        
                        ArrayList<Integer> temp=new ArrayList<>();
                        temp.add(nums[i]);
                        temp.add(nums[j]);
                        temp.add(nums[k]);
                        temp.add(nums[l]);
                        ans.add(temp);
                        while(k<n-2&&nums[k+1]==nums[k]){
                            ++k;
                        }
                        while(k<l&&nums[l-1]==nums[l]){
                            --l;
                        }
                        ++k;
                        --l;
                        
                        
                    }else if(s+nums[k]+nums[l]>target){
                        l--;
                    }else{
                        k++;
                    }
                }
            }
        }
        return ans;
        
    }
}
