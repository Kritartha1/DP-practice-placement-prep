//leetcode.com/problems/move-zeroes/
//Approach 1:
class Solution {
    public void moveZeroes(int[] nums) {
        int n=nums.length;
        int i=0,j=0;
        while(i<n&&nums[i]!=0){
            ++i;
        }
        j=i;
        while(j<n){
            if(nums[j]==0){
                while(j<n&&nums[j]==0){
                    ++j;
                }
            }else{
                nums[i++]=nums[j];
                // if(i==n)break;
                nums[j]=0;
            }
        }
    }
}

//\\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\

//Approach 2:
//leetcode.com/problems/move-zeroes/discuss/172432/THE-EASIEST-but-UNUSUAL-snowball-JAVA-solution-BEATS-100-(O(n))-+-clear-explanation
class Solution {
    public void moveZeroes(int[] nums) {
        int n=nums.length;
        int size_ball=0;
        
        for(int i=0;i<n;i++){
            if(nums[i]==0){
                size_ball++;
            }else if(size_ball>0){
                int temp=nums[i];
                nums[i]=0;
                nums[i-size_ball]=temp;
            }
        }
        
    }
}

//Approach 3;
class Solution {
    public void moveZeroes(int[] nums) {
        int n=nums.length;
        int insert_pos=0;//posn after last non zero element..
        //let last non zero pos =-1 which is just imaginary not real..
        //so next_insert position will be 0.
        
        for(int i=0;i<n;i++){
            if(nums[i]!=0){
                nums[insert_pos++]=nums[i];
            }
        }
        
        // Fill remaining space with zeros
        while(insert_pos<n){
            nums[insert_pos++]=0;
        }
        
    }
}
