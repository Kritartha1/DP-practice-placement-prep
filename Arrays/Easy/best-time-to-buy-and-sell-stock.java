//leetcode.com/problems/best-time-to-buy-and-sell-stock/

//Approach 1: check approach 2 which is better version of approach 1 and time less consuming.....
class Solution {
    public int maxProfit(int[] prices) {
        
        int buy=prices[0];
        int maxProfit=0;
        int i=0;
        int n=prices.length;
        
        while(i+1<n){
            
            int profit=0;
            
            while(i<n-1&&prices[i+1]<=prices[i]){
                ++i;
            }
            
            buy=Math.min(buy,prices[i]);
            
            while(i<n-1&&prices[i+1]>prices[i]){
                ++i;
            }
            
            profit+=prices[i]-buy;
            
            maxProfit=Math.max(profit,maxProfit);
        }
        
        return maxProfit;
        
    }
}

//Approach 2:
class Solution {
    
    public int maxProfit(int[] prices) {
        
        int buy=prices[0];
        int maxProfit=0;
        int n=prices.length;
        
        for(int i=0;i<n;i++){
            buy=Math.min(buy,prices[i]);
            maxProfit=Math.max(maxProfit,prices[i]-buy);
        }
        
        return maxProfit;
        
    }
}

//Approach 3:
class Solution {
    public int maxProfit(int[] prices) {
        int n=prices.length;
        int maxR=prices[n-1];
        int ans=0;
        for(int i=n-2;i>=0;--i){
            maxR=Math.max(maxR,prices[i+1]);
            ans=Math.max(maxR-prices[i],ans);
        }
        return ans;
        
    }
}

