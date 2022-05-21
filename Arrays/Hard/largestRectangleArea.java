//leetcode.com/problems/largest-rectangle-in-histogram/
//Approach 1:O(n) time complexity...
class Solution {
    public int largestRectangleArea(int[] heights) {
        //max width for a rectangle with height[i] is r-l-1.
        //where r is the immediate next point which violates height[j]>=height[i] in the right half of i.
        //similarly l for left half of i
        //The meaning of r and l is somewhat confusing, to put them more accurately:
//l: the first coordinate of the bar to the left with height h[l] < h[i].
//r: the first coordinate of the bar to the right with height h[r] < h[i].
        int n=heights.length;
        int[] lessFromLeft=new int[n];
        int[] lessFromRight=new int[n];
        
        lessFromLeft[0]=-1;
        lessFromRight[n-1]=n;
        
        for(int i=1;i<n;i++){
            int p=i-1;
            while(p>=0&&heights[p]>=heights[i]){
                p=lessFromLeft[p];//this line makes the toatal for+while loop =O(n)
            }
            lessFromLeft[i]=p;
        }
        
         for(int i=n-2;i>=0;i--){
            int p=i+1;
            while(p<n&&heights[p]>=heights[i]){
                p=lessFromRight[p];//this line makes the toatal for+while loop =O(n)
            }
            lessFromRight[i]=p;
        }
        
        int ans=0;
        for(int i=0;i<n;i++){
            ans=Math.max(ans,heights[i]*(lessFromRight[i]-lessFromLeft[i]-1));
        }
        return ans;
        
    }
}
