class Solution {
  //leetcode.com/problems/sort-colors/
    public void sortColors(int[] nums) {
        
        int zeros=0;
        int ones=0;
        int twos=0;
        
        int n=nums.length;
      
        for(int i=0;i<n;i++){
            zeros=(nums[i]==0)?zeros+1:zeros;
            ones=(nums[i]==1)?ones+1:ones;
        }
       
        twos=n-ones-zeros;
        int i=0;
        
        for(;i<n&&zeros-->0;i++){
            nums[i]=0;
        }
        for(;i<n&&ones-->0;i++){
            nums[i]=1;
        }
        for(;i<n&&twos-->0;i++){
            nums[i]=2;
        }
    }
}

//Approach 2: One pass
//leetcode.com/problems/sort-colors/discuss/681526/Python-O(n)-3-pointers-in-place-approach-explained
class Solution {
    public void sortColors(int[] nums) {
        
        int i=0;
        int p1=0;
        int p2=nums.length-1;
        
        while(i<=p2){
            if(nums[i]==0){
                
                int temp=nums[i];
                nums[i++]=nums[p1];
                nums[p1++]=temp;
                System.out.println(Arrays.toString(nums));
                
            }
            else if(nums[i]==2){
                
                int temp=nums[i];
                nums[i]=nums[p2];
                nums[p2--]=temp;
                System.out.println(Arrays.toString(nums));
                
            }else{
                i++;
            }
            
        }
        
    }
}
