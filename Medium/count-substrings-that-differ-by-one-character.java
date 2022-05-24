//leetcode.com/problems/count-substrings-that-differ-by-one-character/
//more depth soln at notebook....
//Approach 1 and Aproach 2: O(n^3). Approach 3: O(n^2) which is an optimization of Approach 2.

//Approach 1:Time O(n^3).Space O(1).
class Solution {
    public int countSubstrings(String s, String t) {
        //
        int m=s.length(),n=t.length(),ans=0;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                int unmatched=0;
                for(int pos=0;i+pos<m&&j+pos<n;++pos){
                    if(s.charAt(i+pos)!=t.charAt(j+pos)&&++unmatched>1){
                        
                        break;
                        //when there will be 1st unmatched character then we got our first Substring in s That Differ by One Character in s
                        //when unmatched >1 ...means there are two unmatched character which violates the substring condition...so break the loop...
                        
                    }
                  
                    ans+=unmatched;
                  
                    //till there is no unmatched ....unmatched =0
                    //when unmatched value will be 1 ..then from the unmatched posn...when we increment pos, our answer will be incremented by 1 ..
                    //eg: s=abcdef . t=abddef
                    //for substring in s starting at i=0 and sybstring at t starting at j=0.
                    //first unmatched pos=i=j=2.
                    //ans=1 ; (abc,abd)
                    //ans=2 ;(abcd,abdd)
                    //ans=3 ; (abcde,abdde)
                    //ans=4 ;(abcdef,abddef)
                    //so four such substrings of one unmatched character satrting at i=0 and j=0 for s and t..
                    //so we got one of the answer..
                    //similarly look for all the substring starting at different value of i and differnet values of j.
                }
            }
        }
        return ans;
    }
}

//Approach 2: O(n^3)=time solution.
class Solution {
    
    public int countSubstrings(String s, String t) {
        int m=s.length(),n=t.length(),ans=0;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(s.charAt(i)!=t.charAt(j)){
                    int l=1;
                    int r=1;
                    while(Math.min(i-l,j-l)>=0&&s.charAt(i-l)==t.charAt(j-l)) ++l;
                    while(i+r<m&&j+r<n&&s.charAt(i+r)==t.charAt(j+r)) ++r;
                    ans+=l*r;
                }
            }
        }
        return ans;
    }
}
//Approach 3: //O(n^2)=time solution.
              //O(n^2)=space
//Logic : same as approach 2.
class Solution {
   
    public int countSubstrings(String s, String t) {
        int m=s.length(),n=t.length(),ans=0;
        int[][] dpl=new int[m+1][n+1];
        int[][] dpr=new int[m+1][n+1];
        for(int i=1;i<=m;i++){
            for(int j=1;j<=n;j++){
                if(s.charAt(i-1)==t.charAt(j-1)){
                    dpl[i][j]=1+dpl[i-1][j-1];//substring which are equal till (i-1,j-1) index and different or ends at (i,j).
                }
            }
        }
        for(int i=m;i>0;--i){
            for(int j=n;j>0;--j){
                if(s.charAt(i-1)==t.charAt(j-1)){
                    dpr[i-1][j-1]=1+dpr[i][j];//substring which are equal from starting index=(i-1,j-1) 
                }
            }
        }
        
         for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(s.charAt(i)!=t.charAt(j)){
                    ans+=(1+dpl[i][j])*(1+dpr[i+1][j+1]);
                }
            }
        }
        return ans;
    }
}
