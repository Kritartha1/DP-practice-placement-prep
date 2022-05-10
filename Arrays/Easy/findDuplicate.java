//leetcode.com/problems/find-the-duplicate-number/submissions/

//Approach 1: Faster
class Solution {
    public int findDuplicate(int[] nums) {
        //floyd's algo
        int n=nums.length;
        int slow=nums[0];
        int fast=nums[nums[0]];
        
        while(slow!=fast){
            slow=nums[slow];
            fast=nums[nums[fast]];
        }
        
        slow=0;
        while(slow!=fast){
            slow=nums[slow];
            fast=nums[fast];
        }
        
        return slow;
        
        
    }
}

//Approach 2:slower
class Solution {
    public int findDuplicate(int[] nums) {
        //floyd's algo
        int n=nums.length-1;
        int duplicate=0;
        
        for(int i=0;i<32;i++){
            int mask=1<<i;
            int base_count=0;
            int nums_count=0;
            
            for(int k=0;k<=n;k++){
                if(k>0&&(mask&k)>0){
                    ++base_count;
                }
                if((mask&nums[k])>0){
                    ++nums_count;
                }
            }
            
            if(nums_count>base_count){
                duplicate|=mask;
            }
        }
        
        return duplicate;
        
        
        
       
        
        
    }
}

//Approach 3: Binary search-----explanation in leetcode solution tab
class Solution {
    public int findDuplicate(int[] nums) {
        int low=1;
        int high=nums.length-1;
        int duplicate=0;
        int n=nums.length-1;
        
        while(low<=high){
            int mid=low+(high-low)/2;
            
            int count=0;
            for(int i=0;i<=n;i++){
                if(nums[i]<=mid){
                    count++;
                }
            }
            
            if(count>mid){
                duplicate=mid;
                high=mid-1;
            }else{
                low=mid+1;
            }
            
        }
        
        return duplicate;
        
    }
}
