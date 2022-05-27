https://leetcode.com/problems/minimum-moves-to-equal-array-elements/
class Solution {
    public int minMoves(int[] nums) {
        //increment n-1 elements is similar to decrementing 1 element..
        //since the main goal is that sab elements end me same honi chahiye..
        //so sab decrementing element each tiem taaki woh minimum element tak aaye...which is nums[i]-min moves...
        //total=sum(nums[i])-(n)*min;
        int N=nums.length,sum=0,min=nums[0];
        for(int i=0;i<N;i++){
            sum+=nums[i];
            min=Math.min(nums[i],min);
        }
        long s=(long)(N)*min;
        return sum-(int)s;
    }
}
