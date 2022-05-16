//leetcode.com/problems/container-with-most-water/
class Solution {
    public int maxArea(int[] height) {
        // Start with the maximum width container and go to a shorter width container if there is a vertical line longer than the current containers shorter line. This way we are compromising on the width but we are looking forward to a longer length container.
        int n=height.length;
        int max=0;
        int i=0;
        int j=n-1;
        
        while(i<j){
            int h=Math.min(height[i],height[j]);
            max=Math.max(h*(j-i),max);
            if(height[i]>height[j]){
                j--;
            }else{
                i++;
            }
        }
        return max;
    }
}
