//leetcode.com/problems/divisor-game/

//Approach 1: Mathematical

//logic: if n is even: we choose 1
//then n-x=n-1 is odd..
//
//if n id odd: if n==1 , then lose directly.
//else divisor or odd must be n, so n-x=even.
//then  we will again shift to even condition.
//ans by choosing evenwe will aways win.
class Solution {
    public boolean divisorGame(int n) {
        return n%2==0;
    }
}



//Approach 2: Top down
class Solution {
    int dp[]=new int[1001];
    
    public boolean divisorGame(int n) {
        
       if(dp[n]==0){
           
           for(int i=1;dp[n]!=1&&i<=n/2;i++){
               if(n%i==0){
                   dp[n]=(divisorGame(n-i))?-1:1;
               }else{
                   dp[n]=-1;
               }
               
               //if dp[n]==1 break the loop.
               
           }
       }
       
        return dp[n]==1;
    }
}

//Approach 3: Bottomup
//Idea:
// dp[i] indicates the result of the game for the given number i and for the player who started the game.
// Alice will try all factors and choose the one which gives his opponent a losing value.

//leetcode.com/problems/divisor-game/discuss/274608/Simple-DP-Java-Solution
class Solution {
    public boolean divisorGame(int n) {
        boolean[] dp=new boolean[n+1];
        dp[1]=false;
        
        for(int i=2;i<=n;i++){
            for(int j=1;j<i;j++){
                if(i%j==0){
                    if(dp[i-j]==false){
                        dp[i]=true;
                        break;
                    }
                }
            }
        }
        
        return dp[n];
    }
}

//Approach 4: Top down

class Solution {
    Boolean dp[];
    public boolean divisorGame(int n) {
        dp=new Boolean[n+1];
        dp[0]=true;//to look for the case when n-n/i =0 or i=1...so this dp[0] is estaablished forcefully.
        dp[1]=false;
        solve(n);
        return dp[n];
    }
    
    public boolean solve(int n){
        if(dp[n]!=null){
            return dp[n];
        }
        dp[n]=false;
        
        for(int i=1;i*i<=n;i++){
            if(n%i==0){
                if(!solve(n-i)||!solve(n-(n/i))){
                    dp[n]=true;
                    break;
                }
            }
        }
        
        return dp[n];
    }
}

