//leetcode.com/problems/majority-element/
//Approach 4 is the best
//Approach 1: O(nlogn)
class Solution {
    public int majorityElement(int[] nums) {
        Arrays.sort(nums);
        int n=nums.length;
        return nums[n/2];
    }
}
//Approach 2: Randomization. Max time : infinity. Usual time complexity: linear time.
class Solution {
    //randomization....
    public int majorityElement(int[] nums) {
        Random rand=new Random();
        int minCount=nums.length/2;
        while(true){
            int num=nums[rand.nextInt(nums.length)];
            if(count(nums,num)>minCount){
                return num;
            }
        }
    }
    public int count(int[] nums,int num){
        int c=0;
        for(int i=0;i<nums.length;i++){
            if(nums[i]==num){
                ++c;
            }
        }
        return c;
    }
}
//Approach 3: Divide and conquer
//Divide and conquer
class Solution {
    public int majorityElement(int[] nums) {
        return majorityEle(nums,0,nums.length-1);
    }
    public int majorityEle(int[] nums,int l,int h){
        if(l==h){
            return nums[l];
        }
        int m=(h-l)/2+l;
        int left=majorityEle(nums,l,m);//look for the answer in the left half
        int right=majorityEle(nums,m+1,h);//look for the answer in the right half
        if(l==h){//if both agrees...then that is the answer
            return left;
        }
        int lc=count(nums,left,l,h);//else count the occurences of the answer of left half in the entire array
        int rc=count(nums,right,l,h);//count the the occurences of the answer of right half in the entire array
        
        return lc>rc?left:right;//answer is the winner among them.
    }
    public int count(int[] nums,int num,int l,int h){
        int c=0;
        for(int i=l;i<=h;i++){
            if(nums[i]==num){
                c++;
            }
        }
        return c;
    }
}
//Approach 4:Boyer Moore voting algorithm. Best algo
class Solution {
    public int majorityElement(int[] nums) {
        //Boyer Moore voting algorithm
        int count=0;
        Integer ele=null;
        for(int num:nums){
            if(count==0){
                ele=num;
            }
            count+=(ele==num?1:-1);
        }
        return ele;
    }
}
