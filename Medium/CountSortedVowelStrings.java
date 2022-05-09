//leetcode.com/problems/count-sorted-vowel-strings/

//Approach 1: Top down..worst case time complexity
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

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

//Approach 2:
class Solution {
    public int countVowelStrings(int n) {
        
        // time: O(n)
        // space: O(1)
        // just think about the mathematical induction
        // if we know all the string of len k, so the string of len k + 1 will be
        // 1 add a before all string of len k
        // 2 add e before the string of len k, which is starts with or after e
        // 3 add i before the string of len k, which starts with or after i
        // 4 add o before the string of len k, which starts with or after o
        // 5 add u before the string of len k, which starts with or after u
        
        int a=1,e=1,i=1,o=1,u=1;
        
        while(n>1){
            a=a+e+i+o+u;  // a, e, i, o, u -> aa, ae, ai, ao, au
            e=e+i+o+u;    // e, i, o, u -> ee, ei, eo, eu 
            i=i+o+u;      // i, o, u -> ii, io, iu
            o=o+u;        // o, u -> oo, ou
            u=u;          // u -> uu
            --n;
        }
        
        return a+e+i+o+u;
    }
}

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//Appraoch 3: P&C
class Solution {
    public int countVowelStrings(int n) {
        
        //(n+4)C4 or (n+4)Cn
        
        //https://leetcode.com/problems/count-sorted-vowel-strings/discuss/918498/JavaC++Python-DP-O(1)-Time-and-Space/822478
        
        //Simple Permutation and combination using stick method...or partition method
        return ((n+4)*(n+3)*(n+2)*(n+1))/24;
    }
}

//Approach 4: Bottom up
class Solution {
    public int countVowelStrings(int n) {
        int[][] dp=new int[n+1][6];
        
        //dp[n][k] means the number of strings constructed by at most k different characters.

        // If k = 1, use only u
        // If k = 2, use only o,u
        // If k = 3, use only i,o,u
        // If k = 4, use only e,i,o,u
        // If k = 5, use only a,e,i,o,u
        
        //vowels[]={'a','e','i','o','u'}
        //           0   1   2   3   4
        
        //dp[i-1][j]=string of length i-1 using atmost j vowels from idx (4-j+1) to 4..
        //here leading character will be vowel (4-j+1) ..i.e if j=3 or k=3, leading vowel will be i.
        
        //dp[i][j-1]=string of length i using atmost j-1 vowels from idx (4-(j-1)+1) to 4..
        //leading vowel will not be same as (4-j+1) or j=3, then leading  vowel won't be i..it will be either o or u..
        
        
        for(int i=1;i<=n;i++){
            for(int j=1;j<=5;j++){
                
                dp[i][j]=dp[i][j-1]+(i>1?dp[i-1][j]:1);
            }
        }
        
        return dp[n][5];
    }
}
