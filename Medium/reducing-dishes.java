//leetcode.com/problems/reducing-dishes/

//Approach 1 << Approach 2 <<<< Appraoch 3.

//Approach 1:O(n^2)---recursive

class Solution {
    Integer[][] dp;
    public int maxSatisfaction(int[] s) {
        Arrays.sort(s);
        int m=s.length;
        dp=new Integer[m+1][m+2];
        return solve(0,1,s);
        
        
    }
    int solve(int i,int time,int[] s){
        if(i>=s.length){
            return 0;
        }else if(dp[i][time]!=null){
            return dp[i][time];
        }
        int ans=0;
        ans=Math.max(s[i]*time+solve(i+1,time+1,s),solve(i+1,time,s));
        return dp[i][time]=ans;
        
    }
}

//Approach 2:O(n^2)---bottom up
class Solution {
    
    public int maxSatisfaction(int[] s) {
        Arrays.sort(s);
        int m=s.length;
        int[][] dp=new int[m+1][m+2];
        for(int[] row:dp){
            Arrays.fill(row,Integer.MIN_VALUE);
        }
        for(int j=0;j<m;j++){
            dp[j][0]=0;
            dp[j][1]=s[j];
        }
        dp[0][1]=s[0];
        // return solve(0,1,s);
        int ans=0;
        //for the dp table we are just capturing the max like time coefficient for each cases.
        //and for some cases life time coefficient can be <0..but we will be handling that case in ans= Math.max(ans,dp[][]);
        //where min val of ans=0.
        for(int i=1;i<m;i++){
            for(int j=2;j<=i+1;j++){
                dp[i][j]=Math.max(s[i]*j+dp[i-1][j-1],dp[i-1][j]);
                ans=Math.max(ans,dp[i][j]);
                
            }
        }
        return ans;
        
        
    }
}

//Approach 3:Fastest : O(nlogn)
class Solution {
    
    public int maxSatisfaction(int[] s) {
        Arrays.sort(s);
        int m=s.length;
        int res=0;
        for(int i=m-1,total=0;i>=0&&s[i]>-total;i--){
            total+=s[i];
            res+=total;
        }
        return res;
        
        
    }
    
}
