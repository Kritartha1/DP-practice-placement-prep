//leetcode.com/problems/partition-array-for-maximum-sum/
//Approach 1:recursive approach
Top down..
class Solution {
    Integer dp[]=new Integer[501];
    int n;
    public int maxSumAfterPartitioning(int[] arr, int k) {
        n=arr.length;
        return solve(n-1,k,arr);
        
        
    }
    //dp[i]=ans of maxSum if array starts from ith index..
    int solve(int m,int k,int[] arr){
        if(m<0){
            return 0;
        }
        if(dp[m]!=null){
            return dp[m];
        }
        int maxNum=arr[m];
        int ans=0;
        for(int j=m;j>=Math.max(0,m-k+1);j--){
            maxNum=Math.max(maxNum,arr[j]);
            ans=Math.max(ans,((m-j+1)*maxNum)+solve(j-1,k,arr));
        }
        return dp[m]=ans;
    }
}
//Approach 2: Iterative or bottom up
class Solution {
    
    public int maxSumAfterPartitioning(int[] arr, int k) {
        Integer dp[]=new Integer[501];
        int n;
        n=arr.length;
        for(int i=0;i<n;i++){
            int max=arr[i];
            dp[i]=0;
            for(int j=0;j<k;j++){
                int t=i-j;
                if(t<0)break;
                max=Math.max(arr[t],max);
                dp[i]=Math.max(dp[i],max*(j+1)+(t<1?0:dp[t-1]));
                
            }
        }
        return dp[n-1];
       
    }
}
