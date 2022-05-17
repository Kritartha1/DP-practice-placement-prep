//leetcode.com/problems/maximum-points-you-can-obtain-from-cards/

//Approach 1:sliding window
class Solution {
    //sliding window technique
    public int maxScore(int[] cardPoints, int k) {
      
        int n=cardPoints.length;
        int sum=0;
        
        //idea is to get a window of size n-k and look for the window that gives minimum sum.
        //if window gives minimum sum, then total k elements from left and right from the window will fetch max sum.
        //i.e  sum of k side elements=total sum-window sum
        //sum of k side elements max ====window sum must be minimum...
        
        int i=0;
        int j=0;
        int size=n-k;//size of window
        int minSum=Integer.MAX_VALUE;
        int s=0;
      
        while(j<n){
            s+=cardPoints[j];
            sum+=cardPoints[j];
            
            if(j-i+1>size){
                s-=cardPoints[i++];
            }
            if(j-i+1==size){
              minSum=Math.min(s,minSum);
            }
            ++j;
        }
        return sum-minSum;
    }
}

//Approach 2: prefix sum and suffix sum approach
class Solution {
    public int maxScore(int[] cardPoints, int k) {
        //leetcode.com/problems/maximum-points-you-can-obtain-from-cards/discuss/597825/Simple-Clean-Intuitive-Explanation-with-Visualization
        int n=cardPoints.length;
        int[] prefixSum=new int[n+1];
        int[] suffixSum=new int[n+1];
        
        for(int i=0;i<n;i++){
            prefixSum[i+1]+=prefixSum[i]+cardPoints[i];
            suffixSum[n-i-1]+=cardPoints[n-i-1]+suffixSum[n-i];
        }
        
        int max=-1;
        for(int i=0;i<=k;i++){
            max=Math.max(max,prefixSum[i]+suffixSum[n-k+i]);
        }
        return max;
        
    }
}
