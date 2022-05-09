//leetcode.com/problems/count-sorted-vowel-strings/

class Solution {
    
    char[] v={'a','e','i','o','u'};
    
    int[][] dp;
    HashMap<Character,Integer> mp;
    int ans;
    
    public int countVowelStrings(int n) {
        
        mp=new HashMap<>();
        
        for(int i=0;i<5;i++){
            mp.put(v[i],i);
        }
        
        dp=new int[5][n];//dp table --->dp[i][j]=string starting at vowel[i] of length j
        
        for(int row[]:dp){
            Arrays.fill(row,-1);
        }
        
        ans=0;
        fncn("",n);
        
        return ans;
    }
    
    public int fncn(String s,int n){
        
        int l=s.length();
        
        if(l==n){
        
            ans++;
            return 1;
            
        }
        
        int m=n-l;
        
        if(l>0&&dp[mp.get(s.charAt(l-1))][m]!=-1){
            
            ans+=dp[mp.get(s.charAt(l-1))][m];
            return dp[mp.get(s.charAt(l-1))][m];
            
        }
       
        int temp=0;
        
        for(int i=0;i<5;i++){
            
            String k=s+v[i];
            
            if(k.length()==1||s.charAt(l-1)<=v[i]){
                
                dp[mp.get(v[i])][m-1]=fncn(k,n);
                temp+=dp[mp.get(v[i])][m-1];
            }
            
            
            
        }
        if(l==0){
            return 0;//to avoid situation of l-1<0 ,we just put 0 here...
            //kyuki baad me final answer ans variable me aise bhi stored hai....
        }else{
            return dp[mp.get(s.charAt(l-1))][m-1]=temp;
        }
        
    }
    
}
